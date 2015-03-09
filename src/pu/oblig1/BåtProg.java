/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Odd
 */
public class BaatProg
{
    //Programmets main-metode.
    public static void main(String[] args)
    {
        EierRegister register = new EierRegister();
        BåtVindu vindu = new BåtVindu(register);
        vindu.setSize(1024, 768);
        vindu.setVisible(true);
        try
        {
            vindu.lesFraFil();
        }
        catch( NullPointerException e)
        {
            
        }
        
        vindu.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e)
        {
            try
            {
                vindu.skrivTilFil();       
            }
            catch( NullPointerException npe )
            {
                int svar = JOptionPane.showConfirmDialog(null, "Du har ikke lagret."
                        + "\nØnsker du å forsette uten å lagre?", "Advarsel",
                        JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                if( svar ==  JOptionPane.YES_OPTION)
                    System.exit(0);   
            }
        }
        });
    }
    
}
