package primas.esercizio1;

import java.util.Date;
import java.util.Objects;

public class Assicurazione {
	
	private Date inizioContratto;
	
	private Date scadenzaContratto;
	
	//private Persona contraente;
	
	public Assicurazione() {}

	public Assicurazione(Date inizioContratto, Date scadenzaContratto) {
		super();
		this.inizioContratto = inizioContratto;
		this.scadenzaContratto = scadenzaContratto;
	}

	public Date getInizioContratto() {
		return inizioContratto;
	}

	public void setInizioContratto(Date inizioContratto) {
		this.inizioContratto = inizioContratto;
	}

	public Date getScadenzaContratto() {
		return scadenzaContratto;
	}

	public void setScadenzaContratto(Date scadenzaContratto) {
		this.scadenzaContratto = scadenzaContratto;
	}

	


	@Override
	public String toString() {
		return "inizioContratto=" + inizioContratto + ", scadenzaContratto=" + scadenzaContratto
				+ "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(inizioContratto, scadenzaContratto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assicurazione other = (Assicurazione) obj;
		return Objects.equals(inizioContratto, other.inizioContratto)
				&& Objects.equals(scadenzaContratto, other.scadenzaContratto);
	}
}
