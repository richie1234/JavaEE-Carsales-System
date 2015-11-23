/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;

import fit5042.tutex.gui.view.controller.ListSelectionActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ruchitha
 */
public class DetailPanel extends JPanel {

    private JTable jTable1;
    private JScrollPane jScrollPane1;
    

    public DetailPanel() {

        jTable1 = new JTable();
        this.jTable1.addMouseListener(new ListSelectionActionListener());       
        
        
                jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
               "ID","Make", "Model Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
       
                
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setSize(800, 400);
        jTable1.setSize(800, 800);
        
        jScrollPane1.setViewportView(jTable1);
        

        add(jScrollPane1);
//        this.setLayout(new FlowLayout(1, 30, 20));

    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }
    
    
    

}


//            new String [] {
//                "ID", "Make", "Model", "Type", "Model Name"
//            }