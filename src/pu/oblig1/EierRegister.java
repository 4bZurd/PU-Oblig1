/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import javax.swing.JTextArea;

/**
 *
 * @author Odd
 */
public class EierRegister
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
    
    public void settInnBakerst( Båteier ny )
    {
        Båteier løper = første;
        
        while( løper.neste != null )
        {
            løper = løper.neste;
        }
        
        løper.neste = ny;
    }
    
    public Båteier finnEier( String fornavn, String etternavn, int nr )
    {
        
    }
    
    public boolean slettEier()
    {
        
    }
    
    public void finnBåt()
    {
        
    }
    
    public Båteier finnBakerste()
    {

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
