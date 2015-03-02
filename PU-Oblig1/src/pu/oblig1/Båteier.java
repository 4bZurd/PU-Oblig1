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
    String fornavn;
    String etternavn;
    String adresse;
    int medlemsnummer;

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

    public Båteier(String fornavn, String etternavn, String adresse, int medlemsnummer)
    {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.adresse = adresse;
        this.medlemsnummer = medlemsnummer;
    }
    
    
    
    
    
    
    
    
}
