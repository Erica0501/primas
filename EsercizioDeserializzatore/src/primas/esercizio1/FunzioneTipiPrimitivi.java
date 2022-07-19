package primas.esercizio1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@FunctionalInterface
public interface FunzioneTipiPrimitivi {
	
	void setTipo (Method setter, Object obj, String inizioValore) throws IllegalAccessException , IllegalArgumentException , InvocationTargetException ;

}
