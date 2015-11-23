/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;


import fit5042.tutex.gui.view.controller.CloseActionListener;
import fit5042.tutex.gui.view.controller.SearchActionListener;
import fit5042.tutex.gui.view.controller.ViewActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Ruchitha
 */
public class ButtonPanel extends JPanel {

   
    private JButton jButtonSearch;
    private JButton jButtonView;
    private JButton jButtonClose;

    public ButtonPanel() {

        
        jButtonSearch = new JButton("Search");
        jButtonView = new JButton("View All");
        jButtonClose = new JButton("Close");

        this.setLayout(new FlowLayout(1, 30, 20));

       
        add(jButtonSearch);
        add(jButtonView);
        add(jButtonClose);


        jButtonSearch.addActionListener(new SearchActionListener());
        jButtonView.addActionListener(new ViewActionListener());
        jButtonClose.addActionListener(new CloseActionListener());

    }

}
