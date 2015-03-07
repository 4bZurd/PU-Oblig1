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

/**
 *
 * @author Thomas
 */
public class Båteier implements Serializable
{
    private String fornavn;
    private String etternavn;
    private String adresse;
    private int medlemsnummer;
    private static int nestenr = 1;
    Båteier neste;
    private final Båtliste båtliste;
    
    // Benyttes dersom eierskap til Båt er ukjent. 3 parametre i konstruktør.
    
    public Båteier(String fornavn, String etternavn, String adresse)
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        medlemsnummer = nestenr++; 
        båtliste = new Båtliste();
    }
    
    //Benyttes dersom man vet hvilken Båt som eieren eier. 4 parametre.
    
    public String getFornavn()
    {
        return fornavn;
    }

    public void setFornavn(String fornavn)
    {
        this.fornavn = fornavn;
    }

    public String getEtternavn()
    {
        return etternavn;
    }

    public void setEtternavn(String etternavn)
    {
        this.etternavn = etternavn;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public int getMedlemsnummer()
    {
        return medlemsnummer;
    }

    public void setMedlemsnummer(int medlemsnummer)
    {
        this.medlemsnummer = medlemsnummer;
    }
    
    public int getNesteNr()
    {
        return nestenr;
    }
    
    public void setNesteNr( int n )
    {
        nestenr = n;
    }

    public Båtliste getBåtliste() {
        return båtliste;
    }
    /**
    public void setBåt(Båt Båt) {
        this.Båt = Båt;
    }
    */

    // Returnerer en String med eierinformasjon som kan vises i vindu.
    
    @Override
    public String toString()
    {
        StringBuilder bygger = new StringBuilder();
        bygger.append("\nFornavn: ");
        bygger.append(fornavn);
        bygger.append("\nEtternavn: ");
        bygger.append(etternavn);
        bygger.append("\nAdresse: ");
        bygger.append(adresse);
        bygger.append("\nMedlemsnummer: ");
        bygger.append(medlemsnummer);    
        if( båtliste != null)
        {
            bygger.append( båtliste.toString());
            bygger.append("\n\n");
            return bygger.toString();
        } else {
            bygger.append("\n");
            return bygger.toString();
        }
    }
}
