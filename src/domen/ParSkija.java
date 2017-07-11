/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadja
 */
public class ParSkija extends AbstractObject {

    private String ParSkijaID;
    private int Duzina;
    private double Radijus;
    private String Vezovi;
    private String Marka;
    private TipSkija TipSkija;

    public ParSkija() {
    }

    public ParSkija(String parSkijaID, int duzina, double radijus, String vezovi, String marka, TipSkija tipSkija) {
        this.ParSkijaID = parSkijaID;
        this.Duzina = duzina;
        this.Radijus = radijus;
        this.Vezovi = vezovi;
        this.Marka = marka;
        this.TipSkija = tipSkija;
    }

    @Override
    public String vratiNazivTabele() {
        return "parskija";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%d', '%,.2f', '%s', '%s', '%s'", ParSkijaID, Duzina, Radijus, Vezovi, Marka, TipSkija.getTipSkijaID());

    }

    @Override
    public String vratiPK() {
        return "ParSkijaID";
    }

    @Override
    public String vratiVrednostPK() {
        return ParSkijaID;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> paroviSkija = new ArrayList<>();
        try {
            while (rs.next()) {
                String parSkijaID = rs.getString("ParSkijaID");
                int duzina = rs.getInt("Duzina");
                double radijus = rs.getDouble("Radijus");
                String vezovi = rs.getString("Vezovi");
                String marka = rs.getString("Marka");
                String tipSkija = rs.getString("TipSkijaID");

                ParSkija parSkija = new ParSkija(parSkijaID, duzina, radijus, vezovi, marka, new TipSkija(tipSkija, null));
                paroviSkija.add(parSkija);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParSkija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return paroviSkija;
    }

    @Override
    public String vratiUpdate() {
        return String.format("Duzina='%s', Radijus='%s', Vezovi='%s', Marka='%s', TipskijaID='%s'", Duzina,Radijus,Vezovi,Marka,TipSkija.getTipSkijaID());
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.ParSkijaID = pk;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getParSkijaID() {
        return ParSkijaID;
    }

    public void setParSkijaID(String ParSkijaID) {
        this.ParSkijaID = ParSkijaID;
    }

    public int getDuzina() {
        return Duzina;
    }

    public void setDuzina(int Duzina) {
        this.Duzina = Duzina;
    }

    public double getRadijus() {
        return Radijus;
    }

    public void setRadijus(double Radijus) {
        this.Radijus = Radijus;
    }

    public String getVezovi() {
        return Vezovi;
    }

    public void setVezovi(String Vezovi) {
        this.Vezovi = Vezovi;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String Marka) {
        this.Marka = Marka;
    }

    public TipSkija getTipSkija() {
        return TipSkija;
    }

    public void setTipSkija(TipSkija TipSkija) {
        this.TipSkija = TipSkija;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.ParSkijaID);
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
        final ParSkija other = (ParSkija) obj;
        if (!Objects.equals(this.ParSkijaID, other.ParSkijaID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ParSkijaID + ":" + Vezovi + ":" + Marka;
    }

  

  



    
    
}
