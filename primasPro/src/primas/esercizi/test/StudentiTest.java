package primas.esercizi.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
				
				
		
//		stu.add(new Studente("Erica","Brugnetti",18,SESSO.FEMMINA,TN.CENTRO));
//		stu.add(new Studente("Daniele","Iovino",26,SESSO.MASCHIO,TN.CENTRO));
//		stu.add(new Studente("Monica","Rossi",30,SESSO.FEMMINA,TN.NORD));
//		stu.add(new Studente("Luca","Bianchi",21,SESSO.MASCHIO,TN.SUD));
//		stu.add(new Studente("Marco","Piccioni",35,SESSO.MASCHIO,TN.SUD));
//		stu.add(new Studente("Dario","Mari",45,SESSO.MASCHIO,TN.CENTRO));
//		stu.add(new Studente("Luigi","Fagiolo",29,SESSO.MASCHIO,TN.CENTRO));
//		stu.add(new Studente("Maria","Verdi",19,SESSO.FEMMINA,TN.NORD));
//		stu.add(new Studente("Edoardo","Lolli",34,SESSO.MASCHIO,TN.CENTRO));
//		stu.add(new Studente("Mirko","Paolini",33,SESSO.MASCHIO,TN.SUD));

	}

	@Test
	void testStudentiU25() {

		assertEquals(3, Main.countStudentiU25(stu), "gli studenti under 25 dovrebbero essere 3");

	}

	@Test
	void testStudentiUO25() {

		//TODO
	}

	@Test
	void testCountDistribuzioneTN() {

		assertEquals(2, Main.countDistribuzioneTN(stu, "nord"), "ci dovrebbero essere 2 studenti del nord");
		assertEquals(5, Main.countDistribuzioneTN(stu, "centro"), "ci dovrebbero essere 5 studenti del centro");
		assertEquals(3, Main.countDistribuzioneTN(stu, "sud"), "ci dovrebbero essere 3 studenti del sud");
	}

	@Test
	void testEtaMedia() {

		assertEquals(29.0, Main.etaMedia(stu), "l'et� media degli studenti dovrebbe essere 29.0");

	}

	@Test
	void testOrderByCognome() {
		
	    ArrayList<Studente> sorted = new ArrayList<Studente>(stu);
	    
	    Collections.sort(sorted, Comparator.comparing(Studente::getCognome));
	    
	    Assert.assertNotEquals("List is not sorted", sorted, stu);	
	    
	    Assert.assertEquals(sorted, Main.orderByCognome(stu));

	}
	
	@Test
	void testPercentualeFM() {
		
		String genere = "FEMMINA";
		String genere1 = "MASCHIO";
		
		assertEquals(30, Main.percentualeFM(stu, genere), "La percentuale delle femmine dovrebbe essere il 30% ");
		assertEquals(70, Main.percentualeFM(stu, genere1), "La percentuale dei maschi dovrebbe essere il 70% ");
	}
	

}
