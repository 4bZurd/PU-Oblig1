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

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author Odd
 */

public class BåtVindu extends JFrame
{
    private final JTextArea utskrift;
    private final JButton nyeier;
    private final JButton nyeiernyBåt;
    private final JButton fjerneier;
    private final JButton skrivut;
    private final JButton skifteier;
    private final JButton skrivliste;
    private final JButton velgfil;
    private final JButton finneier;
    private final JButton regbåt;
    private final JButton slettbåt;
    
    private final JTextField merke;
    private final JTextField type;
    private final JTextField regnr;
    private final JTextField årsmod;
    private final JTextField lengde;
    private final JTextField hk;
    private final JTextField skrogfarge;
    private final JTextField fornavn;
    private final JTextField etternavn;
    private final JTextField adresse;
    private final JTextField medlemsnummer1;
    private final JTextField medlemsnummer2;
    
    private String filsti;
    private EierRegister register;
    private final Lytter lytter;

    
    /**
     * Vinduets konstruktør som oppretter vinduets knapper og tekstfelt.
     * 
     * @param reg tar i mot EierRegister som parameter.
     */

    public BåtVindu( EierRegister reg )
    {
        super("Båt vindu");
        lytter = new Lytter();
        register = reg;
        
        //Oppretter vindues knapper
        nyeier = new JButton("Ny Eier");
        nyeiernyBåt = new JButton("Ny Eier/Båt");
        fjerneier = new JButton("Fjern Eier");
        skrivut = new JButton("Finn Person");
        skifteier = new JButton("Skift Eier");
        skrivliste = new JButton("Skriv ut Liste");
        velgfil = new JButton("Velg Fil");
        finneier = new JButton("Finn Eier til båt");
        regbåt = new JButton("Reg Båt");
        slettbåt = new JButton("Slett båt");
        
        
        //Opretter tekstfielt for registrering av Båt/eier     
        merke = new JTextField( 15 );
        type = new JTextField( 10 );
        regnr = new JTextField( 8 );
        årsmod = new JTextField( 4 );
        lengde = new JTextField( 3 );
        hk = new JTextField( 4 );
        skrogfarge = new JTextField( 15 );
        fornavn =  new JTextField( 15 );
        etternavn = new JTextField( 15 );
        adresse = new JTextField( 20 );
        medlemsnummer1 = new JTextField( 5 );
        medlemsnummer2 = new JTextField( 5 );
        
        
        // utskriftsområdets egenskaper
        utskrift = new JTextArea( 50, 100 );
        utskrift.setEditable( false );
        JScrollPane scroll = new JScrollPane( utskrift );
        utskrift.setText("-Skriv inn regnr på båten du ønsker å omregristree og "
                + "medlemsnummer for ny eier."
                + "\n-Søk i register går på medlemsnummer.");
        
        
        // legger elementene i vinduet fra venstre mot høyre.
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        
        c.add( nyeier );
        c.add( nyeiernyBåt );
        c.add( fjerneier );
        c.add( skrivut );
        c.add( skifteier );
        c.add( skrivliste );
        c.add( velgfil );
        c.add( finneier );
        c.add( regbåt );  
        c.add( slettbåt );
        c.add( new JLabel("Fornavn: ") );
        c.add( fornavn );
        c.add( new JLabel("Etternavn: "));
        c.add( etternavn );
        c.add( new JLabel("Adresse: "));
        c.add( adresse );
        c.add( new JLabel("Medlemmsnummer1: "));
        c.add( medlemsnummer1 );
        //c.add( new JLabel("Medlemmsnummer2: "));
        //c.add( medlemsnummer2 );
        c.add( new JLabel("Merke: "));
        c.add( merke );
        c.add( new JLabel("Type: "));
        c.add( type );
        c.add( new JLabel("Regnr: "));
        c.add( regnr );
        c.add( new JLabel("Årsmod: "));
        c.add( årsmod );
        c.add( new JLabel("Lengde: "));
        c.add( lengde );
        c.add( new JLabel("HK: "));
        c.add( hk );
        c.add( new JLabel("Skrogfarge: "));
        c.add( skrogfarge );
        c.add( scroll );

        
        //knytter ActionListener til knappene 
        nyeier.addActionListener( this.lytter );
        nyeiernyBåt.addActionListener( this.lytter );
        fjerneier.addActionListener( this.lytter );
        skrivut.addActionListener( this.lytter );
        skifteier.addActionListener( this.lytter );
        skrivliste.addActionListener( this.lytter );
        velgfil.addActionListener( this.lytter );
        finneier.addActionListener( this.lytter );
        regbåt.addActionListener( this.lytter );
        slettbåt.addActionListener(this.lytter);
    }
    
    /**
     * skjekker om båt med gitt regnr eksisterer i registeret.
     * @param reg tar i mot regnr i parameter
     * @return true hvis regnr ikke ekisterer.
     */
    
