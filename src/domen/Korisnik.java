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
public class Korisnik extends AbstractObject {

    private String KorisnikID;
    private String KorisnickoIme;
    private String Lozinka;
    private String Ime;
    private String Prezime;
    private boolean Ulogovan;

    public Korisnik(String KorisnikID, String KorisnickoIme, String Lozinka, String Ime, String Prezime, boolean Status) {
        this.KorisnikID = KorisnikID;
        this.KorisnickoIme = KorisnickoIme;
        this.Lozinka = Lozinka;
        this.Ime = Ime;
        this.Prezime = Prezime;
        this.Ulogovan = Status;
    }

    public Korisnik(String KorisnickoIme, String Lozinka) {
        this.KorisnickoIme = KorisnickoIme;
        this.Lozinka = Lozinka;
    }
    
    

    public Korisnik() {
    }

    @Override
    public String vratiNazivTabele() {
        return "korisnik";
    }

    @Override
    public String vratiParametre() {
        return String.format("0, '%s', '%s', '%s', '%s'", KorisnickoIme, Lozinka, Ime, Prezime);
    }

    @Override
    public String vratiPK() {
        return "KorisnikID";
    }

    @Override
    public String vratiVrednostPK() {
        return KorisnikID;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> korisnici = new ArrayList<>();
        try {
            while (rs.next()) {
                String KorisnikID = rs.getString("KorisnikID");
                String KorisnickoIme = rs.getString("KorisnickoIme");
                String Lozinka = rs.getString("Lozinka");
                String Ime = rs.getString("Ime");
                String Prezime = rs.getString("Prezime");
                boolean Status = false;

                Korisnik k = new Korisnik(KorisnikID, KorisnickoIme, Lozinka, Ime, Prezime, Status);
                korisnici.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Korisnik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return korisnici;
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String pk) {
        this.KorisnikID = pk;
    }

    public String getKorisnickoIme() {
        return KorisnickoIme;
    }

    public void setKorisnickoIme(String KorisnickoIme) {
        this.KorisnickoIme = KorisnickoIme;
    }

    public String getLozinka() {
        return Lozinka;
    }

    public void setLozinka(String Lozinka) {
        this.Lozinka = Lozinka;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getKorisnikID() {
        return KorisnikID;
    }

    public void setKorisnikID(String KorisnikID) {
        this.KorisnikID = KorisnikID;
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

    public boolean isUlogovan() {
        return Ulogovan;
    }

    public void setUlogovan(boolean Ulogovan) {
        this.Ulogovan = Ulogovan;
    }

    public String getStatusText() {
        if (Ulogovan == false) {
            return "Nije ulogovan";
        } else {
            return "Ulogovan";
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.KorisnikID);
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.KorisnikID, other.KorisnikID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Ime +" "+Prezime;
    }
    
    

}
