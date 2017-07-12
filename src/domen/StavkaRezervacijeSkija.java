/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Nadja
 */
public class StavkaRezervacijeSkija extends AbstractObject {

    private RezervacijaSkija RezervacijaSkija;
    private ParSkija ParSkija;
    private int RedniBrojStavke;

    public StavkaRezervacijeSkija() {
    }
    
    

    public StavkaRezervacijeSkija(RezervacijaSkija RezervacijaSkija, ParSkija ParSkija, int RedniBrojStavke) {
        this.RezervacijaSkija = RezervacijaSkija;
        this.ParSkija = ParSkija;
        this.RedniBrojStavke = RedniBrojStavke;
    }
    @Override
    public String vratiNazivTabele() {
        return "stavkarezervacijeskija";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", RezervacijaSkija.getRezervacijaID(), RedniBrojStavke, ParSkija.getParSkijaID());
    }

    @Override
    public String vratiPK() {
        return null;

    }

    @Override
    public String vratiVrednostPK() {
        return RezervacijaSkija.getRezervacijaID();
    }

    @Override
    public String vratiSlozenPK() {
        return String.format("RedniBrojStavke = %s AND RezervacijaID = %s", RedniBrojStavke, RezervacijaSkija.getRezervacijaID());

    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                String RezervacijaID = rs.getString("RezervacijaID");
                String ParSkijaID = rs.getString("ParSkijaID");
                int RedniBrojStavkeRB = rs.getInt("RedniBrojStavke");
                RezervacijaSkija rez = new RezervacijaSkija(RezervacijaID, null, false, null, null);
                ParSkija ps = new ParSkija(ParSkijaID, 0, 0, null, null, null);
                StavkaRezervacijeSkija srs = new StavkaRezervacijeSkija(rez, ps, RedniBrojStavkeRB);
                stavke.add(srs);
            }
        } catch (Exception e) {
            System.out.println("Greska kod stavki rezervacije." + e.getMessage());
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {
        return String.format("ParSkijaID = %s, RedniBrojStavke = %s", ParSkija.getParSkijaID(), RedniBrojStavke);
    }

    @Override
    public void postaviVrednostPK(String pk) {
    }

    public RezervacijaSkija getRezervacijaSkija() {
        return RezervacijaSkija;
    }

    public void setRezervacijaSkija(RezervacijaSkija RezervacijaSkija) {
        this.RezervacijaSkija = RezervacijaSkija;
    }

    public ParSkija getParSkija() {
        return ParSkija;
    }

    public void setParSkija(ParSkija ParSkija) {
        this.ParSkija = ParSkija;
    }

    public int getRedniBrojStavke() {
        return RedniBrojStavke;
    }

    public void setRedniBrojStavke(int RedniBrojStavke) {
        this.RedniBrojStavke = RedniBrojStavke;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.RezervacijaSkija);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaRezervacijeSkija other = (StavkaRezervacijeSkija) obj;
        if (this.RedniBrojStavke != other.RedniBrojStavke) {
            return false;
        }
        if (!Objects.equals(this.RezervacijaSkija, other.RezervacijaSkija)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "StavkaRezervacijeSkija{" + "RezervacijaSkija=" + RezervacijaSkija + ", ParSkija=" + ParSkija + ", RedniBrojStavke=" + RedniBrojStavke + '}';
    }
    
    

}
