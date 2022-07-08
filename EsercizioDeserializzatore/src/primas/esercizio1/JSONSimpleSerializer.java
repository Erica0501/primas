package primas.esercizio1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
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

	/*
	 * un json inizia con {
	 * finisce con }
	 * ogni campo è separato da virgola
	 * ogni campo è chiave-valore dove la chiave è sempre racchiusa tra " e finisce con :
	 * il valore può essere primitivo, String o object
	 * nel caso di object dopo i due punti ci sarà una {
	 * nel caso di array dopo i due punti ci sarà una [
	 */
	public Automobile deserialize(String jsonString, Class<Automobile> class1) {

		// elimino le graffe dal json
		String newJson = jsonString.substring(1, jsonString.length()-1);

		List<String> fields = Arrays.asList(newJson.split(","));
		Map<String, String> objMap = new HashMap<String, String>();

		Automobile auto = new Automobile();

		for(int i = 0; i< fields.size(); i++) {

			String [] keyVal = fields.get(i).split(":"); 
			String key = keyVal[0].replace("\"", "").trim();
			String value = keyVal[1].replace("\"", "").trim();

			objMap.put(key, value);

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

//	public Automobile met(String jsonString) throws IOException, ClassNotFoundException {
//		
//		Automobile auto = new Automobile();
//		
//		FileInputStream fis = new FileInputStream(jsonString);
//		ObjectInputStream ois = new ObjectInputStream(fis);
//
//		int anno = ois.readInt();
//		String marca = (String) ois.readObject();
//		String modello = (String) ois.readObject();
//	
//		ois.close();
//		
//		auto.setAnno(anno);
//		auto.setMarca(marca);
//		auto.setModello(modello);
//		
//		return auto;
//	}
	
	
}
