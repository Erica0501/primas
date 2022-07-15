package primas.esercizio1;

import java.util.Arrays;
import java.util.Objects;

public class Automobile {

	@JSONSerialField("casaCostruttrice")
	private String marca;							
	
	@JSONSerialField								
	private String modello;						
	
	private int anno;	
	
	private Assicurazione assicurazione;
	
	private Persona contraente;
	
	private String [] allestimento;

	public Automobile() {
		super();
	}
	
	public Automobile(String marca, String modello, int anno, Assicurazione assicurazione, String [] allestimento) {	
		this.marca = marca;						
		this.modello = modello;								
		this.anno = anno;
		this.assicurazione = assicurazione;
		this.allestimento = allestimento;
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
	
	public Assicurazione getAssicurazione() {
		return assicurazione;
	}

	public void setAssicurazione(Assicurazione assicurazione) {
		this.assicurazione = assicurazione;
	}

	public String[] getAllestimento() {
		return allestimento;
	}

	public void setAllestimento(String[] allestimento) {
		this.allestimento = allestimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(allestimento);
		result = prime * result + Objects.hash(anno, assicurazione, marca, modello);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobile other = (Automobile) obj;
		return anno == other.anno && Objects.equals(assicurazione, other.assicurazione)
				&& Arrays.equals(allestimento, other.allestimento) && Objects.equals(marca, other.marca)
				&& Objects.equals(modello, other.modello);
	}

	@Override
	public String toString() {
		return "(marca = " + marca + ", modello = " + modello + ", anno = " + anno + ", "
				+ assicurazione + ", allestimento = " + Arrays.toString(allestimento) + ")";
	}
	
}

