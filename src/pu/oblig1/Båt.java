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
    
    private String regnr;
    private int lengde;
    private String merket;
    private String typen;
    private int hkr;
    private String fargen;
      
    //Klassens konstruktør
    public Båt(String rnr, int fot, int hk, String merke, String type, String farge)
    {
        rnr = regnr;
        fot = lengde;
        hk = hkr;
        merke = merket;
        type = typen;
        farge = fargen;
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
                       "\nHestekrefter:" + hkr + "\nFarge:" + fargen;
        return ut;
    }
}