    public boolean sjekkRegnr(String reg)
    {
        return register.finnBåtEier(reg) == null;
    }
    
    /**
     * oppretter en ny eier i EierRegister.
     */
 
    public void nyEier()
    {
        String fnavn = fornavn.getText();
        String enavn = etternavn.getText();
        String adr = adresse.getText();
        
        if( fnavn.length() == 0 || enavn.length() == 0 || adr.length() == 0 )
        {
            utskrift.append("Du har glemt å fylle ut alle nødvendige felt. \n");
        } else {
            
            Båteier ny = new Båteier(fnavn, enavn, adr );                   
            register.settInn( ny );
            utskrift.append("Du har registrert en ny eier: \n" + ny.toString());
            slettFelt();    
        }
    }
    
    /**
     * Oppretter ny eier i registeret og tilhørende båt.
     */
    
    

    public void nyEierNyBåt()
    {
        try
        {
            String fnavn = fornavn.getText();
            String enavn = etternavn.getText();
            String adr = adresse.getText();
            String m = merke.getText();
            String typ = type.getText();
            String reg = regnr.getText();
            int år = Integer.parseInt( årsmod.getText() );
            int leng = Integer.parseInt( lengde.getText());
            int hest = Integer.parseInt( hk.getText());
            String sfarge = skrogfarge.getText();
            
            if (sjekkRegnr(reg) )
            {
                Båteier ny = new Båteier( fnavn, enavn, adr );
                Båt båt = new Båt(reg, leng, hest, m, typ, sfarge, år);
                ny.getBåtliste().settInn( båt );
                register.settInn( ny );
                utskrift.append("Du har registrert: \n"
                                 + ny.toString() );
                slettFelt();
            }
            else
                utskrift.append("Registreringsnummeret er i bruk av en annen båt."
                      + " Vennligst skriv inn et annet registreringsnummer.");  
            
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Feil format for tall, se om du har tastet riktig. \n");
        }
    } 
    
    /**
     * Kaller register sin finnEier og sltter eieren ved hjelp
     * av register sin slettBåteier hvis eier ikke eier en Båt. 
     * 
     */
    
    public void registrerBåt()
    {
        try
        {
            String m = merke.getText();
            String typ = type.getText();
            String reg = regnr.getText();
            int år = Integer.parseInt( årsmod.getText() );
            int leng = Integer.parseInt( lengde.getText());
            int hest = Integer.parseInt( hk.getText());
            String sfarge = skrogfarge.getText();
            int medlemsnr = Integer.parseInt( medlemsnummer1.getText() );
            
            if( sjekkRegnr(reg) )
            {
                Båteier båteier = register.finnEier( medlemsnr );
                Båt ny = new Båt( reg, leng, hest, m , typ, sfarge, år );
                båteier.getBåtliste().settInn( ny );
                utskrift.append( båteier.toString() );
                slettFelt();
            }
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Feil format for tall, se om du har tastet riktig. \n");
        }
    }
    
    /**
     * metode for å slette eier, dette er bare mulig hvis eieren ikke har noen båt.
     */
    
    public void slettEier()
    {
        try
        {
            int medlemsnr = Integer.parseInt( medlemsnummer1.getText() );
            if( register.slettBåteier( medlemsnr ))
            {
                utskrift.append("Du har fjernet eieren \n");
                slettFelt();
            }     
            else
                utskrift.setText("Eieren har en eller flere båter, fjern disse først.");
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Du har skrevet inn en feil. \n");
        }
    }
     
    /**
     * skriver ut info for en gitt Båteier.
     */
    
    public void finnEier()
    {
        try
        {
            int medlemsnr = Integer.parseInt( medlemsnummer1.getText() ); 
            Båteier eier = register.finnEier( medlemsnr  );
            utskrift.append( eier.toString() );
            slettFelt();
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Feil format: medlemsnummer. \n");
        }
    }
    
    /**
     * Metoden skriver ut informasjon om en eier og eierens båter
     * ved hjelp av medlemsnummer.
     */
    
    public void finnBåteier()
    {
        try
        {
            Båteier eier = register.finnBåtEier( regnr.getText() );
            utskrift.append( eier.toString() );
            slettFelt();
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Regnummer må være ett tall. \n");
        }
    }
    
    /**
     * Metoden henter båt-objektet tilhørende forrige eier og setter inn 
     * til den nye eieren ved hjelp av medlemsnummer.
     */
    
