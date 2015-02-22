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
public class Skolebok extends Bok {
    
    private int klassetrinn;
    private String fag;
    
    public Skolebok( String f, String t, int s, double p, int kt, String sf ) {
        super( f, t, s, p);
        klassetrinn = kt;
        fag = sf;
    }
    
    public Skolebok()
    {
        
    }
    
    public void setKlassetrinn( int trinn )
    {
        klassetrinn = trinn;
    }
    
    public void setSkolefag( String f )
    {
        fag = f;
    }
    
    public int getKlassetrinn() 
    {
        return klassetrinn;
    }
    
    public String getSkolefag() 
    {
        return fag;
    }
    
    @Override
    public String toString() {
        String utskrift = super.toString() + "Trinn: " +  klassetrinn + 
                          "\nSkolefag: " + fag + "\n";
        
        
        return utskrift;
    }
    
    public boolean lesObjektFraFil( DataInputStream input )
    {
        try
        {
            super.lesObjektFraFil(input);            
            setKlassetrinn(input.readInt());
            setSkolefag(input.readUTF());
            
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
        output.writeUTF("Skolebok");
        super.skrivObjektTilFil(output);
        output.writeInt(klassetrinn);
        output.writeUTF( fag );
    }
   
}
