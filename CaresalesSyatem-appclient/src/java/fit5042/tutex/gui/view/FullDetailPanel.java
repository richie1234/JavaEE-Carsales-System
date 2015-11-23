/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ruchitha
 */
public class FullDetailPanel extends JPanel {

    private SmallInputPanel smallInputPanelId;
    private SmallInputPanel smallInputPanelManufacturer;
    private SmallInputPanel smallInputPanelType;
    private SmallInputPanel smallInputPanelModel;
    private SmallInputPanel smallInputPanelVIN;
    private SmallInputPanel smallInputPanelThumbnail;
    private SmallInputPanel smallInputPanelDescription;
    private SmallInputPanel smallInputPanelURL;
    private JLabel labelimage;
    ImageIcon icon; 

    public FullDetailPanel() {
        
        smallInputPanelId = new SmallInputPanel();
        smallInputPanelId.getCarLabel().setText("Car Model No:");

        smallInputPanelManufacturer= new SmallInputPanel();
        smallInputPanelManufacturer.getCarLabel().setText("Manufacturer:");

        smallInputPanelType = new SmallInputPanel();
        smallInputPanelType.getCarLabel().setText("Car Type:");

        smallInputPanelModel = new SmallInputPanel();
        smallInputPanelModel.getCarLabel().setText("Car Model:");
        
        smallInputPanelVIN = new SmallInputPanel();
        smallInputPanelVIN.getCarLabel().setText("Car VIN:");
        
        smallInputPanelThumbnail = new SmallInputPanel();
        smallInputPanelThumbnail.getCarLabel().setText("Car Thumbnail:");
        
        smallInputPanelDescription = new SmallInputPanel();
        smallInputPanelDescription.getCarLabel().setText("Car Description:");
        
        smallInputPanelURL = new SmallInputPanel();
        smallInputPanelURL.getCarLabel().setText("Car URL:");
        icon = new ImageIcon();

        icon = new ImageIcon("C:\\data\\car.jpg");

        
        labelimage= new JLabel(icon);
        
        
        
        
        

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        add(smallInputPanelId);
        add(smallInputPanelManufacturer);
        add(smallInputPanelType);
        add(smallInputPanelModel);
        add(smallInputPanelVIN);
        add(smallInputPanelThumbnail);
        add(smallInputPanelDescription);
        add(smallInputPanelURL);
        add(labelimage);
       


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

    public SmallInputPanel getSmallInputPanelVIN() {
        return smallInputPanelVIN;
    }

    public void setSmallInputPanelVIN(SmallInputPanel smallInputPanelVIN) {
        this.smallInputPanelVIN = smallInputPanelVIN;
    }

    public SmallInputPanel getSmallInputPanelThumbnail() {
        return smallInputPanelThumbnail;
    }

    public void setSmallInputPanelThumbnail(SmallInputPanel smallInputPanelThumbnail) {
        this.smallInputPanelThumbnail = smallInputPanelThumbnail;
    }

    public SmallInputPanel getSmallInputPanelDescription() {
        return smallInputPanelDescription;
    }

    public void setSmallInputPanelDescription(SmallInputPanel smallInputPanelDescription) {
        this.smallInputPanelDescription = smallInputPanelDescription;
    }

    public SmallInputPanel getSmallInputPanelURL() {
        return smallInputPanelURL;
    }

    public void setSmallInputPanelURL(SmallInputPanel smallInputPanelURL) {
        this.smallInputPanelURL = smallInputPanelURL;
    }

    public JLabel getLabelimage() {
        return labelimage;
    }

    public void setLabelimage(JLabel labelimage) {
        this.labelimage = labelimage;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    



   
    
}
