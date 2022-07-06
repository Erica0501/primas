package primas.esercizio;

import java.util.Objects;

public class Studente {

	private String nome;
	private String cognome;
	private int eta;
	private Sesso sesso;
	private ParteTerritorioItaliano parteTerritorioItaliano;
	
	public Studente(String nome, String cognome, int eta, Sesso sesso, ParteTerritorioItaliano parteTerritorioItaliano) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.parteTerritorioItaliano = parteTerritorioItaliano;
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

	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}

	public ParteTerritorioItaliano getParteTerritorioItaliano() {
		return parteTerritorioItaliano;
	}

	public void setParteTerritorioItaliano(ParteTerritorioItaliano parteTerritorioItaliano) {
		this.parteTerritorioItaliano = parteTerritorioItaliano;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + ", eta=" + eta + ", sesso=" + sesso + ", viene dal " + parteTerritorioItaliano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, eta, nome, sesso, parteTerritorioItaliano);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return Objects.equals(cognome, other.cognome) && eta == other.eta && Objects.equals(nome, other.nome)
				&& sesso == other.sesso && parteTerritorioItaliano == other.parteTerritorioItaliano;
	}
}