package primasPro.start.model;

import java.util.Objects;

public class Studente {

	private String nome;
	
	private String cognome;
	
	private int eta;
	
	private SESSO sesso;
	
	private TN tn;
	
	public Studente() {
		super();
	}

	public Studente(String nome, String cognome, int eta, SESSO sesso, TN tn) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.sesso = sesso;
		this.tn = tn;
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

	public SESSO getSesso() {
		return sesso;
	}

	public void setSesso(SESSO sesso) {
		this.sesso = sesso;
	}

	public TN getTn() {
		return tn;
	}

	public void setTn(TN tn) {
		this.tn = tn;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", sesso=" + sesso + ", tn=" + tn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, eta, nome, sesso, tn);
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
				&& sesso == other.sesso && tn == other.tn;
	}
}
