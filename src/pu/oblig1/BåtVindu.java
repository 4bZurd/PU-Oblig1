/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private final JButton nyeiernybåt;
    private final JButton fjerneier;
    private final JButton skrivut;
    private final JButton skifteier;
    private final JButton skrivliste;
    private final JButton velgfil;
    private final JButton finneier;
    
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
        nyeiernybåt = new JButton("Ny Eier/Båt");
        fjerneier = new JButton("Fjern Eier");
        skrivut = new JButton("Finn");
        skifteier = new JButton("Skift Eier");
        skrivliste = new JButton("Skriv ut Liste");
        velgfil = new JButton("Velg Fil");
        finneier = new JButton("Finn Eier");
        
        
        //Opretter tekstfielt for registrering av båt/eier     
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
        
        
        // legger elementene i vinduet fra venstre mot høyre.
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        
        c.add( nyeier );
        c.add( nyeiernybåt );
        c.add( fjerneier );
        c.add( skrivut );
        c.add( skifteier );
        c.add( skrivliste );
        c.add( velgfil );
        c.add( finneier );
        c.add( new JLabel("Fornavn: ") );
        c.add( fornavn );
        c.add( new JLabel("Etternavn: "));
        c.add( etternavn );
        c.add( new JLabel("Adresse: "));
        c.add( adresse );
        c.add( new JLabel("Medlemmsnummer1: "));
        c.add( medlemsnummer1 );
        c.add( new JLabel("Medlemmsnummer2: "));
        c.add( medlemsnummer2 );
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
        nyeiernybåt.addActionListener( this.lytter );
        fjerneier.addActionListener( this.lytter );
        skrivut.addActionListener( this.lytter );
        skifteier.addActionListener( this.lytter );
        skrivliste.addActionListener( this.lytter );
        velgfil.addActionListener( this.lytter );
        finneier.addActionListener( this.lytter );
    }
 
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
        
            Båt nybåt = new Båt( reg, leng, hest, m , typ, sfarge, år );
            Båteier ny = new Båteier( fnavn, enavn, adr, nybåt );
            register.settInn( ny );
            utskrift.append("Du har registrert: \n"
                             + ny.toString() );
            slettFelt();
            
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Feil format for tall, se om du har tastet riktig. \n");
        }
    } 
    
    /**
     * Kaller register sin finnEier og sltter eieren ved hjelp
     * av register sin slettBåteier hvis eier ikke eier en båt. 
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
        
            Båteier båteier = register.finnEier( medlemsnr );
            Båt ny = new Båt( reg, leng, hest, m , typ, sfarge, år );
            båteier.setBåt( ny );
            utskrift.append( båteier.toString() );
            slettFelt();
        }
        catch( NumberFormatException e )
        {
            utskrift.append("Feil format for tall, se om du har tastet riktig. \n");
        }

    }
    
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
        }
        catch( NumberFormatException e )
        {
            
        }
    }
     
    /**
     * skriver ut info for en gitt båteier.
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
            utskrift.append("Feil format: medlemsnummer. ");
        }
    }
    
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
            utskrift.append("Regnummer må være ett tall. ");
        }
    }
    
    /**
     * metode for eierskifte av båt
     */
    
    public void skiftEier()
    {
        int medlemsnr1 = Integer.parseInt( medlemsnummer1.getText() );
        int medlemsnr2 = Integer.parseInt( medlemsnummer2.getText() );
        int båtreg = Integer.parseInt( regnr.getText() );
        Båteier eier1 = register.finnEier( medlemsnr1 );
        Båteier eier2 = register.finnEier( medlemsnr2 );
        Båt båt1 = eier1.getBåt();
        eier1.setBåt(null);
        eier2.setBåt(båt1);
        utskrift.append("Båt med registeringsnummer " + båtreg + 
                " er nå registert på " + eier2.toString() );
        slettFelt();
    }
    
    /**
     * skriver ut hele register lista med all info om eier og båt.
     */
    
    public void skrivListe()
    {
        register.skrivListe(utskrift);
    }
    
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

    public void velgFil()
    {
        JFileChooser fil = new JFileChooser();
        fil.setCurrentDirectory( new File (".") );
        int svar =  fil.showOpenDialog( this );
        
        if( svar == JFileChooser.APPROVE_OPTION )
        {
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
                utskrift.append("Filen er ikke funnet. ");
            }
            catch( IOException e )
            {
                // passende feilhåndtering
            }
        }
    }
    
    /**
     * Skriver register objektet til fil samt alle addresser og objekter 
     * som hører til register. Deretter lagrer den medlemmsnummerets hjelpevariabel
     * til fil. 
     */
    
    public void skrivTilFil()
    {
        try( ObjectOutputStream output = new ObjectOutputStream( 
                    new FileOutputStream( filsti )) )
        {
            output.writeObject( register );
            output.writeInt( register.første.getNesteNr() );
        }
        catch( FileNotFoundException e )
        {
            // passende feilhåndtering
        }
        catch( IOException e )
        {
            // passende feilhåndtering
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
            else if( e.getSource() == nyeiernybåt )
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
                velgFil();
            }
            else if( e.getSource() == finneier)
            {
                finnBåteier();
            }
        }
    }
}
