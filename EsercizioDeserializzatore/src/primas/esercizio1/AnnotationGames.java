package primas.esercizio1;

import java.io.IOException;
import java.text.ParseException;

public class AnnotationGames {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, IOException, ParseException{

		Automobile auto = new Automobile("Toyota", "Corolla", 2001);
		System.out.println("Auto da serializzare: " + auto);
		JSONSimpleSerializer my_serializer = new JSONSimpleSerializer();

		String jsonString = 
				//		"{\"marca\":\"BMW\", \"modello\":\"955e\", \"anno\":\"2025\"}";

				//"{\"marca\":\"BMW\",\"modello\":\"955e\",\"anno\":\"2025\",\"assicurazione\":{\"inizioContratto\":\"2022-07-08\",\"scadenzaContratto\":\"2023-01-08\"}}";

				//	"{\"marca\":\"BMW\",\"modello\":\"955e\",\"assicurazione\":{\"inizioContratto\":\"2022-07-08\",\"scadenzaContratto\":\"2023-01-08\"},\"anno\":\"2025\"}";

				//"{\"assicurazione\":{\"inizioContratto\":\"2022-07-08\",\"scadenzaContratto\":\"2023-01-08\"},\"marca\":\"BMW\",\"modello\":\"955e\",\"anno\":\"2025\"}";

				//"{\"assicurazione\":{\"inizioContratto\":\"2022-07-08\",\"scadenzaContratto\":\"2023-01-08\"},\"marca\":\"BMW\",\"modello\":\"955e\",\"allestimento\":[\"base\",\"advantage\",\"Msport\",\"goldEdition\"],\"anno\":\"2025\"}";

				"{\"assicurazione\":{\"inizioContratto\":\"2022-07-08\",\"scadenzaContratto\":\"2023-01-08\"},\r\n"
				+ "\"persona\":{\r\n"
				+ "    \"nome\":\"Giovanna\",\r\n"
				+ "    \"cognome\":\"Ben Detto\",\r\n"
				+ "	\"eta\":42,\r\n"
				+ "  \"cartaIdentita\":{\r\n"
				+ "    \"nome\":\"Giovanna\",\r\n"
				+ "    \"cognome\":\"Ben Detto\",\r\n"
				+ "    \"comune\":\"Frosinone\",\r\n"
				+ "    \"nazionalita\":\"Italia\",\r\n"
				+ "    \"sesso\":\"F\",\r\n"
				+ "    \"dataNascita\":\"1970-11-13\",\r\n"
				+ "    \"dataEmissione\":\"1989-06-01\",\r\n"
				+ "    \"dataScadenza\":\"2005-01-21\",\r\n"
				+ "    \"residenza\":\"Frosinone\",\r\n"
				+ "    \"via\":\"Vial del grande 5\",\r\n"
				+ "    \"professione\":\"Insegnante scuola elementare\",\r\n"
				+ "    \"statura\":\"media\",\r\n"
				+ "    \"altezza\":177,\r\n"
				+ "    \"capelli\":\"a caschetto\",\r\n"
				+ "    \"segniParticolari\":\"malata di pulito\",\r\n"
				+ "    \"numeroDiSerie\":\"CA038200DE\"\r\n"
				+ "  },\r\n"
				+ "  \"patente\":{\r\n"	
				+ "    \"nome\":\"Giovanna\",\r\n"
				+ "    \"cognome\":\"Arco\",\r\n"
				+ "    \"dataNascita\":\"1970-11-13\",\r\n"
				+ "    \"dataRilascio\":\"1989-06-01\",\r\n"
				+ "    \"dataScadenza\":\"1999-06-01\",\r\n"
				+ "    \"numeroPatente\":\"U1H68G400B\",\r\n"
				+ "    \"categoria\":\"B96\"\r\n"
				+ "  }\r\n"
				+ "},\"marca\":\"BMW\",\"modello\":\"955e\",\"allestimento\":[\"base\",\"advantage\",\"Msport\",\"goldEdition\"],\"anno\":\"2025\"}";		

		Automobile auto3 = my_serializer.deserialize(jsonString, Automobile.class);
		System.out.println("Auto deserializzata: " + auto3);

	}
}

