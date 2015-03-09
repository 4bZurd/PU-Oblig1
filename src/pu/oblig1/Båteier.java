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
    
    //Klassens konstruktør.
    public Båteier(String fornavn, String etternavn, String adresse)
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        medlemsnummer = nestenr++; 
        båtliste = new Båtliste();
    }
    //Get-metode for eiers fornavn. Benyttes ikke i dette programmet.
    public String getFornavn()
    {
        return fornavn;
    }
    //Set-metode for eiers fornavn. Benyttes ikke i dette programmet.
    public void setFornavn(String fornavn)
    {
        this.fornavn = fornavn;
    }
    
    //Get-metode for eiers etternavn. Benyttes ikke i dette programmet.
    public String getEtternavn()
    {
        return etternavn;
    }
    //Set-metode for eiers etternavn. Benyttes ikke i dette programmet.
    public void setEtternavn(String etternavn)
    {
        this.etternavn = etternavn;
    }
    //Get-metode for eiers adresse. Benyttes ikke i dette programmet.
    public String getAdresse()
    {
        return adresse;
    }
    //Set-metode for eiers adresse. Benyttes ikke i dette programmet.
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public int getMedlemsnummer()
    {
        return medlemsnummer;
    }
    
    public void setNesteNr( int n )
    {
        nestenr = n;
    }

    public Båtliste getBåtliste() {
        return båtliste;
    }

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
        if( båtliste != null) //Hvis båteier har båt registrert
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
