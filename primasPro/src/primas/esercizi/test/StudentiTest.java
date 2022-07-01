package primas.esercizi.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import primas.esercizi.model.SESSO;
import primas.esercizi.model.Studente;
import primas.esercizi.model.TN;
import primas.esercizi.start.Main;

class StudentiTest {

	List<Studente> stu;

	@BeforeEach                                         
	void setUp() {
		
		stu = Arrays.asList(
				new Studente("Erica","Brugnetti",18,SESSO.FEMMINA,TN.CENTRO),
				new Studente("Daniele","Iovino",26,SESSO.MASCHIO,TN.CENTRO),
				new Studente("Monica","Rossi",30,SESSO.FEMMINA,TN.NORD),
				new Studente("Luca","Bianchi",21,SESSO.MASCHIO,TN.SUD),
				new Studente("Marco","Piccioni",35,SESSO.MASCHIO,TN.SUD),
				new Studente("Dario","Mari",45,SESSO.MASCHIO,TN.CENTRO),
				new Studente("Luigi","Fagiolo",29,SESSO.MASCHIO,TN.CENTRO),
				new Studente("Maria","Verdi",19,SESSO.FEMMINA,TN.NORD),
				new Studente("Edoardo","Lolli",34,SESSO.MASCHIO,TN.CENTRO),
				new Studente("Mirko","Paolini",33,SESSO.MASCHIO,TN.SUD)
				);
	}
	
	@Test
	void testStudentiSize() {

		assertEquals(10, stu.size(), "gli studenti dovrebbero essere 10");

	}
	
	@Test
	void testStudentiU25() {

		assertEquals(3, Main.countStudentiU25(stu), "gli studenti under 25 dovrebbero essere 3");

	}

	@Test
	void testStudentiUO25() {

		Map<String, List<Studente>> ret = Main.studentiUnderOver25(stu);
		
		assertEquals(3, ret.get("under25").size(), "gli studenti under 25 dovrebbero essere 3");
		assertEquals(7, ret.get("over25").size(), "gli studenti over 25 dovrebbero essere 7");
		
	}

	@Test
	void testCountDistribuzioneTN() {

		assertEquals(2, Main.countDistribuzioneTN(stu, "nord"), "ci dovrebbero essere 2 studenti del nord");
		assertEquals(5, Main.countDistribuzioneTN(stu, "centro"), "ci dovrebbero essere 5 studenti del centro");
		assertEquals(3, Main.countDistribuzioneTN(stu, "sud"), "ci dovrebbero essere 3 studenti del sud");
		
	}
	
	@Test
	void testDistribuzioneTN() {

		Map<String, List<Studente>> ret = Main.distribuzioneTN(stu);
		
		assertEquals(2, ret.get("nord").size(), "ci dovrebbero essere 2 studenti del nord");
		assertEquals(5, ret.get("centro").size(), "ci dovrebbero essere 5 studenti del centro");
		assertEquals(3, ret.get("sud").size(), "ci dovrebbero essere 3 studenti del sud");
		
		List<Studente> listaN = Arrays.asList(new Studente("Monica","Rossi",30,SESSO.FEMMINA,TN.NORD), new Studente("Maria","Verdi",19,SESSO.FEMMINA,TN.NORD));
		List<Studente> listaC = Arrays.asList(new Studente("Erica","Brugnetti",18,SESSO.FEMMINA,TN.CENTRO), new Studente("Daniele","Iovino",26,SESSO.MASCHIO,TN.CENTRO), new Studente("Dario","Mari",45,SESSO.MASCHIO,TN.CENTRO), new Studente("Luigi","Fagiolo",29,SESSO.MASCHIO,TN.CENTRO), new Studente("Edoardo","Lolli",34,SESSO.MASCHIO,TN.CENTRO));;
		List<Studente> listaS = Arrays.asList(new Studente("Luca","Bianchi",21,SESSO.MASCHIO,TN.SUD), new Studente("Marco","Piccioni",35,SESSO.MASCHIO,TN.SUD), new Studente("Mirko","Paolini",33,SESSO.MASCHIO,TN.SUD));

		assertEquals(listaN, ret.get("nord"), "la lista dovrebbe contenere solo studenti del nord");
		assertEquals(listaC, ret.get("centro"), "la lista dovrebbe contenere solo studenti del centro");
		assertEquals(listaS, ret.get("sud"), "la lista dovrebbe contenere solo studenti del sud");
		
	}

	@Test
	void testEtaMedia() {

		assertEquals(29.0, Main.etaMedia(stu), "l'et� media degli studenti dovrebbe essere 29.0");

	}

	@Test
	void testOrderByCognome() {
		
	    ArrayList<Studente> sorted = new ArrayList<Studente>(stu);
	    
	    Collections.sort(sorted, Comparator.comparing(Studente::getCognome));
	    
	    Assert.assertNotEquals("le due liste non dovrebbero avere lo stesso ordine", sorted, stu);	
	    
	    Assert.assertEquals(sorted, Main.orderByCognome(stu));

	}
	
	@Test
	void testPercentualeFM() {
		
		assertEquals(30, Main.percentualeFM(stu, "FEMMINA"), "La percentuale delle femmine dovrebbe essere il 30% ");
		assertEquals(70, Main.percentualeFM(stu, "MASCHIO"), "La percentuale dei maschi dovrebbe essere il 70% ");
		
	}

	@Test
	void testGetSetEta() {
		
		assertEquals(18, stu.get(0).getEta(), "il primo studente dovrebbe avere 18 anni");
		stu.get(0).setEta(30);
		assertEquals(30, stu.get(0).getEta(), "il primo studente dovrebbe avere 30 anni");
		
	}
	
	@Test
	void testGetSetNome() {
		
		assertEquals("Erica", stu.get(0).getNome(), "il nome del primo studente dovrebbe essere Erica");
		stu.get(0).setNome("Martina");
		assertEquals("Martina", stu.get(0).getNome(), "il nome del primo studente dovrebbe essere Martina");
		
	}
	
	@Test
	void testGetSetCognome() {
		
		assertEquals("Brugnetti", stu.get(0).getCognome(), "il cognome del primo studente dovrebbe essere Brugnetti");
		stu.get(0).setCognome("Natale");
		assertEquals("Natale", stu.get(0).getCognome(), "il cognome del primo studente dovrebbe essere Natale");
		
	}
	
	@Test
	void testGetSetSesso() {
		
		assertEquals(SESSO.FEMMINA, stu.get(0).getSesso(), "il sesso del primo studente dovrebbe essere femmina");
		stu.get(0).setSesso(SESSO.MASCHIO);
		assertEquals(SESSO.MASCHIO, stu.get(0).getSesso(), "il sesso del primo studente dovrebbe essere maschio");
		
	}
	
	@Test
	void testGetSetTn() {
		
		assertEquals(TN.CENTRO, stu.get(0).getTn(), "il territorio del primo studente dovrebbe essere centro");
		stu.get(0).setTn(TN.SUD);
		assertEquals(TN.SUD, stu.get(0).getTn(), "il territorio del primo studente dovrebbe essere sud");
		
	}

}
