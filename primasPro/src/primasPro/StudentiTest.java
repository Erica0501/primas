package primasPro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import primasPro.start.Main;
import primasPro.start.model.SESSO;
import primasPro.start.model.Studente;
import primasPro.start.model.TN;

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
	void testStudentiU25() {
		
		assertEquals(3, Main.countStudentiU25(stu), "gli studenti under 25 dovrebbero essere 3");
		
	}
	
	@Test
	void testStudentiUO25() {
		
	}
	
	@Test
	void testDistribuzioneTN() {
		
		assertEquals(2, Main.countDistribuzioneTN(stu, "nord"), "ci dovrebbero essere 2 studenti del nord");
		assertEquals(5, Main.countDistribuzioneTN(stu, "centro"), "ci dovrebbero essere 5 studenti del centro");
		assertEquals(3, Main.countDistribuzioneTN(stu, "sud"), "ci dovrebbero essere 3 studenti del sud");
	}
	
	@Test
	void testEtaMedia() {
		
		assertEquals(29.0, Main.etaMedia(stu), "l'età media degli studenti dovrebbe essere 29.0");
		
	}
	
	@Test
	void testOrderByCognome() {
		
		Studente stud = new Studente("Aldo", "Alfo", 50, SESSO.MASCHIO, TN.SUD);
		stu.add(stud);
		
		
	}

}
