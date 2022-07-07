package primas.esercizio1;

public class Automobile {

	@JSONSerialField("casaCostruttrice")
	private String marca;							
	
	@JSONSerialField								
	private String modello;						
	
	private int anno;						

	public Automobile(String marca, String modello, int anno) {	
		this.marca = marca;						
		this.modello = modello;								
		this.anno = anno;
	}
	
	public String getMarca() {
		return marca;
	}




	public String getModello() {
		return modello;
	}




	public int getAnno() {
		return anno;
	}




	@Override
	public String toString() {	
		return marca + " " + modello + " " + anno;
	}
}
