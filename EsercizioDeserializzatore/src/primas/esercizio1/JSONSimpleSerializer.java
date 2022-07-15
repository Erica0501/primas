package primas.esercizio1;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class JSONSimpleSerializer {

	public void serialize (Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder jsonString = new StringBuilder("{\n");
		//check if fields have annotation
		Class<?> classObj = obj.getClass();
		Field[] attributes = classObj.getDeclaredFields();
		System.out.println("Num attributi: " + attributes.length);
		//serialize
		for (int i = 0; i < attributes.length; i++) {
			if(attributes[i].getAnnotation(JSONSerialField.class) != null) {
				System.out.println(attributes[i].getType());
				System.out.println("Sto serializzando l'attributo " 
						+ attributes[i].getName());
				jsonString.append("\t");
				jsonString.append("\"");
				jsonString.append(attributes[i].getName());
				jsonString.append("\"");
				jsonString.append(":");
				//fix accessibility to private attributes
				attributes[i].setAccessible(true);
				jsonString.append("\"");
				jsonString.append(attributes[i].get(obj));
				jsonString.append("\"");
				if (i < attributes.length - 2) {
					jsonString.append(",");
				}
				jsonString.append("\n");
			} else {
				System.out.println("Ho omesso di serializzare l'attributo "
						+ attributes[i].getName());
			}
		}
		jsonString.append("}");
		System.out.println(/*"Stringa serializzata:\n " +*/ jsonString);
	}
	// elimino le graffe all'inizio e alla fine
	public String eliminaGraffe(String jsonString) {
		
		if(jsonString.startsWith("{") && jsonString.endsWith("}")) {
			return jsonString.substring(1, jsonString.length() - 1).trim();
		} 
			return jsonString;
		
	}
	
	public String valoreOggettoAnnidato(String jsonString, String nomeOggAnnidato) {
		
		return eliminaGraffe(jsonString.substring(jsonString.lastIndexOf(nomeOggAnnidato) + nomeOggAnnidato.length() + 1, jsonString.lastIndexOf("}") + 1).replace("\"", ""));
	}
	
	public void setValoriAssicurazione(String newJson, Assicurazione assic) {
		// TODO aggiungere controllo
		String[] arrayFields = newJson.split(",");
		
		for(int i = 0; i < arrayFields.length; i++) {
			String[] arrayKV = arrayFields[i].split(":");
			
			if(arrayKV[0].equals("inizioContratto")) {
				assic.setInizioContratto(convertiTipoData(arrayKV[1]));
			}
			if(arrayKV[0].equals("scadenzaContratto")) {
				assic.setScadenzaContratto(convertiTipoData(arrayKV[1]));
			}
		}
	}
	
	public LocalDate convertiTipoData(String data) {
		
		LocalDate localDate = LocalDate.parse(data);
		
		return localDate;
	}
	
	public String restituisciJson(String nomeOggettoAnnidato, String jsonString) {
		
		String[] arrayFields = jsonString.split("");
		System.out.println("json string di partenza "+Arrays.toString(arrayFields));
		boolean isNested = false;
		String newJson = "";
		
		for(int i = 0; i < arrayFields.length; i++) {
			
			if(arrayFields[i].contains("{")) {
				
				isNested = true;
			}
			if(!isNested) {
				newJson += arrayFields[i];
			}
			if(arrayFields[i].contains("}")) {
				
				isNested = false;
			}
		}	
		
		
		char[] newJsonChars = newJson.toCharArray();
		System.out.println("char array "+Arrays.toString(newJsonChars));
		newJson = ""; 
		for(int i = 0; i < newJsonChars.length; i++) {
			if(newJsonChars.length != i + 1 && (newJsonChars[i] == '\"' && newJsonChars[i + 1] == '\"') || newJsonChars[i] == ']') {
				newJson += newJsonChars[i] + "".trim();
				System.out.println("new json "+newJson);
			} else {
				newJson += newJsonChars[i];
				System.out.println("else new json "+newJson);
			}
			
		}
		return newJson;
	}
	
	public void setValoriAutomobile(String jsonString, Automobile auto) {

		jsonString = jsonString.replace("\"", "").trim();
		String[] fields = jsonString.split(",");
		
		for (int i = 0; i < fields.length; i++) {
			String[] arrayKV = fields[i].split(",");
			arrayKV = fields[i].split(":");
			
			if (arrayKV[0].trim().equals("marca")) {
				auto.setMarca(arrayKV[1]);
			}
			if (arrayKV[0].trim().equals("modello")) {
				auto.setModello(arrayKV[1]);
			}
			if (arrayKV[0].trim().equals("allestimento")) {
				String[] allestimento = costruttoreArray(jsonString, arrayKV[0]);
				auto.setAllestimento(allestimento);
			}
			if (arrayKV[0].trim().equals("anno")) {
				auto.setAnno(Integer.valueOf(arrayKV[1]));
			}
		}
	}
	
	public String[] costruttoreArray(String arrayRaw, String nomeAttributo) {
		
		arrayRaw = arrayRaw.substring(arrayRaw.lastIndexOf(nomeAttributo) + nomeAttributo.length() + 2, arrayRaw.lastIndexOf("]"));
		String[] stringArray = arrayRaw.split(",");
		return stringArray;
	}

	public Automobile deserialize(String jsonString, Class<Automobile> class1) throws ParseException {

		// elimino le graffe dal json
		System.out.println(jsonString);
		String newJson = eliminaGraffe(jsonString);
		System.out.println("json input "+newJson);
		Automobile auto = new Automobile();
		Assicurazione assi = new Assicurazione();

		String nomeOggAnnidato = null;
		if (contieneOggettoAnnidato(newJson)) {
			
			nomeOggAnnidato = cercaNomeOggettoAnnidato(newJson);
			System.out.println("nome ogg annidato "+nomeOggAnnidato);
			String valoreOggAnnidato = valoreOggettoAnnidato(newJson, nomeOggAnnidato);
			System.out.println("valore ogg annidato "+valoreOggAnnidato);
			setValoriAssicurazione(valoreOggAnnidato, assi);
			
		}
		newJson = restituisciJson(nomeOggAnnidato, newJson);
		setValoriAutomobile(newJson, auto);
		System.out.println("new json input "+newJson);
		auto.setAssicurazione(assi);
		

		return auto;
	}

	private boolean contieneOggettoAnnidato(String subActualLevel) {

		return subActualLevel.contains("{") && subActualLevel.contains("}");

	}

	private String cercaNomeOggettoAnnidato(String jsonString) {

		List<String> fields = Arrays.asList(jsonString.split(","));

		for (int i = 0; i < fields.size(); i++) {
			if (fields.get(i).contains("{")) {
				String[] keyVal = fields.get(i).split(":");
				
				return keyVal[0];
			}
		}

		return null;
	}
}


