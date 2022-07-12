package primas.esercizio1;

import java.util.Objects;

public class Automobile {


	@JSONSerialField("casaCostruttrice")
	private String marca;

	@JSONSerialField
	private String modello;

	private int anno;

	private Assicurazione assicurazione;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Automobile that = (Automobile) o;
		return anno == that.anno && Objects.equals(marca, that.marca) && Objects.equals(modello, that.modello) && Objects.equals(assicurazione, that.assicurazione);
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca, modello, anno, assicurazione);
	}

	@Override
	public String toString() {
		return "Automobile{" +
				"marca='" + marca + '\'' +
				", modello='" + modello + '\'' +
				", anno=" + anno +
				", assicurazione=" + assicurazione +
				'}';
	}
}

