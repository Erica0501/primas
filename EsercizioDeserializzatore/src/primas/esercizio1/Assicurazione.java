package primas.esercizio1;

import java.time.LocalDate;
import java.util.Objects;

public class Assicurazione {
	
	private LocalDate inizioContratto;
	
	private LocalDate scadenzaContratto;
	
	
	public Assicurazione() {}

	public Assicurazione(LocalDate inizioContratto, LocalDate scadenzaContratto) {
		super();
		this.inizioContratto = inizioContratto;
		this.scadenzaContratto = scadenzaContratto;
	}

	public LocalDate getInizioContratto() {
		return inizioContratto;
	}

	public void setInizioContratto(LocalDate inizioContratto) {
		this.inizioContratto = inizioContratto;
	}

	public LocalDate getScadenzaContratto() {
		return scadenzaContratto;
	}

	public void setScadenzaContratto(LocalDate scadenzaContratto) {
		this.scadenzaContratto = scadenzaContratto;
	}

	@Override
	public String toString() {
		return "Assicurazione (inizioContratto = " + inizioContratto + ", scadenzaContratto = " + scadenzaContratto + ")";
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
