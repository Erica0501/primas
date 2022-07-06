package primas.esercizio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class QueryStudenti {
	
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

		Predicate<Studente> minori25Anni = s -> s.getEta() < 25;
		Predicate<Studente> maggioriUguali25Anni = s -> s.getEta() >= 25;

		mappa.put("minori25Anni", minori25Anni);
		mappa.put("maggioriUguali25Anni", maggioriUguali25Anni);
		
		Predicate<Studente> targetU25 = mappa.get("minori25Anni");
		Predicate<Studente> targetO25 = mappa.get("maggioriUguali25Anni");

		Map<String, List<Studente>> ret = new HashMap<>(); 
		
		ret.put("minori25Anni", studenti
				.stream()
				.filter(s -> targetU25.test(s))
				.collect(Collectors.toList()));
		ret.put("maggioriUguali25Anni", studenti
				.stream()
				.filter(s -> targetO25.test(s))
				.collect(Collectors.toList()));

		return ret;

	}
	
	// ** individuare distribuzione studenti sul territorio nazionale
	public static Map<String, List<Studente>> distribuzioneTerritorioItaliano (List<Studente> studenti) {

		Map<String, Predicate<Studente>> mappa = new HashMap<>(); 

		Predicate<Studente> nord = s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.NORD);
		Predicate<Studente> centro = s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.CENTRO);
		Predicate<Studente> sud = s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.SUD);

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
	public static long countDistribuzioneTerritorioItaliano (List<Studente> studenti, String tn) {

		long count;

		if (tn.equalsIgnoreCase("NORD")) {
			count = studenti
					.stream()
					.filter(s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.NORD)).count();
		} else if (tn.equalsIgnoreCase("CENTRO")) {
			count = studenti
					.stream()
					.filter(s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.CENTRO)).count();
		} else {
			count = studenti
					.stream()
					.filter(s -> s.getParteTerritorioItaliano().equals(ParteTerritorioItaliano.SUD)).count();
		}

		return count;
		
	}

	// **calcolare eta media
	public static String etaMedia (List<Studente> studenti) {

		Double etaMedia = studenti
				.stream()
				.collect(Collectors.averagingInt(Studente::getEta));
		
		NumberFormat formatter = new DecimalFormat("#0.00");  
		
		return formatter.format(etaMedia);
		
	}
	
	// ** ordinare gli studenti alfabeticamente per cognome
	public static List<Studente> orderByCognome (List<Studente> studenti) {

		return studenti
				.stream()
				.sorted(Comparator.comparing(Studente::getCognome))
				.collect(Collectors.toList());
		
	}
	
	// ** individuare percentuale studenti maschi e femmine
	public static String percentualeFM (List<Studente> studenti, String genere) {

		int totale = studenti.size();
		Long percentuale;

		if (genere.equalsIgnoreCase("FEMMINA")) {
			percentuale = studenti
						 .stream()
						 .filter(s -> s.getSesso().equals(Sesso.FEMMINA))
						 .count();
		} else {
			percentuale = studenti
						 .stream()
						 .filter(s -> s.getSesso().equals(Sesso.MASCHIO))
						 .count();
		}
		
		NumberFormat formatter = new DecimalFormat("#0.00");    
		double ret = percentuale.doubleValue() * 100 / totale;

		return formatter.format(ret);

	}

}
