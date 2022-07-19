package primas.esercizio1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;



public class Automobile {
	
	@JSONSerialField("casaCostruttrice")
	private String marca;							
	
	@JSONSerialField								
	private String modello;						
	
	@JSONSerialField
	private int anno;	
	
	@JSONSerialField
	private Assicurazione assicurazione;
	
	@JSONSerialField
	private Persona contraente;
	
	@JSONSerialField
	private String [] allestimento;
	
	@JSONSerialField
	private List<String> all2;

	public Automobile() {
		super();
	}

	public Automobile(String marca, String modello, int anno, Assicurazione assicurazione, Persona contraente,
			String[] allestimento) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.assicurazione = assicurazione;
		this.contraente = contraente;
		this.allestimento = allestimento;
	}

	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public int getAnno() {
		return anno;
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

	public Persona getContraente() {
		return contraente;
	}

	public void setContraente(Persona contraente) {
		this.contraente = contraente;
	}

	public String[] getAllestimento() {
		return allestimento;
	}

	public void setAllestimento(String[] allestimento) {
		this.allestimento = allestimento;
	}

	public List<String> getAll2() {
		return all2;
	}

	public void setAll2(List<String> all2) {
		this.all2 = all2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(allestimento);
		result = prime * result + Objects.hash(anno, assicurazione, contraente, marca, modello);
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
		return Arrays.equals(allestimento, other.allestimento) && anno == other.anno
				&& Objects.equals(assicurazione, other.assicurazione) && Objects.equals(contraente, other.contraente)
				&& Objects.equals(marca, other.marca) && Objects.equals(modello, other.modello);
	}

	@Override
	public String toString() {
		return "Automobile marca=" + marca + ", modello=" + modello + ", anno=" + anno + ", assicurazione="
				+ assicurazione + ", contraente=" + contraente + ", allestimento=" + Arrays.toString(allestimento)
				+  ", allestimento2= "+ all2 + "";
	}
}
