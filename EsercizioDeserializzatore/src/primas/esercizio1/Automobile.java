package primas.esercizio1;

public class Automobile {


	@JSONSerialField("casaCostruttrice")
	private String marca;

	@JSONSerialField
	private String modello;

	@Override
	public String toString() {
		return "Automobile{" +
				"marca='" + marca + '\'' +
				", modello='" + modello + '\'' +
				", anno=" + anno +
				", assicurazione=" + assicurazione +
				'}';
	}

	private int anno;

	private Assicurazione assicurazione;

	public Automobile() {
		super();
	}

	public Automobile(String marca, String modello, int anno, Assicurazione assicurazione) {
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
		this.assicurazione = assicurazione;
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

	@Override
	public int hashCode() {
		return Objects.hash(anno, assicurazione, marca, modello);
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
				&& Objects.equals(marca, other.marca) && Objects.equals(modello, other.modello);
	}
}

