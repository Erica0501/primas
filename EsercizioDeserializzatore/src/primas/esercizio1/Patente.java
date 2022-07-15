package primas.esercizio1;

import java.time.LocalDate;
import java.util.Objects;

public class Patente {
	
	private String nome;
	private String cognome;
	private String numeroPatente;
	private String categoria;
	
	private LocalDate dataDiNascita;
	private LocalDate dataDiRilascio;
	private LocalDate dataDiScadenza;
	
	public Patente() {}

	public Patente(String nome, String cognome, String numeroPatente, String categoria, LocalDate dataDiNascita,
			LocalDate dataDiRilascio, LocalDate dataDiScadenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroPatente = numeroPatente;
		this.categoria = categoria;
		this.dataDiNascita = dataDiNascita;
		this.dataDiRilascio = dataDiRilascio;
		this.dataDiScadenza = dataDiScadenza;
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

	public String getNumeroPatente() {
		return numeroPatente;
	}

	public void setNumeroPatente(String numeroPatente) {
		this.numeroPatente = numeroPatente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public LocalDate getDataDiRilascio() {
		return dataDiRilascio;
	}

	public void setDataDiRilascio(LocalDate dataDiRilascio) {
		this.dataDiRilascio = dataDiRilascio;
	}

	public LocalDate getDataDiScadenza() {
		return dataDiScadenza;
	}

	public void setDataDiScadenza(LocalDate dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoria, cognome, dataDiNascita, dataDiRilascio, dataDiScadenza, nome, numeroPatente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patente other = (Patente) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(cognome, other.cognome)
				&& Objects.equals(dataDiNascita, other.dataDiNascita)
				&& Objects.equals(dataDiRilascio, other.dataDiRilascio)
				&& Objects.equals(dataDiScadenza, other.dataDiScadenza) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroPatente, other.numeroPatente);
	}

	@Override
	public String toString() {
		return "Patente [nome=" + nome + ", cognome=" + cognome + ", numeroPatente=" + numeroPatente + ", categoria="
				+ categoria + ", dataDiNascita=" + dataDiNascita + ", dataDiRilascio=" + dataDiRilascio
				+ ", dataDiScadenza=" + dataDiScadenza + "]";
	}
}
