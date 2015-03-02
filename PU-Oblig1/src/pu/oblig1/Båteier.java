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
    /*private int båtobjekt;*/
    
    // Kobling til båt i denne klassen, hentes fra filObjekt?

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

    // Konstruktør, initialiserer variablene 
    // Bør konstruktøren koble en båt til en eier automatisk?
    
    public Båteier(String fornavn, String etternavn, String adresse, int medlemsnummer/*, int båtobjekt */)
    {
        if (/*ObjectInputStream er ferdig*/) //Benyttes dersom det hentes informasjon via OIS for å objektet Båteier.
        {
            setFornavn(fornavn);
            setEtternavn(etternavn);
            setAdresse(adresse);
            setMedlemsnummer(medlemsnummer);
            /* setBåtObjekt(båtobjekt); */
        }
        else // Benyttes dersom det er helt ny (ikke eksisterende) Båteier objekt som opprettes.
        {
            setFornavn(fornavn);
            setEtternavn(etternavn);
            setAdresse(adresse);
            setMedlemsnummer(ois.readObject(/*siste båteier objekt i array*/)+1);
            /* setBåtObjekt(båtobjekt); */
        }
        
    }

}
