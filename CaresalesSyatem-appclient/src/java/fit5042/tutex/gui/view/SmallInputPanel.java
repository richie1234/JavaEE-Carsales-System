/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ruchitha
 */
public class SmallInputPanel extends JPanel {
    
    
    private JLabel carLabel;
    private JTextField cartxTfield;

    public SmallInputPanel() {
        
        carLabel = new JLabel();        
        cartxTfield = new JTextField(30);
        
        GridBagConstraints c = new GridBagConstraints();
        
        //setLayout(new GridBagLayout());
        
          // setLayout(new FlowLayout());
        
        setLayout(new BorderLayout());
        add(carLabel, BorderLayout.WEST);
        add(cartxTfield,BorderLayout.EAST);
        
//        setLayout(new SpringLayout());
         
        
        add(carLabel);
        //dd(cartxTfield);
               
    }

    public JLabel getCarLabel() {
        return carLabel;
    }

    public void setCarLabel(JLabel carLabel) {
        this.carLabel = carLabel;
    }

    public JTextField getCartxTfield() {
        return cartxTfield;
    }

    public void setCartxTfield(JTextField cartxTfield) {
        this.cartxTfield = cartxTfield;
    }


   
    
}
