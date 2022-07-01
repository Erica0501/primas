package primas.esercizi.start;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import primas.esercizi.model.SESSO;
import primas.esercizi.model.Studente;
import primas.esercizi.model.TN;

public class Main {

	public static void main(String[] args) {
		
		List<Studente> studenti =  Arrays.asList(
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

		countStudentiU25(studenti);

		studentiUnderOver25(studenti);

		etaMedia(studenti);

		percentualeFM(studenti, "Femmina");
		
		percentualeFM(studenti, "Maschio");

		orderByCognome(studenti);
		
		distribuzioneTN(studenti);
		
		countDistribuzioneTN(studenti, "nord");
		
		countDistribuzioneTN(studenti, "centro");
		
		countDistribuzioneTN(studenti, "sud");

	}
	
	
	// ** calcolare quanti studenti hanno meno di 25 anni
	public static long countStudentiU25(List<Studente> studenti) {

		long stud = studenti
				.stream()
				.filter(s -> s.getEta() < 25)
				.count();

		return stud;

	}

	//suddividere il gruppo in maggiori  e minori di 25 anni
	public static Map<String, List<Studente>> studentiUnderOver25 (List<Studente> studenti) {

		Map<String, Predicate<Studente>> mappa = new HashMap<>(); 

		Predicate<Studente> under25 = s -> s.getEta() < 25;
		Predicate<Studente> over25 = s -> s.getEta() >= 25;

		mappa.put("under25", under25);
		mappa.put("over25", over25);
		
		Predicate<Studente> targetU25 = mappa.get("under25");
		Predicate<Studente> targetO25 = mappa.get("over25");

		Map<String, List<Studente>> ret = new HashMap<>(); 
		
		ret.put("under25", studenti
				.stream()
				.filter(s -> targetU25.test(s))
				.collect(Collectors.toList()));
		ret.put("over25", studenti
				.stream()
				.filter(s -> targetO25.test(s))
				.collect(Collectors.toList()));

		return ret;

	}
	
	// ** individuare distribuzione studenti sul territorio nazionale
	public static Map<String, List<Studente>> distribuzioneTN (List<Studente> studenti) {

		Map<String, Predicate<Studente>> mappa = new HashMap<>(); 

		Predicate<Studente> nord = s -> s.getTn().equals(TN.NORD);
		Predicate<Studente> centro = s -> s.getTn().equals(TN.CENTRO);
		Predicate<Studente> sud = s -> s.getTn().equals(TN.SUD);

		mappa.put("nord", nord);
		mappa.put("centro", centro);
		mappa.put("sud", sud);

		Predicate<Studente> targetNord = mappa.get("nord");
		Predicate<Studente> targetCentro = mappa.get("centro");
		Predicate<Studente> targetSud = mappa.get("sud");

		Map<String, List<Studente>> ret = new HashMap<>(); 
		
		ret.put("nord", studenti
				.stream()
				.filter(s -> targetNord.test(s))
				.collect(Collectors.toList()));
		ret.put("centro", studenti.stream()
				.filter(s -> targetCentro.test(s))
				.collect(Collectors.toList()));
		ret.put("sud", studenti.stream()
				.filter(s -> targetSud.test(s))
				.collect(Collectors.toList()));

		return ret;

	}
	
	// ** individuare distribuzione studenti sul territorio nazionale Sol.2
	public static long countDistribuzioneTN (List<Studente> studenti, String tn) {

		long count;

		if (tn.equalsIgnoreCase("NORD")) {
			count = studenti
					.stream()
					.filter(s -> s.getTn().equals(TN.NORD)).count();
		} else if (tn.equalsIgnoreCase("CENTRO")) {
			count = studenti
					.stream()
					.filter(s -> s.getTn().equals(TN.CENTRO)).count();
		} else {
			count = studenti
					.stream()
					.filter(s -> s.getTn().equals(TN.SUD)).count();
		}

		return count;
		
	}

	// **calcolare età media
	public static double etaMedia (List<Studente> studenti) {

		Double etaMedia = studenti
				.stream()
				.collect(Collectors.averagingInt(Studente::getEta));
		
		return etaMedia;
		
	}
	
	// ** ordinare gli studenti alfabeticamente per cognome
	public static List<Studente> orderByCognome (List<Studente> studenti) {

		return studenti
				.stream()
				.sorted(Comparator.comparing(Studente::getCognome))
				.collect(Collectors.toList());
		
	}
	
	// ** individuare percentuale studenti maschi e femmine
	public static Long percentualeFM (List<Studente> studenti, String genere) {

		int totale = studenti.size();
		long percentuale;

		if (genere.equalsIgnoreCase("FEMMINA")) {
			percentuale = studenti
						 .stream()
						 .filter(s -> s.getSesso().equals(SESSO.FEMMINA))
						 .count();
		} else {
			percentuale = studenti
						 .stream()
						 .filter(s -> s.getSesso().equals(SESSO.MASCHIO))
						 .count();
		}

		return percentuale * 100 / totale;

	}

}
