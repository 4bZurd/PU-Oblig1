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
    private int regnr;
    private int lengde;
    private String merket;
    private String typen;
    private int hkr;
    private String fargen;
      
    //Klassens konstruktør
    public Båt(int rnr, int fot, int hk, String merke, String type, String farge)
  {
    rnr = regnr;
    fot = lengde;
    hk = hkr;
    merke = merket;
    type = typen;
    farge = fargen;
  }
  
  public int getRegnr() 
    {
        return regnr;
    }
  
    //Klassens toStringmetode, skriver ut informasjon om båten
    public String toString()
    {
       String ut = "";
               ut = "Registreringsnummer: " + regnr + "\nLengde: " + lengde +
                       "\nMerke: " + merket + "\nType: " + typen + 
                       "\nHestekrefter:" + hkr + "\nFarge:" + fargen;
               return ut;
    }
}
}
