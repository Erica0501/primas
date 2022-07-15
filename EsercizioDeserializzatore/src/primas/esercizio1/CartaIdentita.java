package primas.esercizio1;

import java.time.LocalDate;
import java.util.Objects;

public class CartaIdentita {
	
	private String nome;
	private String cognome;
	private String comune;
	private String nazionalita;
	private String sesso;
	private String residenza;
	private String via;
	private String professione;
	private String statura;
	private String capelli;
	private String segniParticolari;
	private String numeroDiSerie;
	
	private LocalDate emissione;
	private LocalDate scadenza;
	private LocalDate dataDiNascita;
	
	private int altezza;
	
	public CartaIdentita() {}

	public CartaIdentita(String nome, String cognome, String comune, String nazionalita, String sesso, String residenza,
			String via, String professione, String statura, String capelli, String segniParticolari,
			String numeroDiSerie, LocalDate emissione, LocalDate scadenza, LocalDate dataDiNascita, int altezza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.comune = comune;
		this.nazionalita = nazionalita;
		this.sesso = sesso;
		this.residenza = residenza;
		this.via = via;
		this.professione = professione;
		this.statura = statura;
		this.capelli = capelli;
		this.segniParticolari = segniParticolari;
		this.numeroDiSerie = numeroDiSerie;
		this.emissione = emissione;
		this.scadenza = scadenza;
		this.dataDiNascita = dataDiNascita;
		this.altezza = altezza;
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

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getProfessione() {
		return professione;
	}

	public void setProfessione(String professione) {
		this.professione = professione;
	}

	public String getStatura() {
		return statura;
	}

	public void setStatura(String statura) {
		this.statura = statura;
	}

	public String getCapelli() {
		return capelli;
	}

	public void setCapelli(String capelli) {
		this.capelli = capelli;
	}

	public String getSegniParticolari() {
		return segniParticolari;
	}

	public void setSegniParticolari(String segniParticolari) {
		this.segniParticolari = segniParticolari;
	}

	public String getNumeroDiSerie() {
		return numeroDiSerie;
	}

	public void setNumeroDiSerie(String numeroDiSerie) {
		this.numeroDiSerie = numeroDiSerie;
	}

	public LocalDate getEmissione() {
		return emissione;
	}

	public void setEmissione(LocalDate emissione) {
		this.emissione = emissione;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}

	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altezza, capelli, cognome, comune, dataDiNascita, emissione, nazionalita, nome,
				numeroDiSerie, professione, residenza, scadenza, segniParticolari, sesso, statura, via);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaIdentita other = (CartaIdentita) obj;
		return altezza == other.altezza && Objects.equals(capelli, other.capelli)
				&& Objects.equals(cognome, other.cognome) && Objects.equals(comune, other.comune)
				&& Objects.equals(dataDiNascita, other.dataDiNascita) && Objects.equals(emissione, other.emissione)
				&& Objects.equals(nazionalita, other.nazionalita) && Objects.equals(nome, other.nome)
				&& Objects.equals(numeroDiSerie, other.numeroDiSerie) && Objects.equals(professione, other.professione)
				&& Objects.equals(residenza, other.residenza) && Objects.equals(scadenza, other.scadenza)
				&& Objects.equals(segniParticolari, other.segniParticolari) && Objects.equals(sesso, other.sesso)
				&& Objects.equals(statura, other.statura) && Objects.equals(via, other.via);
	}

	@Override
	public String toString() {
		return "CartaIdentita (nome=" + nome + ", cognome=" + cognome + ", comune=" + comune + ", nazionalita="
				+ nazionalita + ", sesso=" + sesso + ", residenza=" + residenza + ", via=" + via + ", professione="
				+ professione + ", statura=" + statura + ", capelli=" + capelli + ", segniParticolari="
				+ segniParticolari + ", numeroDiSerie=" + numeroDiSerie + ", emissione=" + emissione + ", scadenza="
				+ scadenza + ", dataDiNascita=" + dataDiNascita + ", altezza=" + altezza + ")";
	}
	
	
	

}
