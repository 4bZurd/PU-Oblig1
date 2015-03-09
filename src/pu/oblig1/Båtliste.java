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
    	
    	    //Setter inn en ny båt i båtlisten
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

    	    //Finner båt i båtlisten ved hjelp av registreringsnummer.
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
	    
    	    //Sletter båt fra listen, med registreringsnummer.
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
            
            //Sjekker om båtlisten er tom.
            public boolean erTom()
            {
                return første == null;
            }
    
	    //Klassens toString-metode. Skriver ut info om båtene i listen.
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
