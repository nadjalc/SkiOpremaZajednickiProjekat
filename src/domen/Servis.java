/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nadja
 */
public class Servis extends AbstractObject {

    private String ServisID;
    private Date DatumServisa;
    private boolean Ostrenje;
    private boolean Voskiranje;
    private ParSkija ParSkija;

    public Servis(String ServisID, Date DatumServisa, boolean Ostrenje, boolean Voskiranje, ParSkija ParSkija) {
        this.ServisID = ServisID;
        this.DatumServisa = DatumServisa;
        this.Ostrenje = Ostrenje;
        this.Voskiranje = Voskiranje;
        this.ParSkija = ParSkija;
    }

    @Override
    public String vratiNazivTabele() {
        return "servis";
    }

    @Override
    public String vratiParametre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getServisID() {
        return ServisID;
    }

    public void setServisID(String ServisID) {
        this.ServisID = ServisID;
    }

    public Date getDatumServisa() {
        return DatumServisa;
    }

    public void setDatumServisa(Date DatumServisa) {
        this.DatumServisa = DatumServisa;
    }

    public boolean isOstrenje() {
        return Ostrenje;
    }

    public void setOstrenje(boolean Ostrenje) {
        this.Ostrenje = Ostrenje;
    }

    public boolean isVoskiranje() {
        return Voskiranje;
    }

    public void setVoskiranje(boolean Voskiranje) {
        this.Voskiranje = Voskiranje;
    }

    public ParSkija getParSkija() {
        return ParSkija;
    }

    public void setParSkija(ParSkija ParSkija) {
        this.ParSkija = ParSkija;
    }

    
}
