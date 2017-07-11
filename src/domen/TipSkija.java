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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadja
 */
public class TipSkija extends AbstractObject {

    private String TipSkijaID;
    private String NazivTipa;

    public TipSkija() {
    }

    public TipSkija(String TipSkijaID) {
        this.TipSkijaID = TipSkijaID;
    }
    
    

    public TipSkija(String tipSkijaID, String nazivTipa) {
        this.TipSkijaID = tipSkijaID;
        this.NazivTipa = nazivTipa;
    }

    @Override
    public String vratiNazivTabele() {
        return "tipskija";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s'", TipSkijaID, NazivTipa);
    }

    @Override
    public String vratiPK() {
        return "TipSkijaID";
    }

    @Override
    public String vratiVrednostPK() {
        return TipSkijaID;
    }

    @Override
    public String vratiSlozenPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {
        List<AbstractObject> listaTipova = new ArrayList<>();
        try {
            while (rs.next()) {
                String tipSkijaID = rs.getString("TipSkijaID");
                String nazivTipa = rs.getString("NazivTipa");
                TipSkija ts = new TipSkija(tipSkijaID, nazivTipa);
                listaTipova.add(ts);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipSkija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaTipova;
    }

    @Override
    public String vratiUpdate() {
        return String.format("NazivTipa='%s'", NazivTipa);
    }

    @Override
    public void postaviVrednostPK(String pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipSkijaID() {
        return TipSkijaID;
    }

    public void setTipSkijaID(String TipSkijaID) {
        this.TipSkijaID = TipSkijaID;
    }

    public String getNazivTipa() {
        return NazivTipa;
    }

    public void setNazivTipa(String NazivTipa) {
        this.NazivTipa = NazivTipa;
    }

    @Override
    public String toString() {
        return NazivTipa;
    }


    
    
}