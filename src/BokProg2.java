/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bokprog2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Odd
 */
public class BokProg2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        BokRegister register = new BokRegister();
        Bokvindu vindu = new Bokvindu( register );
        
        vindu.setSize(1980,1030);
        vindu.setVisible( true );
        vindu.addWindowListener( new WindowAdapter() {
            
            @Override
            public void windowClosing( WindowEvent e )
            {
                System.exit(0);
            }
        });
        
    }
    
}
