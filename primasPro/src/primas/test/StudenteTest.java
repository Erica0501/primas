package primas.test;

import static org.junit.Assert.*;
import org.junit.Test;

import primas.esercizio.ParteTerritorioItaliano;
import primas.esercizio.QueryStudenti;
import primas.esercizio.Sesso;
import primas.esercizio.Studente;

import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class StudenteTest {

	List<Studente> stu;

	@Before                                        
	public void setUp() {
		
		stu = Arrays.asList(
				new Studente("Erica","Brugnetti",18,Sesso.FEMMINA,ParteTerritorioItaliano.CENTRO),
				new Studente("Daniele","Iovino",26,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Monica","Rossi",30,Sesso.FEMMINA,ParteTerritorioItaliano.NORD),
				new Studente("Luca","Bianchi",21,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
				new Studente("Marco","Piccioni",35,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
				new Studente("Dario","Mari",45,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Luigi","Fagiolo",29,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Maria","Verdi",19,Sesso.FEMMINA,ParteTerritorioItaliano.NORD),
				new Studente("Edoardo","Lolli",34,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO),
				new Studente("Mirko","Paolini",33,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
				new Studente("Poldo","Paolini",25,Sesso.MASCHIO,ParteTerritorioItaliano.SUD)
				);
	}
	
	@Test
	public void testStudentiSize() {

		assertEquals("gli studenti dovrebbero essere 11", 11, stu.size());
		

	}
	
	@Test
	public void testStudentiU25() {

		assertEquals("gli studenti under 25 dovrebbero essere 3", 3, QueryStudenti.countStudentiU25(stu));

	}

	@Test
	public void testStudentiUO25() {

		Map<String, List<Studente>> ret = QueryStudenti.studentiUnderOver25(stu);
		
		assertEquals("gli studenti con eta' minore di 25 dovrebbero essere 3", 3, ret.get("minori25Anni").size());
		assertEquals("gli studenti con eta' maggiore o uguale a 25 dovrebbero essere 8", 8, ret.get("maggioriUguali25Anni").size());
		
	}

	@Test
	public void testCountDistribuzioneTerritorioItaliano() {

		assertEquals("ci dovrebbero essere 2 studenti del nord", 2, QueryStudenti.countDistribuzioneTerritorioItaliano(stu, "nord"));
		assertEquals("ci dovrebbero essere 5 studenti del centro", 5, QueryStudenti.countDistribuzioneTerritorioItaliano(stu, "centro"));
		assertEquals("ci dovrebbero essere 4 studenti del sud", 4, QueryStudenti.countDistribuzioneTerritorioItaliano(stu, "sud"));
		
	}
	
	@Test
	public void testDistribuzioneTerritorioItaliano() {

		Map<String, List<Studente>> ret = QueryStudenti.distribuzioneTerritorioItaliano(stu);
		
		assertEquals("ci dovrebbero essere 2 studenti del nord", 2, ret.get("nord").size());
		assertEquals("ci dovrebbero essere 5 studenti del centro", 5, ret.get("centro").size());
		assertEquals("ci dovrebbero essere 4 studenti del sud", 4, ret.get("sud").size());
		
		List<Studente> listaN = Arrays.asList(new Studente("Monica","Rossi",30,Sesso.FEMMINA,ParteTerritorioItaliano.NORD), 
		    new Studente("Maria","Verdi",19,Sesso.FEMMINA,ParteTerritorioItaliano.NORD));
		List<Studente> listaC = Arrays.asList(new Studente("Erica","Brugnetti",18,Sesso.FEMMINA,ParteTerritorioItaliano.CENTRO), 
		    new Studente("Daniele","Iovino",26,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO), 
		    new Studente("Dario","Mari",45,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO), 
		    new Studente("Luigi","Fagiolo",29,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO), 
		    new Studente("Edoardo","Lolli",34,Sesso.MASCHIO,ParteTerritorioItaliano.CENTRO));;
		List<Studente> listaS = Arrays.asList(new Studente("Luca","Bianchi",21,Sesso.MASCHIO,ParteTerritorioItaliano.SUD), 
		    new Studente("Marco","Piccioni",35,Sesso.MASCHIO,ParteTerritorioItaliano.SUD), 
		    new Studente("Mirko","Paolini",33,Sesso.MASCHIO,ParteTerritorioItaliano.SUD),
		    new Studente("Poldo","Paolini",25,Sesso.MASCHIO,ParteTerritorioItaliano.SUD));

		assertEquals("la lista dovrebbe contenere solo studenti del nord", listaN, ret.get("nord"));
		assertEquals("la lista dovrebbe contenere solo studenti del centro", listaC, ret.get("centro"));
		assertEquals("la lista dovrebbe contenere solo studenti del sud", listaS, ret.get("sud"));
		
	}

	@Test
	public void testEtaMedia() {

		assertEquals("L'eta' media degli studenti dovrebbe essere 28,64", QueryStudenti.etaMedia(stu), "28,64");

	}

	@Test
	public void testOrderByCognome() {
		
	    ArrayList<Studente> sorted = new ArrayList<Studente>(stu);
	    
	    Collections.sort(sorted, Comparator.comparing(Studente::getCognome));
	    
	    assertNotEquals("le due liste non dovrebbero avere lo stesso ordine", sorted, stu);	
	    
	    assertEquals(sorted, QueryStudenti.orderByCognome(stu));

	}
	
	@Test
	public void testPercentualeFM() {
		
		
		assertEquals("La percentuale delle femmine dovrebbe essere il 27.27% ", "27,27", QueryStudenti.percentualeFM(stu, "FEMMINA"));
		
		assertEquals("La percentuale dei maschi dovrebbe essere il 72.73% ", "72,73", QueryStudenti.percentualeFM(stu, "MASCHIO"));
		
	}
	

	@Test
	public void testGetSetEta() {
		
		assertEquals("il primo studente dovrebbe avere 18 anni", 18, stu.get(0).getEta());
		stu.get(0).setEta(30);
		assertEquals("il primo studente dovrebbe avere 30 anni", 30, stu.get(0).getEta());
		
	}
	
	@Test
	public void testGetSetNome() {
		
		assertEquals("il nome del primo studente dovrebbe essere Erica", "Erica", stu.get(0).getNome());
		stu.get(0).setNome("Martina");
		assertEquals("il nome del primo studente dovrebbe essere Martina", "Martina", stu.get(0).getNome());
		
	}
	
	@Test
	public void testGetSetCognome() {
		
		assertEquals("il cognome del primo studente dovrebbe essere Brugnetti", "Brugnetti", stu.get(0).getCognome());
		stu.get(0).setCognome("Natale");
		assertEquals("il cognome del primo studente dovrebbe essere Natale", "Natale", stu.get(0).getCognome());
		
	}
	
	@Test
	public void testGetSetSesso() {
		
		assertEquals("il sesso del primo studente dovrebbe essere femmina", Sesso.FEMMINA, stu.get(0).getSesso());
		stu.get(0).setSesso(Sesso.MASCHIO);
		assertEquals("il sesso del primo studente dovrebbe essere maschio", Sesso.MASCHIO, stu.get(0).getSesso());
		
	}
	
	@Test
	public void testGetSetTn() {
		
		assertEquals("il territorio del primo studente dovrebbe essere centro", ParteTerritorioItaliano.CENTRO, stu.get(0).getParteTerritorioItaliano());
		stu.get(0).setParteTerritorioItaliano(ParteTerritorioItaliano.SUD);
		assertEquals("il territorio del primo studente dovrebbe essere sud", ParteTerritorioItaliano.SUD, stu.get(0).getParteTerritorioItaliano());
		
	}

}


