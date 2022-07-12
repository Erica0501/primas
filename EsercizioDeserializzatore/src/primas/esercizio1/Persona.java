package primas.esercizio1;

import java.util.Objects;

public class Persona {
	
	private String nome;
	
	private String cognome;
	
	private int eta;

	public Persona(String nome, String cognome, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, eta, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(cognome, other.cognome) && eta == other.eta && Objects.equals(nome, other.nome);
	}
}
