/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokprog2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Odd
 */
public class Bokvindu extends JFrame 
{
    
    private final JTextArea utskrift;
    private final JButton settinnfb, settinnsb, settinnnorrom, settinnur, 
                             visbok, velgfil;
    private final JTextField inputf, inputt, inputs, inputp, inputfg, inputsf, 
                             inputkl, inputsj, inputmål, inputspråk;
    private final Lytter lytter;
    private final BokRegister register;
    private String filsti;
   
    public Bokvindu( BokRegister reg ) 
    {
        
        super( "Bok Vindu" );
        lytter = new Lytter();
        inputf =  new JTextField( 30 );
        inputt = new JTextField( 30 );
        inputs = new JTextField(6);
        inputp = new JTextField(5);
        inputfg = new JTextField(15);
        inputsf = new JTextField(30);
        inputkl = new JTextField(15);
        inputsj = new JTextField(15);
        inputmål = new JTextField(5);
        inputspråk = new JTextField(10);
        settinnfb = new JButton("Sett inn Fagbok");
        settinnsb = new JButton("Sett inn Skolebok");
        settinnnorrom = new JButton("Sett inn Norsk Roman");
        settinnur = new JButton("Sett inn Utenlandsk Roman");
        visbok = new JButton("Vis Bok");
        velgfil = new JButton("Velg Fil");
        utskrift =  new JTextArea( 100, 100 );
        utskrift.setEditable( false );
        register = reg;
        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        
        //legger til vinduets elementer til selve vinduet
        c.add( new JLabel( "Forfatter: ") );
        c.add( inputf );   
        c.add( new JLabel( " Tittel: "));
        c.add( inputt );
        c.add( new JLabel( "Sider: "));
        c.add( inputs );
        c.add( new JLabel( "Pris: " ));
        c.add( inputp );
        c.add( new JLabel( " Fagområde: "));
        c.add( inputfg );
        c.add( new JLabel( "Skolefag: "));
        c.add( inputsf );
        c.add( new JLabel( "Klassetrinn: "));
        c.add( inputkl );
        c.add( new JLabel( "Sjanger: "));
        c.add( inputsj );
        c.add( new JLabel( " Mål: "));
        c.add( inputmål );
        c.add( new JLabel( "Språk: "));
        c.add( inputspråk );
        c.add(settinnfb);
        c.add(settinnsb);
        c.add(settinnnorrom);
        c.add(settinnur);
        c.add(visbok);
        c.add(velgfil);
        c.add( utskrift );
        
        
        settinnfb.addActionListener(lytter);
        settinnsb.addActionListener(lytter);
        settinnnorrom.addActionListener(lytter);
        settinnur.addActionListener(lytter);
        visbok.addActionListener(lytter);
        velgfil.addActionListener(lytter);
        
    }
    
    public void nyFagbok()
    {
        try( DataOutputStream output = new DataOutputStream( 
                        new FileOutputStream( filsti, true )) )
        {
            String forfatter = inputf.getText();
            String tittel = inputt.getText();
            int sider = Integer.parseInt(inputs.getText());
            double pris = Double.parseDouble(inputp.getText());
            String fag = inputfg.getText();
            
            if( forfatter.length() == 0 || tittel.length() == 0 || fag.length() == 0 )
            {
                utskrift.setText("Du har glemt å fylle ut all nødvendig informasjon. ");
            } 
            else
            {
                Fagbok ny;
                ny = new Fagbok( forfatter, tittel, sider, pris, fag );
                register.settInn(ny);
                
                ny.skrivObjektTilFil(output);
                utskrift.append("Du har satt inn en ny fagbok \n");
                
                inputf.setText("");
                inputt.setText("");
                inputs.setText("");
                inputp.setText("");
                inputfg.setText("");
                
            }
            output.close();
        }
        catch( NumberFormatException nfe )
        {
            utskrift.setText("Feil tallformat for antall sider eller pris. "); 
        }
        catch( FileNotFoundException fnfe )
        {
            utskrift.setText("Feil ved lasting av fil. ");
        }
        catch( IOException ioe )
        {
            utskrift.setText("En feil har oppstått under lesing av fil. ");
        }
    }
    
