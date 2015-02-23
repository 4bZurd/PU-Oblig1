package bokprog2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Odd
 */
abstract public class Roman extends Bok
{
    private String sjanger;
    
    /**
     * 
     * @param f Romanens forfatter
     * @param t Romanens tittel
     * @param s Romanens sideantall 
     * @param p Romanens pris
     * @param g Romanens sjanger
     */
    
    public Roman( String f, String t, int s, double p, String g)
    {
        super( f, t, s, p );
        sjanger = g;
    }
    
    public Roman()
    {
        
    }
        
    public void setSjanger( String s )
    {
        sjanger = s;
    }
    
    public String getSjanger()
    {
        return sjanger;
    }
    
    /**
     * Metoden kaller super klassens toString metode og tilføyer de unike datafeltene
     * for Roman klassen
     * 
     * @return utskrift 
     */
    
    @Override
    public String toString()
    {
        String utskrift;
        utskrift = super.toString() + "Sjanger: " + sjanger + "\n";
        return utskrift;
    }
    
    /**
     * 
     * 
     * @param input tar i mot et DataInputStream objekt med filsti.
     * @return true når metoden har lest filen uten problemer.
     */
    
    @Override
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            super.lesObjektFraFil(input);
            setSjanger(input.readUTF());
            return true;
        }
        catch( IOException ioe)
        {
            return false;
        }
    }
    
    @Override
    public void skrivObjektTilFil( DataOutputStream output ) throws IOException
    {
        super.skrivObjektTilFil(output);
        output.writeUTF(sjanger);
    }
}
