package primas.esercizio1;

import java.util.*;

import static java.lang.Integer.parseInt;

public class JSONSimpleSerializer {


	/*First level */
	HashMap<String,Object> nestedObjects1 = new HashMap<>();

	/*Second level */
	HashMap<String,Object> nestedObjects2 = new HashMap<>();

	public Object deserialize(String jsonString, Class<?> unknowClass) {
		HashMap<String,Object> map = getObjFromJson(jsonString);

		return map.get("automobile");

	}

	private HashMap<String, Object> getObjFromJson(String json){

		System.out.println("json : "+json);

		HashMap<String, Object> mappedAttributesBase = null;
		HashMap<String, Object> mappedNestedAttributes = null;
		String nestedObjname = null;
		/* togli le graffe */
		String jsonModified = json.substring(1, json.length()-1);

		if (isPresentNestedObj(jsonModified)) {
			nestedObjname = findNestedObjName(jsonModified);
			if (nestedObjname != null) {
				/* prendi soltanto gli attributi dell'oggetto annidato, senza le sue graffe */
				String nestedObjAttributes = jsonModified.substring(jsonModified.lastIndexOf(nestedObjname)+nestedObjname.length()+2, jsonModified.length()-1);
				HashMap<String, String> mappedNestedObjAttr = deserializeAttributes(nestedObjAttributes);
				mappedNestedAttributes = setObjectToAttribute(mappedNestedObjAttr,nestedObjname);
				System.out.println("setObjectToAttribute : "+mappedNestedAttributes);

			}
		}else{
			HashMap<String, String> mappedObjAttrBase = deserializeAttributes(jsonModified);
			mappedAttributesBase = setObjectToAttribute(mappedObjAttrBase,"automobile");
			System.out.println("setObjectToAttribute : "+mappedAttributesBase);
		}

		if(nestedObjname!=null){
			System.out.println("jsonModified : "+jsonModified);
			jsonModified = getOnlyObjAttributesBase(jsonModified,new ArrayList<>(List.of(nestedObjname)));
			HashMap<String, String> mappedObjAttrBase = deserializeAttributes(jsonModified);
			mappedAttributesBase = setObjectToAttribute(mappedObjAttrBase,"automobile");
			System.out.println("setObjectToAttribute : "+mappedAttributesBase);
		}else{
			if (!isPresentNestedObj(jsonModified)){
				//TODO
			}
		}

		Automobile automobile = (Automobile) mappedAttributesBase.get("automobile");
		if (nestedObjname!=null) {
			Assicurazione assicurazione = (Assicurazione) mappedNestedAttributes.get(nestedObjname);
			automobile.setAssicurazione(assicurazione);
		}
		return mappedAttributesBase;
	}

	private String getOnlyObjAttributesBase(String jsonModified, ArrayList<String> attributesNestedObjects) {

		/* è presente l'attributo dell'oggetto annidato,e termina per caso con la '}' e
		 abbiamo soltanto un oggetto annidato e contiene la parola chiave dell'annidato */
		if(isPresentNestedObj(jsonModified) && jsonModified.endsWith("}") &&
				attributesNestedObjects.size() == 1 && jsonModified.contains(attributesNestedObjects.get(0))){
			System.out.println("l'ultimo carattere della stringa è '}'");
			System.out.println("la parola " + attributesNestedObjects.get(0) +" è alla posizione : "+jsonModified.indexOf(attributesNestedObjects.get(0)));
			/*			System.out.println(jsonModified.substring(0,jsonModified.indexOf(attributesNestedObjects.get(0))));*/
			return jsonModified.substring(0,jsonModified.indexOf(attributesNestedObjects.get(0)));
		}

		return null;
	}

	private HashMap<String, Object> setObjectToAttribute(HashMap<String, String> mappedObjAttr, String nestedObjname) {
		HashMap<String, Object> objNest = new HashMap<>();
		Assicurazione assicurazione = new Assicurazione();
		Automobile automobile = new Automobile();
		for (Map.Entry<String, String> set : mappedObjAttr.entrySet()) {
			System.out.println(set.getKey() + " = " + set.getValue());

			if(set.getKey().equals("inizioContratto")){
				assicurazione.setInizioContratto(formatFromStringToDate(set.getValue()));
			}
			if(set.getKey().equals("scadenzaContratto")){
				assicurazione.setScadenzaContratto(formatFromStringToDate(set.getValue()));
			}

			if(set.getKey().equals("marca")){
				automobile.setMarca(set.getValue());
			}

			if(set.getKey().equals("anno")){
				automobile.setAnno(parseInt(set.getValue()));
			}

			if(set.getKey().equals("modello")){
				automobile.setModello(set.getValue());
			}
		}
		if(nestedObjname.equals("\"assicurazione\"")) {
			objNest.put(nestedObjname, assicurazione);
		}else if(nestedObjname.equals("automobile")){
			objNest.put(nestedObjname, automobile);
		}
		return objNest;
	}



	private Date formatFromStringToDate(String dateString){
		String[] splitDate = dateString.split("-");
		Date dt = new GregorianCalendar(Integer.valueOf(splitDate[2]), Integer.valueOf(splitDate[1])-1, Integer.valueOf(splitDate[0])).getTime();
		return dt;
	}

	private String findNestedObjName (String jsonString) {

		List<String> fields = Arrays.asList(jsonString.split(","));

		for (int i=0; i<fields.size(); i++) {
			if (fields.get(i).contains("{") ) {
				String [] keyVal = fields.get(i).split(":");
				return keyVal[0];
			}
		}

		return null;
	}

	private boolean isPresentNestedObj (String subActualLevel) {
		return subActualLevel.contains("{") && subActualLevel.contains("}");
	}

	public HashMap<String, String> deserializeAttributes(String jsonString) {

		HashMap<String, String> jsonMap = new HashMap<>();
		jsonString = jsonString.replace("\"","").trim();

		List<String> jsonStringSplit = Arrays.asList(jsonString.split(","));

		for (String s : jsonStringSplit) {
			List<String> listaSplit = Arrays.asList(s.split(":"));
			jsonMap.put(listaSplit.get(0).trim(), listaSplit.get(1).trim());
		}
		return jsonMap;

	}
	
}