    public void nySkolebok() 
    {
        try( DataOutputStream output = new DataOutputStream( 
                        new FileOutputStream( filsti, true )) )
        {
            String forfatter = inputf.getText();
            String tittel = inputt.getText();
            int sider = Integer.parseInt(inputs.getText());
            double pris = Double.parseDouble(inputp.getText());
            int trinn = Integer.parseInt(inputkl.getText());
            String skolefag = inputsf.getText();
            
            if( forfatter.length() == 0 || tittel.length() == 0 ) 
            {
                utskrift.setText("Du har glemt å fylle ut all nødvendig informasjon. ");
            }
            else
            {
                Skolebok ny;
                ny = new Skolebok( forfatter, tittel, sider, pris, trinn, skolefag );
                register.settInn(ny);
                
                ny.skrivObjektTilFil( output );
                utskrift.append("Du har satt inn en ny skolebok \n");
                
                inputf.setText("");
                inputt.setText("");
                inputs.setText("");
                inputkl.setText("");
                inputsf.setText("");               
 
            }
            output.close();     
        }
        catch( NumberFormatException nfe )
        {
            utskrift.setText("Feil tallformat for antall sider eller pris. "); 
        }
        catch( FileNotFoundException fnfe )
        {
            utskrift.setText("Feil ved lasting av fil. ");
        }
        catch( IOException ioe )
        {
            utskrift.setText("En feil har oppstått under lesing av fil. ");
        }
    }
    
    public void nyNorRoman()
    {
        try( DataOutputStream output = new DataOutputStream( 
                        new FileOutputStream( filsti, true )) )
        {
            String forfatter = inputf.getText();
            String tittel = inputt.getText();
            int sider = Integer.parseInt(inputs.getText());
            double pris = Double.parseDouble(inputp.getText());
            String sjanger = inputsj.getText();
            String mål = inputmål.getText();
            
            if( forfatter.length() == 0 || tittel.length() == 0 ) 
            {
                utskrift.setText("Du har glemt å fylle ut all nødvendig informasjon. ");
            }
            else
            {
                NorskRoman ny; 
                ny = new NorskRoman( forfatter, tittel, sider, pris, sjanger, mål );
                register.settInn(ny);
                                
                ny.skrivObjektTilFil( output );
                utskrift.append("Du har satt inn en ny norsk roman \n");
                
                inputf.setText("");
                inputt.setText("");
                inputs.setText("");
                inputp.setText("");
                inputsj.setText("");
                inputmål.setText("");
            }
            
            output.close();       
        }
        catch( NumberFormatException nfe )
        {
            utskrift.setText("Feil tallformat for antall sider eller pris. "); 
        }
        catch( FileNotFoundException fnfe )
        {
            utskrift.setText("Feil ved lasting av fil. ");
        }
        catch( IOException ioe )
        {
            utskrift.setText("En feil har oppstått under lesing av fil. ");
        }
    }
    
    public void nyUtenlandskRoman()
    {
        try( DataOutputStream output = new DataOutputStream( 
                        new FileOutputStream( filsti )))
        {
            String forfatter = inputf.getText();
            String tittel = inputt.getText();
            int sider = Integer.parseInt(inputs.getText());
            double pris = Double.parseDouble(inputp.getText());
            String sjanger = inputsj.getText();
            String språk = inputspråk.getText();
            
            if( forfatter.length() == 0 || tittel.length() == 0 ) 
            {
                utskrift.setText("Du har glemt å fylle ut all nødvendig informasjon. ");
            }
            else
            {
                UtenlandskRoman ny;
                ny = new UtenlandskRoman( forfatter, tittel, sider, pris, sjanger, språk );
                register.settInn(ny);
                
                ny.skrivObjektTilFil( output );                
                utskrift.append("Du har satt inn en ny utenlansk roman. \n");
                 
                inputf.setText("");
                inputt.setText("");
                inputs.setText("");
                inputp.setText("");
                inputsj.setText("");  
                inputspråk.setText("");
            }
            output.close();
        }
         catch( NumberFormatException nfe )
        {
            utskrift.setText("Feil tallformat for antall sider eller pris. "); 
        }
        catch( FileNotFoundException fnfe )
        {
            utskrift.setText("Feil ved lasting av fil. ");
        }
        catch( IOException ioe )
        {
            utskrift.setText("En feil har oppstått under lesing av fil. ");
        }
    }
    
