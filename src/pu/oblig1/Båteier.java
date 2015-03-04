/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

/**
 *
 * @author Thomas
 */
public class Båteier 
{
    private String fornavn;
    private String etternavn;
    private String adresse;
    private int medlemsnummer;
    private static int nestenr = 1;
    Båteier neste;
    private Båt båt;

    
    // Kobling til båt i denne klassen, hentes fra filObjekt?
    
    public Båteier(String fornavn, String etternavn, String adresse, int medlemsnummer)
    {
        setFornavn(fornavn);
        setEtternavn(etternavn);
        setAdresse(adresse);
        setMedlemsnummer(nestenr++); 
        båt = null;
    }
    
    public Båteier(String fornavn, String etternavn, String adresse, int medlemsnummer, Båt b)
    {
        setFornavn(fornavn);
        setEtternavn(etternavn);
        setAdresse(adresse);
        setMedlemsnummer(nestenr++); 
        båt=b;
    }

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
    
    @Override
    public String toString()
    {
        
    }
}
