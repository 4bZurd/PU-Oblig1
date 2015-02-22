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
public class UtenlandskRoman extends Roman 
{
    
    private String språk;
    
    public UtenlandskRoman(String f, String t, int s, double p, String sj, String sp) 
    {
        super(f,t,s,p,sj);
        språk = sp;
    }
    
    public UtenlandskRoman()
    {
        
    }
    
    public void setSpråk( String s )
    {
        språk = s;
    }
    
    @Override
    public String toString() {
        
        String utskrift;
        utskrift = super.toString() + språk + "\n";
        return utskrift;
    }   
 
    @Override
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            super.lesObjektFraFil(input);            
            setSpråk(input.readUTF());
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
        output.writeUTF("UtenlandskRoman");
        super.skrivObjektTilFil(output);
        output.writeUTF(språk);
    }
}
