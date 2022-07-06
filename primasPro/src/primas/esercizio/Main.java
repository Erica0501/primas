package primas.esercizio;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<Studente> studenti =  Arrays.asList(
				new Studente("Erica","Brugnetti",18,Sesso.FEMMINA,ParteTerritorioItaliano.CENTRO),
				new Studente("Daniele","Iovino",26,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Monica","Rossi",30,Sesso.FEMMINA,ParteTerritorioItaliano.NORD),
				new Studente("Luca","Bianchi",21,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
				new Studente("Marco","Piccioni",35,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
				new Studente("Dario","Mari",45,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Luigi","Fagiolo",29,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Maria","Verdi",19,Sesso.FEMMINA,ParteTerritorioItaliano.NORD),
				new Studente("Edoardo","Lolli",34,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Mirko","Paolini",33,Sesso.MASCHIO,ParteTerritorioItaliano.SUD)
				);

		QueryStudenti.countStudentiU25(studenti);

		QueryStudenti.studentiUnderOver25(studenti);

		QueryStudenti.etaMedia(studenti);

		QueryStudenti.percentualeFM(studenti, "Femmina"); 
		
		QueryStudenti.percentualeFM(studenti, "Maschio");

		QueryStudenti.orderByCognome(studenti);
		
		QueryStudenti.distribuzioneTerritorioItaliano(studenti);
		
		QueryStudenti.countDistribuzioneTerritorioItaliano(studenti, "nord");
		
		QueryStudenti.countDistribuzioneTerritorioItaliano(studenti, "centro");
		
		QueryStudenti.countDistribuzioneTerritorioItaliano(studenti, "sud");

	}
	
}
