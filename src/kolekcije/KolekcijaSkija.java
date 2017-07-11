/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kolekcije;

import domen.ParSkija;
import java.util.LinkedList;

/**
 *
 * @author Nadja
 */
public class KolekcijaSkija {

    private LinkedList<ParSkija> ls;

    public KolekcijaSkija(LinkedList<ParSkija> ls) {
        this.ls = ls;
    }

    public KolekcijaSkija() {
    }
    
    public LinkedList<ParSkija> vratiListuSkija() {
        return ls;
    }
    
    public void dodajUListu(ParSkija ps){
        ls.add(ps);
    }

    public void setLs(LinkedList<ParSkija> ls) {
        this.ls = ls;
    }

    public void obrisiIzListe(ParSkija ps) {
        ls.remove(ps);
    }
    
    
    
}
