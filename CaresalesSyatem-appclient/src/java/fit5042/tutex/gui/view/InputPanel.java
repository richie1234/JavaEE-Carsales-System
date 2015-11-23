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
public class InputPanel extends JPanel {

    private SmallInputPanel smallInputPanelId;
    private SmallInputPanel smallInputPanelManufacturer;
    private SmallInputPanel smallInputPanelType;
    private SmallInputPanel smallInputPanelModel;



    public InputPanel() {
        
        smallInputPanelId = new SmallInputPanel();
        smallInputPanelId.getCarLabel().setText("Car Model No:");

        smallInputPanelManufacturer= new SmallInputPanel();
        smallInputPanelManufacturer.getCarLabel().setText("Manufacturer:");

        smallInputPanelType = new SmallInputPanel();
        smallInputPanelType.getCarLabel().setText("Car Type:");

        smallInputPanelModel = new SmallInputPanel();
        smallInputPanelModel.getCarLabel().setText("Car Model:");

        
 
        

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(smallInputPanelId);
        add(smallInputPanelManufacturer);
        add(smallInputPanelType);
        add(smallInputPanelModel);
       


    }

    public SmallInputPanel getSmallInputPanelId() {
        return smallInputPanelId;
    }

    public void setSmallInputPanelId(SmallInputPanel smallInputPanelId) {
        this.smallInputPanelId = smallInputPanelId;
    }

    public SmallInputPanel getSmallInputPanelManufacturer() {
        return smallInputPanelManufacturer;
    }

    public void setSmallInputPanelManufacturer(SmallInputPanel smallInputPanelManufacturer) {
        this.smallInputPanelManufacturer = smallInputPanelManufacturer;
    }

    public SmallInputPanel getSmallInputPanelType() {
        return smallInputPanelType;
    }

    public void setSmallInputPanelType(SmallInputPanel smallInputPanelType) {
        this.smallInputPanelType = smallInputPanelType;
    }

    public SmallInputPanel getSmallInputPanelModel() {
        return smallInputPanelModel;
    }

    public void setSmallInputPanelModel(SmallInputPanel smallInputPanelModel) {
        this.smallInputPanelModel = smallInputPanelModel;
    }

    



   
    
}
