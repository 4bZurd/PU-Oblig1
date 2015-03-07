/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblig;

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

    
    public Båteier finnEier( int nr )
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            if( løper.getMedlemsnummer() == nr )
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
            if(første == null)
                return false;
            if( første.getMedlemsnummer() == medlemsnr && første.getBåtliste().erTom() )
            {
                første = første.neste;
                return true;
            }
            if( løper.neste != null && løper.neste.getMedlemsnummer() == medlemsnr
                    && første.neste.getBåtliste().erTom() )
            {
                løper.neste = løper.neste.neste;
                return true;
            }
            løper = løper.neste;
        }
        return false;
    }
    
    public Båteier finnBåtEier( String regnr)
    {
        Båteier løper = første;
        
        while( løper != null )
        {
            if( løper.getBåtliste() != null)
            {
                if( løper.getBåtliste().finnBåt(regnr) != null )
                {
                    return løper;
                }
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
