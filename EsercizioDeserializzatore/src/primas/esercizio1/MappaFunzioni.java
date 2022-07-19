package primas.esercizio1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MappaFunzioni {
	
	// mappa funzioni
	private static final HashMap<String, FunzioneTipiPrimitivi> mappa_funzioni = new HashMap<>();

	private static final FunzioneTipiPrimitivi integer = (setter, obj, inizioValore) -> {
		String fineValore = ",";
		if (!inizioValore.contains(fineValore)) {
			fineValore = "}";
		}
		int indiceFineValore = inizioValore.indexOf(fineValore);
		String valore = inizioValore.substring(0, indiceFineValore-2).trim();
		setter.invoke(obj, Integer.valueOf(valore));
	};

	private static final FunzioneTipiPrimitivi string = (setter, obj, inizioValore) -> {
		String fineValore = "\",";
		if (!inizioValore.contains(fineValore)) {
			fineValore = "\"}";
		}
		int indiceFineValore = inizioValore.indexOf(fineValore);
		String valore = inizioValore.substring(0, indiceFineValore+1).replace("\"", "");
		setter.invoke(obj, valore);
	};

	private static final FunzioneTipiPrimitivi localDate = (setter, obj, inizioValore) -> {
		String fineValore = "\",";
		if (!inizioValore.contains(fineValore)) {
			fineValore = "}";
		}
		int indiceFineValore = inizioValore.indexOf(fineValore);
		String valore = inizioValore.substring(0, indiceFineValore).replace("\"", "");
		setter.invoke(obj, LocalDate.parse(valore));
	};

	private static final FunzioneTipiPrimitivi stringArray = (setter, obj, inizioValore) -> {

		Object valore = livelloArray(inizioValore).replace("\"", "").replaceAll("[\\[\\]]", "").split(",");
		setter.invoke(obj, valore);
	};
	
	private static final FunzioneTipiPrimitivi listString = (setter, obj, inizioValore) -> {

		List<String> valore = new LinkedList<>(Arrays.asList(livelloArray(inizioValore).replace("\"", "").replaceAll("[\\[\\]]", "").split(",")));
		setter.invoke(obj, valore);
	};


	static {
		mappa_funzioni.put(Integer.class.getName(), integer);
		mappa_funzioni.put("int", integer);
		mappa_funzioni.put(String.class.getName(), string);
		mappa_funzioni.put(LocalDate.class.getName(), localDate);
		mappa_funzioni.put("java.lang.String[]", stringArray);
		mappa_funzioni.put("java.util.List<java.lang.String>", listString);
	}

	public static FunzioneTipiPrimitivi getFunzionePerTipo (String chiave) {
		return mappa_funzioni.get(chiave);
	}

	private static String livelloArray (String input) {

		String obj = "";
		int contatoreLivelli = 0;
		char [] charArray = input.toCharArray();

		for (int i=0; i<charArray.length; i++) {
			obj += charArray[i];
			if (charArray[i] == '[') {
				contatoreLivelli++;
			}if (charArray[i] == ']') {
				contatoreLivelli--;
			}

			if (contatoreLivelli == 0) {
				break;
			}
		}

		if (contatoreLivelli != 0) {
			throw new RuntimeException("Array Json malformato "+ input);
		}

		return obj;
	}
}
