/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ruchitha
 */
public class CarSalesGUI extends JFrame{
    
    
//    InputPanel inputPanel = new InputPanel();
    MainPanel mainPanel = new MainPanel();
    

    public CarSalesGUI() throws HeadlessException {
    
        JPanel pnlOuter = new JPanel(new BorderLayout());
        pnlOuter.add(mainPanel);
        Container cn=getContentPane();
        cn.add(pnlOuter);
        
        setTitle("CarSalesGUI");
        //setSize(300, 200);
        setBounds(250, 50, 550, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    
    }

    public CarSalesGUI(String title) throws HeadlessException {
        super(title);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    
    
}
