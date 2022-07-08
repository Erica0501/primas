package primas.esercizio1;

public class Automobile {

	@JSONSerialField("casaCostruttrice")
	private String marca;							
	
	@JSONSerialField								
	private String modello;						
	
	private int anno;			

	public Automobile() {
		super();
	}

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


	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {	
		return marca + " " + modello + " " + anno;
	}
}
