/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokprog2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Odd
 */
abstract public class Bok
{
    
    private String forfatter;
    private String tittel;
    private int sider;
    private double pris;
    Bok neste;
    
    /**
     * Denne konstuktøren oppretter en bok spesifisert ved forfatter, tittel, sideantall
     * og pris.
     *
     * @param f = bokens forfatter
     * @param t = bokens tittel
     * @param s = antall sider i boken
     * @param p = bokens pris
     */
    
    public Bok( String f, String t, int s, double p )
    {
        forfatter = f;
        tittel = t;
        sider = s;
        pris = p;
        neste = null;
    }
    
    /**
     * Denne parameterløse konstuktøren er for bruk av DataInputStream, som krever
     * en parameterløs konstruktør og set-metoder for datafelt.
     */
    
    
    public Bok()       
    {
        neste = null;
    }
    
    public void setForfatter( String f )
    {
        forfatter = f;
    }
        
    public void setTittel( String t )
    {
        tittel = t;
    }
    
    public void setSider( int s )
    {
        sider = s;
    }
    
    public void setPris( double p )
    {
        pris = p;
    }
    
    public String getForfatter()
    {
        return forfatter;
    }
    
    public String getTittel()
    {
        return tittel;
    }
    
    public int getSider()
    {
        return sider;
    }
    
    public double getPris()
    {
        return pris;
    }
    
    /**
     * Metoden lager en formatert tekstreng om bokens forfatter, tittel, sideantall
     * pris.
     *
     * @return utskrift formatert tekst String
     */
    
    @Override
    public String toString()
    {
        String utskrift = "\nForfatter: " + forfatter + "\nTittel: " + tittel +
                          "\nSideantall: " + sider + "\nPris: " + pris + "\n";
        
        return utskrift; 
    }
    
    /**
     * Leser inn informasjon om bokens datafelt fra fil i følgende rekkefølge:
     * forfatter, tittel, sider, pris.
     * 
     * @param input DataInputStream object.
     * @return true når innlesning er ferdig.
     * @retur false hvis det har oppstått en feil.
     *                 
     */
    
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            setForfatter(input.readUTF());
            setTittel(input.readUTF());
            setSider(input.readInt());
            setPris(input.readDouble());
            return true;
        }
        catch( IOException ioe)
        {
            return false;
        }
    }
    
    /** 
     * 
     * Metoden skriver bokens datafelt til fil i følgende rekkefølge:
     * forfatter, tittel, sider, pris.
     * 
     * @param output DataOutputStream object.
     * @throws java.io.IOException slik at metodens kaller oppdager feil ved 
     * innlesning av fil
     */
    
    //Ikke ferdig.
    public void skrivObjektTilFil( DataOutputStream output ) throws IOException
    {
        output.writeUTF(forfatter);
        output.writeUTF(tittel);
        output.writeInt(sider);
        output.writeDouble(pris);
    } 
}
