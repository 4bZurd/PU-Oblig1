/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pu.oblig1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Odd
 */
public class BåtProg
{
    public static void main(String[] args)
    {
        EierRegister register = new EierRegister();
        BåtVindu vindu = new BåtVindu(register);
        vindu.setSize(1024, 768);
        vindu.setVisible(true);
        vindu.velgFil();
        
        vindu.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e)
        {
            vindu.skrivTilFil();
            System.exit(0);
        }
        });
    }
    
}
