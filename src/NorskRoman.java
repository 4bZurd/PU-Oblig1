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
public class NorskRoman extends Roman 
{
    private String målform;
    
    public NorskRoman(String f, String t, int s, double p, String sj, String m ) 
    {
        super(f,t,s,p,sj);
        målform = m;
    }
    
    public NorskRoman()
    {
        
    }
    
    public void setMålform( String m )
    {
        målform = m;
    }
    
    
    public String getMålform() 
    {
        return målform;
    }
    
    @Override
    public String toString() {
        String utskrift;
        utskrift = super.toString() + "\n" + getMålform() + "\n";
        return utskrift;
    }
    
    @Override
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            super.lesObjektFraFil(input);
            setMålform(input.readUTF());
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
        output.writeUTF("NorskRoman");
        super.skrivObjektTilFil(output);
        output.writeUTF( målform );
    }
}
