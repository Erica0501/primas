package primas.esercizio1;

import java.util.Date;
import java.util.Objects;

public class Assicurazione {

        private Date inizioContratto;

        private Date scadenzaContratto;

        //private Persona contraente;

        public Assicurazione() {}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assicurazione that = (Assicurazione) o;
        return Objects.equals(inizioContratto, that.inizioContratto) && Objects.equals(scadenzaContratto, that.scadenzaContratto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inizioContratto, scadenzaContratto);
    }

    @Override
    public String toString() {
        return "Assicurazione{" +
                "inizioContratto=" + inizioContratto +
                ", scadenzaContratto=" + scadenzaContratto +
                '}';
    }
}
