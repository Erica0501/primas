package primas.esercizio1;

import java.lang.reflect.Field;

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

	public Automobile deserialize(String jsonString, Class<Automobile> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}
