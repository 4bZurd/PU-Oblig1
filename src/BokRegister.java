/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokprog2;

import javax.swing.JTextArea;

/**
 *
 * @author Odd
 */
public class BokRegister 
{
    Bok første;

    public void settInn( Bok ny ) 
    {
        if(ny == null)
            return;
        
        if( første == null )
            første = ny;
        else 
        {
            ny.neste = første;
            første = ny;
        }
    }
    
    public void settInnBakerst( Bok ny )
    {
        if( ny == null )
            return;
        
        if( første == null )
            første = ny;
        else
        {
            Bok løper = første;
        
            while( løper.neste != null )
                løper = løper.neste;
        
            løper.neste = ny;
  
        }
    }
    
    public void skrivListe( JTextArea bøker ) {
        
        Bok løper = første;
        
        while( løper != null ) 
        {
            bøker.append( løper.toString() );
            løper = løper.neste;
        }
    }
}

