/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import java.io.Serializable;
import javax.swing.JTextArea;

/**
 *
 * @author Odd
 */
public class EierRegister implements Serializable
{
    Båteier første;
    
    public void settInn( Båteier ny )
    {
        if( ny == null )
            return;
        
        if( første == null )
            første = ny;
        else
        {
            ny.neste = første;
            første = ny;
        }
    }
    
    /**
     * trenger egentlig ikke denne metoden.
     * 
    public void settInnBakerst( Båteier ny )
    {
        Båteier løper = første;
        
        while( løper.neste != null )
        {
            løper = løper.neste;
        }
        
        løper.neste = ny;
    }
     * @param fornavn
     * @param etternavn
     * @param nr
     * @return 
    */
    
    public Båteier finnBåteier( String fornavn, String etternavn, int nr )
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            if( løper.getFornavn().compareToIgnoreCase(fornavn) == 0 &&
                    løper.getEtternavn().compareToIgnoreCase(etternavn) == 0 &&
                    løper.getMedlemsnummer() == nr )
            {
                return løper;
            }
            løper = løper.neste;
        }
        return null;
    }
    
    public boolean slettBåteier( int medlemsnr )
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            if( løper.neste.getMedlemsnummer() == medlemsnr && løper.neste.getBåt() == null )
            {
                løper.neste = løper.neste.neste;
                return true;
            }
            løper = løper.neste;
        }
        return false;
    }
    
    public Båt finnBåt( String regnr)
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            if( løper.getBåt().getRegnr().equals(regnr) )
            {
                return løper.getBåt();
            }
            løper = løper.neste;
        }
        return null;
    }
    
    public void skrivListe( JTextArea utskriftområde )
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            utskriftområde.append( løper.toString() );
            løper = løper.neste;
        }
    }    
}
