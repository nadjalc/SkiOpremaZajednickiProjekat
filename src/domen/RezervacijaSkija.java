/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Nadja
 */
public class RezervacijaSkija extends AbstractObject {

    private String RezervacijaID;
    private Date DatumRezervacije;
    private boolean UplataUnapred;
    private Skijas Skijas;
    private List<StavkaRezervacijeSkija> listaStavki;

    public RezervacijaSkija() {
    }

    public RezervacijaSkija(String RezervacijaID, Date DatumRezervacije, boolean UplataUnapred, Skijas Skijas, List<StavkaRezervacijeSkija> listaStavki) {
        this.RezervacijaID = RezervacijaID;
        this.DatumRezervacije = DatumRezervacije;
        this.UplataUnapred = UplataUnapred;
        this.Skijas = Skijas;
        this.listaStavki = listaStavki;
    }

    @Override
    public String vratiNazivTabele() {
        return "rezervacijaskija";
    }

    @Override
    public String vratiParametre() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(DatumRezervacije);
        return String.format("'%s', '%s', '%d', '%s'", RezervacijaID, datum, (UplataUnapred) ? 1 : 0, Skijas.getSkijasID());
    }

    @Override
    public String vratiPK() {
        return "RezervacijaID";
    }

    @Override
    public String vratiVrednostPK() {
        return RezervacijaID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> listaRezervacija = new ArrayList<>();
        try {
            while (rs.next()) {
                String rezervacijaID = rs.getString("RezervacijaID");
                Date datumRezervacije = rs.getDate("DatumRezervacije");
                boolean uplataUnapred = rs.getBoolean("UplataUnapred");
                String skijasID = rs.getString("SkijasID");

                RezervacijaSkija rSkija = new RezervacijaSkija(rezervacijaID, datumRezervacije, uplataUnapred, new Skijas(skijasID, null, null, null), new ArrayList<StavkaRezervacijeSkija>());
                listaRezervacija.add(rSkija);
            }
        } catch (Exception e) {
            System.out.println("Greska kod rezervacije.");
        }
        return listaRezervacija;
    }

    @Override
    public String vratiUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datum = sdf.format(DatumRezervacije);
        return String.format("DatumRezervacije='%s',UplataUnapred='%d',SkijasID='%s'", datum, (UplataUnapred) ? 1 : 0, Skijas.getSkijasID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.RezervacijaID = pk;

    }

    public String getRezervacijaID() {
        return RezervacijaID;
    }

    public void setRezervacijaID(String RezervacijaID) {
        this.RezervacijaID = RezervacijaID;
    }

    public Date getDatumRezervacije() {
        return DatumRezervacije;
    }

    public void setDatumRezervacije(Date DatumRezervacije) {
        this.DatumRezervacije = DatumRezervacije;
    }

    public boolean isUplataUnapred() {
        return UplataUnapred;
    }

    public void setUplataUnapred(boolean UplataUnapred) {
        this.UplataUnapred = UplataUnapred;
    }

    public Skijas getSkijas() {
        return Skijas;
    }

    public void setSkijas(Skijas Skijas) {
        this.Skijas = Skijas;
    }

    public List<StavkaRezervacijeSkija> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRezervacijeSkija> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.RezervacijaID);
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
        final RezervacijaSkija other = (RezervacijaSkija) obj;
        if (!Objects.equals(this.RezervacijaID, other.RezervacijaID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RezervacijaSkija{" + "RezervacijaID=" + RezervacijaID + ", DatumRezervacije=" + DatumRezervacije + ", UplataUnapred=" + UplataUnapred + ", Skijas=" + Skijas + '}';
    }
    
    

}
