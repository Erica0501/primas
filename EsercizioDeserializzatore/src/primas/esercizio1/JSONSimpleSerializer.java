package primas.esercizio1;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
		System.out.println("Stringa serializzata:\n " + jsonString);
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize (String input, Class<T> clazz) {	

		String inputPulito = eliminaSpaziVuoti(input);

		return (T) setObj(inputPulito, clazz);
	}

	private String livelloOggetto (String input) {

		String obj = "";
		int contatoreLivelli = 0;
		char [] charArray = input.toCharArray();

		for (int i=0; i<charArray.length; i++) {
			obj += charArray[i];
			if (charArray[i] == '{') {
				contatoreLivelli++;
			}if (charArray[i] == '}') {
				contatoreLivelli--;
			}

			if (contatoreLivelli == 0) {
				break;
			}
		}

		if (contatoreLivelli != 0) {
			throw new RuntimeException("Oggetto Json malformato "+ eliminaSpaziVuoti(input));
		}
		return obj;
	}

	private <T> Object setObj (String input, Class<T> clazz) {

		Object obj = null;

		try {
			Constructor<T> c = clazz.getConstructor();
			obj = c.newInstance();

			String livello = livelloOggetto(input.substring(input.indexOf('{')));

			Field [] attributi = clazz.getDeclaredFields();


			for (int i=0; i<attributi.length; i++) {
				String nomeAttributo = attributi[i].getName();
				Class<?> tipoAttributo = attributi[i].getType(); 

				// per prendere getter/read e setter/write 
				PropertyDescriptor pd = new PropertyDescriptor(nomeAttributo, clazz);
				Method setter = pd.getWriteMethod();

				String chiaveAttributoInJson = "\""+nomeAttributo+"\":";

				if (livello.contains(chiaveAttributoInJson)) {
					String inizioChiaveValore = livello.substring(livello.indexOf(chiaveAttributoInJson));
					int indiceInizioValore = chiaveAttributoInJson.length();
					String inizioValore = inizioChiaveValore.substring(indiceInizioValore);


					if (MappaFunzioni.getFunzionePerTipo(attributi[i].getGenericType().getTypeName()) != null) {
						MappaFunzioni.getFunzionePerTipo(attributi[i].getGenericType().getTypeName()).setTipo(setter, obj, inizioValore);
					}

					else if(inizioValore.startsWith("{")){
						try {
							Object oggettoAnnidato = setObj(inizioValore, tipoAttributo);
							setter.invoke(obj, oggettoAnnidato);
						}catch(Exception e) {
							System.out.println("Impossibile costruire il seguente oggetto: "+tipoAttributo);
						}
					}					
				}
			}

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
			e.printStackTrace();
		}
		return obj;
	}

	private String eliminaSpaziVuoti (String input) {

		boolean quoted = false;
		String out = "";

		for(Character c : input.toCharArray()) {

			// cerca valori tra doppi apici 
			// quoted true : non rimuovo spazi bianchi
			if(c == '"') {
				quoted = !quoted;
			}

			// se la stringa non è tra doppi apici , rimuove spazi bianchi
			if(!quoted && (c == ' ' || c == '\r' || c == '\n' || c == '\t')) {
				continue;
			}
			out += c;
		}
		return out;
	}
}


