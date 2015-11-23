/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ruchitha
 */
public class MainPanel extends JPanel {
    
    private DetailPanel detailPanel;
    
    private ButtonPanel buttonPanel;

    private InputPanel inputPanel;
    
    private FullDetailPanel fullDetailPanel;
            
    public MainPanel() {
    
        inputPanel = new InputPanel();
        buttonPanel = new ButtonPanel();
        detailPanel = new  DetailPanel();
        fullDetailPanel = new FullDetailPanel();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
     
        add(inputPanel);
        add(buttonPanel);
        add(detailPanel);
        add(fullDetailPanel);
        

    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public InputPanel getInputPanel() {
        return inputPanel;
    }

    public void setInputPanel(InputPanel inputPanel) {
        this.inputPanel = inputPanel;
    }

   
    public DetailPanel getDetailPanel() {
        return detailPanel;
    }

    public void setDetailPanel(DetailPanel detailPanel) {
        this.detailPanel = detailPanel;
    }

    public FullDetailPanel getFullDetailPanel() {
        return fullDetailPanel;
    }

    public void setFullDetailPanel(FullDetailPanel fullDetailPanel) {
        this.fullDetailPanel = fullDetailPanel;
    }
    
    
    
}

