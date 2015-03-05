/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import java.io.Serializable;

/**
 *
 * @author Marthejansonskogen
 */
public class Båt implements Serializable
{
    
    private final String regnr;
    private final int lengde;
    private final String merket;
    private final String typen;
    private final int hkr;
    private final String fargen;
    private final int alder;
      
    //Klassens konstruktør
    public Båt(String rnr, int fot, int hk, String merke, String type, String farge, int år)
    {
        regnr = rnr;
        lengde = fot;
        hkr = hk;
        merket = merke;
        typen = type;
        fargen = farge;
        alder = år;
    }
  
    public String getRegnr() 
    {
        return regnr;
    }
  
    //Klassens toStringmetode, skriver ut informasjon om båten
    @Override
    public String toString()
    {
        String ut = "\nRegistreringsnummer: " + regnr + "\nLengde: " + lengde +
                       "\nMerke: " + merket + "\nType: " + typen + 
                       "\nHestekrefter:" + hkr + "\nFarge:" + fargen + "\nÅr: "
                + alder;
        return ut;
    }
}
