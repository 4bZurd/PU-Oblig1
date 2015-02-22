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
public class Fagbok extends Bok 
{
    private String fagområde;
    
    public Fagbok( String f, String t, int s, double p, String fo ) 
    {
        super(f,t,s,p);
        fagområde = fo;
    }
    
    public Fagbok()
    {
        
    }
    
    public void setFagområde( String f)
    {
        fagområde = f;
    }
    
    public String getFagområde() 
    {
        return fagområde;
    }
    
    @Override
    public String toString() 
    {
        String utskrift;
        utskrift = super.toString() + "Fagområde: " + getFagområde() + "\n";
        return utskrift;
    }

    @Override
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            super.lesObjektFraFil(input);           
            setFagområde(input.readUTF());
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
        output.writeUTF("Fagbok");
        super.skrivObjektTilFil(output);
        output.writeUTF(getFagområde());
    }
}
