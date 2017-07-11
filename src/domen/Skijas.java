/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

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
public class Skijas extends AbstractObject {

    private String SkijasID;
    private String Ime;
    private String Prezime;
    private String BrojTelefona;

    public Skijas() {
    }

    
    public Skijas(String SkijasID, String Ime, String Prezime, String BrojTelefona) {
        this.SkijasID = SkijasID;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.BrojTelefona = BrojTelefona;
    }

    @Override
    public String vratiNazivTabele() {
        return "skijas";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s'", Ime, Prezime, BrojTelefona);
    }

    @Override
    public String vratiPK() {
        return "SkijasID";
    }

    @Override
    public String vratiVrednostPK() {
        return SkijasID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> listaSkijasa = new ArrayList<>();
        try {
            while (rs.next()) {
                String SkijasID = rs.getString("SkijasID");
                String Ime = rs.getString("Ime");
                String Prezime = rs.getString("Prezime");
                String BrojTelefona = rs.getString("BrojTelefona");

                Skijas s = new Skijas(SkijasID, Ime, Prezime, BrojTelefona);
                listaSkijasa.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Skijas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaSkijasa;
    }

    @Override
    public String vratiUpdate() {
        return String.format("Ime=%s, Prezime=%s, BrojTelefona=%s", Ime, Prezime, BrojTelefona);

    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getSkijasID() {
        return SkijasID;
    }

    public void setSkijasID(String SkijasID) {
        this.SkijasID = SkijasID;
    }

    public String getIme() {
        return Ime;
    }

    public void setIme(String Ime) {
        this.Ime = Ime;
    }

    public String getPrezime() {
        return Prezime;
    }

    public void setPrezime(String Prezime) {
        this.Prezime = Prezime;
    }

    public String getBrojTelefona() {
        return BrojTelefona;
    }

    public void setBrojTelefona(String BrojTelefona) {
        this.BrojTelefona = BrojTelefona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.SkijasID);
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
        final Skijas other = (Skijas) obj;
        if (!Objects.equals(this.SkijasID, other.SkijasID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Ime + " " + Prezime;
    }

   
    

   


    
}
