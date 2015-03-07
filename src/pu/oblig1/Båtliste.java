/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblig;

import java.io.Serializable;

/**
 *
 * @author Marthejansonskogen
 */
public class Båtliste implements Serializable
{
	    Båt første;
    
	    public void settInn( Båt ny )
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

    
	    public Båt finnBåt( String nr )
	    {
	        Båt løper = første;
        
	        while( løper != null )
	        {
	            if( løper.getRegnr().equals(nr) )
	            {
	                return løper;
	            }
	            løper = løper.neste;
	        }
	        return null;
	    }
    
	    public boolean slettBåt( String regnr )
	    {
	        Båt løper = første;
        
	        while( løper != null )
	        {
	            if(første == null)
	                return false;
	            if( første.getRegnr().equals(regnr) )
	            {
	                første = første.neste;
	                return true;
	            }
	            if( løper.neste.getRegnr().equals(regnr) )
	            {
	                løper.neste = løper.neste.neste;
	                return true;
	            }
	            løper = løper.neste;
	        }
	        return false;
	    }
            
            public boolean erTom()
            {
                return første == null;
            }
    

            @Override
	    public String toString()
	    {
	        Båt løper = første;
                String ut = "";
        
	        while( løper != null )
	        {
	            ut += ( løper.toString() );
	            løper = løper.neste;
	        }
                return ut;
	    }    
	
}