    /**
     * Metoden skriver ut Bok objektenes toString metode i utskrifts feltet.
     */
    
    public void visBok()
    {
        register.skrivListe(utskrift);
    }
    
    /**
     * Metoden avgjør hvilken fil programmet skal skrive/laste data fra. 
     * Deretter lastes data fra valgt fil programmet.
     * 
     */
    
    public void velgFil()
    {
        boolean ok;       
        
        JFileChooser fil = new JFileChooser();
        fil.setCurrentDirectory( new File (".") );
        int svar =  fil.showOpenDialog( this );
        
        if( svar == JFileChooser.APPROVE_OPTION )
        {
            try( DataInputStream input = new DataInputStream(                    //legge inn buffer stream
                    new FileInputStream(
                            filsti = fil.getSelectedFile().getAbsolutePath() )))
            {
                while(true)
                {
                    switch (input.readUTF() ) 
                    {
                        case "Fagbok":
                            {
                                Fagbok ny = new Fagbok();
                                register.settInnBakerst(ny);
                                ok = ny.lesObjektFraFil(input);
                                if( !ok )
                                    throw new IOException();                    
                                break;
                            }
                        case "Skolebok":
                            {
                                Skolebok ny = new Skolebok();
                                register.settInnBakerst(ny);
                                ok = ny.lesObjektFraFil(input);
                                if( !ok )
                                    throw new IOException();
                                break;
                            }
                        case "NorskRoman":
                            {
                                NorskRoman ny = new NorskRoman();
                                ok = ny.lesObjektFraFil(input);
                                register.settInnBakerst(ny);
                                if(!ok)
                                    throw new IOException();
                                break;
                            }
                        case "UtenlandskRoman":
                            {
                                UtenlandskRoman ny = new UtenlandskRoman();
                                register.settInnBakerst(ny);
                                ok = ny.lesObjektFraFil(input);
                                if(!ok)
                                    throw new IOException();
                                break;
                            }
                    }
                }
            }
            catch( EOFException eofe )
            {
                utskrift.append("Filen er Lastet. \n");
            }
            catch( FileNotFoundException ioe )
            {
                JOptionPane.showMessageDialog( this, 
                        "Det er oppstått en feil ved lesing av fil.", 
                        "Feilmelding", JOptionPane.ERROR_MESSAGE);
            }
            catch( IOException ioe )
            {
                JOptionPane.showMessageDialog( this, 
                        "Det er oppstått en feil ved lesing av fil.", 
                        "Feilmelding", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }
    
    // lytteklasse
    private class Lytter implements ActionListener 
    {
        @Override
        public void actionPerformed( ActionEvent e ) 
        {
            if( e.getSource() == settinnfb ) 
            {
                nyFagbok();
            }
            
            else if( e.getSource() == settinnsb ) 
            {
                nySkolebok();
            }
            
            else if( e.getSource() == settinnnorrom )
            {
                nyNorRoman();
            }
            
            else if( e.getSource() == settinnur )
            {
                nyUtenlandskRoman();
            }
            
            else if( e.getSource() == visbok ) 
            {
                visBok();
            }
            
            else if( e.getSource() == velgfil )
            {
                velgFil();
            }
            
        }     
    } 
}
