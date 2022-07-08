package primas.esercizio1;

import java.io.IOException;

public class AnnotationGames {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, ClassNotFoundException, IOException{

		Automobile auto = new Automobile("Toyota", "Corolla", 2001);
		System.out.println("Auto da serializzare: " + auto);
		JSONSimpleSerializer my_serializer = new JSONSimpleSerializer();
		my_serializer.serialize(auto);
		
		String jsonString = 
				"{\"marca\":\"BMW\", \"modello\":\"955e\", \"anno\":\"2025\"}";
		Automobile auto2 = my_serializer.deserialize(jsonString, Automobile.class);
		System.out.println("Auto deserializzata: " + auto2);
		
	}

}