    public void skiftEier()
    {
        try
        {
            String reg = regnr.getText();
            int tall = Integer.parseInt(medlemsnummer1.getText());
            Båteier forrige = register.finnBåtEier( reg );
            Båteier ny = register.finnEier( tall );
            ny.getBåtliste().settInn(forrige.getBåtliste().finnBåt(reg));
            forrige.getBåtliste().slettBåt(reg);
            
            /**
            if( ny.getBåt() == null )
            {
                ny.setBåt( forrige.getBåt() );
                forrige.setBåt(null);
                utskrift.append("Båt med registeringsnummer " + reg + 
                    "\n er nå registert på " + ny.toString() );
            }
            else
            {
                utskrift.setText("Den nye eieren har allerede en båt. ");
            }
            */
            /**
            int medlemsnr1 = Integer.parseInt( medlemsnummer1.getText() );
            int medlemsnr2 = Integer.parseInt( medlemsnummer2.getText() );
            String Båtreg = regnr.getText() ;
            Båteier eier1 = register.finnEier( medlemsnr1 );
            Båteier eier2 = register.finnEier( medlemsnr2 );
            Båt Båt1 = eier1.getBåt();
            eier1.setBåt(null);
            eier2.setBåt(Båt1);
            utskrift.append("Båt med registeringsnummer " + Båtreg + 
                    "\n er nå registert på " + eier2.toString() );
            slettFelt(); 
            */
        }
        catch( NumberFormatException e)
        {
            utskrift.append("Feil tallformat. \n");
        }
        catch( NullPointerException npe )
        {
            utskrift.setText("Båten eller eieren du ønsket å omregristrere "
                    + "er ikke i registeret. ");
        }
    }
    
    /**
     * metoden fjerner båt fra båtlisten til en eier.
     */
    
    public void fjernBåt()
    {
        String reg = regnr.getText();
        Båteier eier = register.finnBåtEier( reg );
        if( eier.getBåtliste().slettBåt(reg) )
            utskrift.setText("Båten er fjernet fra \n" + eier.toString() );
        else
            utskrift.setText("Noe gikk galt.");
    }
    
    /**
     * skriver ut hele register lista med all info om eier og Båt.
     */
    
    public void skrivListe()
    {
        register.skrivListe(utskrift);
    }
    
    /**
     *  alle input felt i vinduet
     */
    
    public void slettFelt()
    {
        merke.setText("");
        type.setText("");
        regnr.setText("");
        årsmod.setText("");
        lengde.setText("");
        hk.setText("");
        skrogfarge.setText("");
        fornavn.setText("");
        etternavn.setText("");
        adresse.setText("");
        medlemsnummer1.setText("");
        medlemsnummer2.setText("");      
    }
    
    /**
     * metoden som leser fra fil.
     */

    public void lesFraFil()
    {
        JFileChooser fil = new JFileChooser();
        fil.setCurrentDirectory( new File (".") );
        int svar =  fil.showOpenDialog( this );

        filsti = fil.getSelectedFile().getAbsolutePath();
        try( ObjectInputStream input = new ObjectInputStream( 
                new FileInputStream( filsti )) )
        {
            register = (EierRegister) input.readObject();
            register.første.setNesteNr( input.readInt() );
        }
        catch( ClassNotFoundException e )
        {
            // passende feilhåndtering
        }
        catch( FileNotFoundException e )
        {
            utskrift.append("Filen er ikke funnet. \n");
        }
        catch( EOFException  e )
        {
            utskrift.append("Filen er lastet. \n");
        }
        catch( IOException e )
        {
            utskrift.append("Feil under lesing av fil. \n");
        }
    }
    
    /**
     * Skriver register objektet til fil samt alle addresser og objekter 
     * som hører til register. Deretter lagrer den medlemmsnummerets hjelpevariabel
     * til fil. 
     */
    
    public void skrivTilFil() throws NullPointerException 
    {

        try( ObjectOutputStream output = new ObjectOutputStream( 
                    new FileOutputStream( filsti )) )
        {
            output.writeObject( register );
            output.writeInt( register.første.getNesteNr() );
            output.close();

        }
        catch( FileNotFoundException e )
        {
            utskrift.append("Feil ved skriving til fil. \n");
        }
        catch( IOException e )
        {
            utskrift.append("Feil ved skriving til fil. \n");
    
        }

    }

    private class Lytter implements ActionListener
    {
        @Override
        public void actionPerformed( ActionEvent e )
        {
            if( e.getSource() == nyeier ) 
            {
                nyEier();
            }
            else if( e.getSource() == nyeiernyBåt )
            {
                nyEierNyBåt();
            }
            else if( e.getSource() == fjerneier )
            {
                slettEier();
            }
            else if( e.getSource() == skrivut )
            {
                finnEier();
            }
            else if( e.getSource() == skifteier )
            {
                skiftEier();
            }
            else if( e.getSource() == skrivliste )
            {
                skrivListe();
            }
            else if( e.getSource() == velgfil )
            {
                lesFraFil();
            }
            else if( e.getSource() == finneier)
            {
                finnBåteier();
            }
            else if( e.getSource() == regbåt )
            {
                registrerBåt();
            }
            else if( e.getSource() == slettbåt)
            {
                fjernBåt();
            }
        }
    }
}
