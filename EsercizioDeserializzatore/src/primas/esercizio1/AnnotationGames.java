package primas.esercizio1;

import java.io.IOException;

public class AnnotationGames {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, IOException{

		Automobile auto = new Automobile("Toyota", "Corolla", 2001);
		System.out.println("Auto da serializzare: " + auto);
		JSONSimpleSerializer my_serializer = new JSONSimpleSerializer();

		String jsonString =
				//		"{\"marca\":\"BMW\", \"modello\":\"955e\", \"anno\":\"2025\"}";

				"{\"marca\":\"BMW\",\"modello\":\"955e\",\"anno\":\"2025\",\"assicurazione\":{\"inizioContratto\":\"08-07-2022\",\"scadenzaContratto\":\"08-01-2023\"}}";

		Automobile auto3 = (Automobile) my_serializer.deserialize(jsonString, Automobile.class);
		System.out.println("Auto deserializzata: " + auto3);
		
	}

}

