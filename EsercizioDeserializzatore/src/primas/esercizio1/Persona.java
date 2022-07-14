package primas.esercizio1;

import java.util.Objects;

public class Persona {
	
	private String nome;
	
	private String cognome;
	
	private int eta;
	
	private Patente patente;
	
	private CartaIdentita cartaIdentita;
	
	public Persona() {}

	public Persona(String nome, String cognome, int eta, Patente patente, CartaIdentita cartaIdentita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.patente = patente;
		this.cartaIdentita = cartaIdentita;
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

	public Patente getPatente() {
		return patente;
	}

	public void setPatente(Patente patente) {
		this.patente = patente;
	}

	public CartaIdentita getCartaIdentita() {
		return cartaIdentita;
	}

	public void setCartaIdentita(CartaIdentita cartaIdentita) {
		this.cartaIdentita = cartaIdentita;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartaIdentita, cognome, eta, nome, patente);
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
		return Objects.equals(cartaIdentita, other.cartaIdentita) && Objects.equals(cognome, other.cognome)
				&& eta == other.eta && Objects.equals(nome, other.nome) && Objects.equals(patente, other.patente);
	}

	@Override
	public String toString() {
		return "Persona (nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", patente=" + patente
				+ ", cartaIdentita=" + cartaIdentita + ")";
	}

	
}
