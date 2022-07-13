package primas.esercizio1;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Automobile deserialize(String jsonString, Class<Automobile> class1) throws ParseException {

		// elimino le graffe dal json
		String newJson = jsonString.substring(1, jsonString.length() - 1);

		List<String> fields = Arrays.asList(newJson.split(","));

		Map<String, String> objMap = new HashMap<String, String>();
		System.out.println("fields " + fields);
		Automobile auto = new Automobile();

		for(int i = 0; i< fields.size(); i++) {

			String [] keyVal = fields.get(i).split(":"); 
			String key = keyVal[0].replace("\"", "").trim();
			String value = keyVal[1].replace("\"", "").trim();

			objMap.put(key, value);

		}

			String subActualLevel = jsonString.substring(1, jsonString.length() - 1);
			System.out.println("sub " + subActualLevel);
			String nestedObj = findNestedObjName(subActualLevel, class1);
			System.out.println("nest" + nestedObj);

			if (isPresentNestedObj(subActualLevel)) {
				String s = subActualLevel.substring(subActualLevel.lastIndexOf(nestedObj) + nestedObj.length() + 2,
						subActualLevel.lastIndexOf("}") - 1).replace("\"", "");
				System.out.println("s " + s);
				String[] sSplit = s.split(",");
				String nestedValue = sSplit[0];
				String nestedValue2 = sSplit[1];

				String[] nestedValueArr = nestedValue.split(":");
				String[] nestedValue2Arr = nestedValue2.split(":");

				String nestedK = nestedValueArr[0];
				String nestedV = nestedValueArr[1];
				String nestedK2 = nestedValue2Arr[0];
				String nestedV2 = nestedValue2Arr[1];

				System.out.println("k " + nestedK);
				System.out.println("v " + nestedV);

				System.out.println("k " + nestedK2);
				System.out.println("v " + nestedV2);

				Assicurazione ass = new Assicurazione();
				setAssicurazione(nestedV, nestedV2, ass);
				System.out.println(ass);
				auto.setAssicurazione(ass);

			}
				if (objMap.containsKey("anno")) {
					auto.setAnno(Integer.valueOf((objMap.get("anno"))));
				}

				if (objMap.containsKey("marca")) {
					auto.setMarca(objMap.get("marca"));
				}

				if (objMap.containsKey("modello")) {
					auto.setModello(objMap.get("modello"));
				}
			

			return auto;

		}

		private boolean isPresentNestedObj(String subActualLevel) {

			return subActualLevel.contains("{") && subActualLevel.contains("}");

		}

		private String findNestedObjName(String jsonString, Class<?> clazz) {

			List<String> fields = Arrays.asList(jsonString.split(","));

			for (int i = 0; i < fields.size(); i++) {
				if (fields.get(i).contains("{")) {
					String[] keyVal = fields.get(i).split(":");
					System.out.println("//////////" + (keyVal[0]));
					//				System.out.println("//////////"+(keyVal[1].replace("{", "")));
					//
					return keyVal[0];
				}
			}

			return null;
		}



		private void setAssicurazione (String dataInizio, String dataFine, Assicurazione ass) throws ParseException {

			String[] splitDateInizio = dataInizio.split("-");

			Date dataInizioContratto = new GregorianCalendar(Integer.valueOf(splitDateInizio[2]), Integer.valueOf(splitDateInizio[1])-1, Integer.valueOf(splitDateInizio[0])).getTime();
			//System.out.println(dataInizioContratto);

			SimpleDateFormat sdfInizioContratto = new SimpleDateFormat("dd-MM-yyyy");
			String dateInizio = sdfInizioContratto.format(dataInizioContratto);
			//System.out.println(dateInizio);
			Date dateI = sdfInizioContratto.parse(dateInizio);
			ass.setInizioContratto(dateI);
			//System.out.println(dateI);

			//fine contratto
			String[] splitDateScadenza = dataFine.split("-");

			Date dataScadenzaContratto = new GregorianCalendar(Integer.valueOf(splitDateScadenza[2]), Integer.valueOf(splitDateScadenza[1])-1, Integer.valueOf(splitDateScadenza[0])).getTime();
			//System.out.println(dataScadenzaContratto);

			SimpleDateFormat sdfScadenzaContratto = new SimpleDateFormat("dd-MM-yyyy");
			String dateScadenza = sdfScadenzaContratto.format(dataScadenzaContratto);
			Date dateF = sdfScadenzaContratto.parse(dateScadenza);
			ass.setScadenzaContratto(dateF);
			//System.out.println(dateScadenza);

		}
	
	
}

