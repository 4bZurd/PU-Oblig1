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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 *
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
    
    private final JTextField merke;
    private final JTextField type;
    private final JTextField regnr;
    private final JTextField årsmod;
    private final JTextField lengde;
    private final JTextField hk;
    private final JTextField skrogfarge;
    
    private String filsti;
    private final Båtregister register;
    private final Lytter lytter;

    
    /**
     * Vinduets konstruktør som oppretter vinduets knapper og textfelt;
     * 
     */

    public BåtVindu( Båtregister reg )
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
        
        //Opretter tekstfielt        
        merke = new JTextField(15);
        type = new JTextField(10);
        regnr = new JTextField(8);
        årsmod = new JTextField(4);
        lengde = new JTextField(3);
        hk = new JTextField(4);
        skrogfarge = new JTextField(15);
        
        // utskriftsområdets egenskaper
        utskrift = new JTextArea( 100, 100 );
        utskrift.setEditable( false );
        
        
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
        
        c.add( new JLabel("Merke: ") );
        c.add( merke );
        c.add( new JLabel("Type: ") );
        c.add( type );
        c.add( new JLabel("Regnr: "));
        c.add( regnr );
        c.add( new JLabel("Årsmod: ") );
        c.add( årsmod );
        c.add( new JLabel("Lengde: "));
        c.add( lengde );
        c.add( new JLabel("HK: ") );
        c.add( hk );
        c.add( new JLabel("Skrogfarge: ") );
        c.add( skrogfarge );
        c.add( utskrift );
        
        nyeier.addActionListener( lytter );
        nyeiernybåt.addActionListener( lytter );
        fjerneier.addActionListener( lytter );
        skrivut.addActionListener( lytter );
        skifteier.addActionListener( lytter );
        skrivliste.addActionListener( lytter );
        velgfil.addActionListener( lytter );
    }
    
    public void nyEier()
    {
        
    }
    
    public void nyEierNyBåt()
    {
        
    }
    
    public void fjernEier()
    {
        
    }
    
    public void skrivUt()
    {
        
    }
    
    public void skiftEier()
    {
        
    }
    
    public void skrivListe()
    {
        
    }
    
    public void velgFil()
    {
        
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
                fjernEier();
            }
            else if( e.getSource() == skrivut )
            {
                skrivUt();
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
        }
    }
}
