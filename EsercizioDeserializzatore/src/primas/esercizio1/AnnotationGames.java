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
		
		//"{\"marca\":\"BMW\",\"modello\":\"955e\",\"anno\":\"2025\",\"assicurazione\":{\"inizioContratto\":\"08-07-2022\",\"scadenzaContratto\":\"08-01-2023\"}}";
				
		//	"{\"marca\":\"BMW\",\"modello\":\"955e\",\"assicurazione\":{\"inizioContratto\":\"08-07-2022\",\"scadenzaContratto\":\"08-01-2023\"},\"anno\":\"2025\"}";
				
		"{\"assicurazione\":{\"inizioContratto\":\"08-07-2022\",\"scadenzaContratto\":\"08-01-2023\"},\"marca\":\"BMW\",\"modello\":\"955e\",\"anno\":\"2025\"}";		
				
		Automobile auto3 = my_serializer.deserialize(jsonString, Automobile.class);
		System.out.println("Auto deserializzata: " + auto3);
		
	}
}

