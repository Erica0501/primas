package primas.esercizio1;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

public class JSONSimpleSerializer {
	
	
public Object deserialize3(String jsonString, Class<?> class1) throws ParseException {
		
		HashMap<String, String> map = getLevelValue(jsonString, class1);
		//System.out.println("MAPPA ////"+map);

		return null;

	}

	private HashMap<String, String> getLevelValue(String jsonString, Class<?> class1) throws ParseException{
		
		int contatoreLivelli= 0;
		
		for (int i=0; i<jsonString.length(); i++) {
//			char actualC = jsonString.charAt(i);
//			if (actualC == '{') {
//				contatoreLivelli++;
//			}if (actualC == '}') {
//				contatoreLivelli--;
//			}
			
			if (contatoreLivelli==0) {
				//jsonString = jsonString.substring(0,i+1);
				System.out.println(jsonString);
				//System.out.println("***********"+actualLevel);
				
				String subActualLevel = jsonString.substring(1, jsonString.length()-1);
				//System.out.println("********"+subActualLevel);
				
				if (isPresentNestedObj(subActualLevel)) {
					//System.out.println("ha oggetti annidati /////");
					contatoreLivelli=1;
					String nestedObj = findNestedObjName(subActualLevel, class1);
					if (nestedObj != null) {
						//String s = subActualLevel.substring(subActualLevel.indexOf(nestedObj), subActualLevel.length());
						String s = subActualLevel.substring(subActualLevel.lastIndexOf(nestedObj)+nestedObj.length()+2, subActualLevel.length()-1);
						System.out.println("xxxxxxxxxxxxxxxxxx "+s);
						HashMap<String, String> jsonMap = getLevelValue(s, class1);
						
						Assicurazione ass = new Assicurazione();
						setAssicurazione(jsonMap, ass);
						System.out.println(ass);
						//HashMap<String, String> jsonMap = deserializeAttributes(s, class1);
						//System.out.println("attr "+jsonMap);
//						Method method = fromAttributeNameToSetter(nestedObj, class1);
//						method.invoke(nestedObj, class1);
						
						
						return jsonMap;
					}
				}else {
					//System.out.println("non ha oggetti annidati /////");
					HashMap<String, String> jsonMap = deserializeAttributes(jsonString, class1);
					System.out.println("sssssss"+jsonMap);
					return jsonMap;
					//System.out.println();
				}
				
			}
		}
		
		
		return null;
	}
	
	private void setAssicurazione (HashMap<String, String> nestedObjMap, Assicurazione ass) throws ParseException {
		
		String[] splitDate = nestedObjMap.get("inizioContratto").split("-");
		
		Date gc = new GregorianCalendar(Integer.valueOf(splitDate[2]), Integer.valueOf(splitDate[1])-1, Integer.valueOf(splitDate[0])).getTime();
		System.out.println(gc);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(gc);
		System.out.println(date);
		
	}
	
	private String findNestedObjName (String jsonString, Class<?> clazz) {
		
		System.out.println("assicurazione "+jsonString.indexOf("assicurazione"));
		
		List<String> fields = Arrays.asList(jsonString.split(","));
		
		for (int i=0; i<fields.size(); i++) { 
			//System.out.println("fields "+fields);
			if (fields.get(i).contains("{") ) {
				String [] keyVal = fields.get(i).split(":"); 
				System.out.println("//////////"+(keyVal[0]));
		//		
				return keyVal[0];
			}
		}
		
		return null;
	}

	private boolean isPresentNestedObj (String subActualLevel) {
		
		return subActualLevel.contains("{") && subActualLevel.contains("}");

	}
	
	public HashMap<String, String> deserializeAttributes(String jsonString, Class<?> class1) {
		
		Field[] attributi = class1.getFields();
		//System.out.println("ATTRIBUTI **** "+Arrays.toString(attributi));
		HashMap<String, String> jsonMap = new HashMap<>();
		jsonString = jsonString.replace("\"","").trim();
		
		System.out.println("JSON STRING "+jsonString);
		List<String> jsonStringSplit = Arrays.asList(jsonString.split(","));
		
		System.out.println("JSON STRING SPLIT "+jsonStringSplit);
		
		for (String s : jsonStringSplit) {
			List<String> listaSplit = Arrays.asList(s.split(":"));  
			System.out.println(listaSplit);
			jsonMap.put(listaSplit.get(0), listaSplit.get(1));
		}
		
//		for (int i=0; i<attributi.length; i++) {
//			String nomeAttributo = attributi[i].getName();
//			String valoreAttributo = getAttributeValue(nomeAttributo, jsonString);
//			jsonMap.put(nomeAttributo, valoreAttributo);
//			this.fromAttributeNameToSetter(nomeAttributo, class1);
//		}
		System.out.println(jsonMap);
		
		return jsonMap;

	}
	
//	private String getAttributeValue (String nomeAttributo, String jsonString) {
//		
//		String ret = null;
//		
//		String chiave = "\""+nomeAttributo+"\":";
//		
//		int lunghezzaChiave = chiave.length();
//		
//		if (jsonString.contains(chiave)) {
//			
//			int from = jsonString.indexOf(chiave)+lunghezzaChiave;
//			String jsonSubstring = jsonString.substring(from);
//			boolean isSubstringFinished = !jsonSubstring.contains(",");
//			if (jsonSubstring.startsWith("\"")) {
//				if(!isSubstringFinished) {
//					ret = jsonSubstring.substring(0, jsonSubstring.indexOf(","));
//				}else {
//					ret = jsonSubstring.substring(0, jsonSubstring.length());
//				}
//				
//			}else if (jsonSubstring.startsWith("{")) { //TODO object case with possible nested object
//				if(!isSubstringFinished) {
//					System.out.println(jsonSubstring);
//					ret = jsonSubstring.substring(0, jsonSubstring.indexOf("}")+1);
//				}else {
//					ret = jsonSubstring.substring(0, jsonSubstring.length());
//				}
//			}
//		}
//		return ret;
//	}
//	
//	private Method fromAttributeNameToSetter(String attributeName, Class<?> clazz) {
//		
//		Method[] setMethods = clazz.getDeclaredMethods();
//	//	System.out.println(Arrays.toString(setMethods));
//		Method ret = null;
//		
//		for (int i=0; i<setMethods.length; i++) {
//			
//			String methodName = setMethods[i].getName();
//		//	System.out.println(methodName);
//			if (methodName.equalsIgnoreCase("set"+attributeName)) {
//				ret = setMethods[i];
//			}
//		}
//		System.out.println(ret.getName()); 
//		
//		return ret;
//		
//	}
}

