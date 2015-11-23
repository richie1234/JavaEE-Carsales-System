/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view.controller;



import fit5042.tutex.gui.view.CarSalesGUI;
import fit5042.tutex.gui.view.SystemRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Fit4042.model.search.JPACarsalesRepCustomerSearchImpl;
import Fit5042.entities.Car;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JTable;

/**
 *
 * @author Ruchitha
 */
public class ListSelectionActionListener implements MouseListener{
   
    
    JPACarsalesRepCustomerSearchImpl repo = new JPACarsalesRepCustomerSearchImpl();
    private CarSalesGUI carSalesGUI ;

    @Override
    public void mouseClicked(MouseEvent e) {
        
        
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
        repo = new JPACarsalesRepCustomerSearchImpl();
        SystemRegistry registry=SystemRegistry.getSingletonInstance();
        this.carSalesGUI = registry.getCarSalesGUI();
        JTable modelTable = carSalesGUI.getMainPanel().getDetailPanel().getjTable1();
        int i = modelTable.getSelectedRow();   
//        System.out.println("llllllll =" +i);
        
        String carId = modelTable.getValueAt(i, 0).toString();
         System.out.println("llllllll =" +carId);        
         
        try {
            Car car = repo.searchCarById(Integer.parseInt(carId));
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelId().getCartxTfield().setText(car.getModelNo().toString());
           
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelDescription().getCartxTfield().setText(car.getDescription());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelManufacturer().getCartxTfield().setText(car.getManufacturer());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelModel().getCartxTfield().setText(car.getModelName());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelThumbnail().getCartxTfield().setText(car.getThumbnail());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelType().getCartxTfield().setText(car.getType().toString());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelURL().getCartxTfield().setText(car.getPreviewURL());
            carSalesGUI.getMainPanel().getFullDetailPanel().getSmallInputPanelVIN().getCartxTfield().setText(car.getVehicleIdentificationNumber());
            
            String filePath = new File("SearchActionListener.java").getAbsolutePath();
            System.out.println(filePath);        
            String[] parts = filePath.split("ZCaresalesSyatem");       
            filePath = parts[0];    

            filePath = filePath + "ZCaresalesSyatem-war//web//resources//images";
            System.out.println(filePath+car.getThumbnail()+"-"+car.getVehicleIdentificationNumber()+".jpg");
            
            ImageIcon icon = new ImageIcon(filePath+"//"+car.getThumbnail()+"-"+car.getVehicleIdentificationNumber()+".jpg");
           
           
            



//icon = new ImageIcon("C:\\data\\car.jpg");
            carSalesGUI.getMainPanel().getFullDetailPanel().getLabelimage().setIcon(icon);
            
//            carSalesGUI.getMainPanel().getFullDetailPanel().getLabelimage()
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ListSelectionActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    
   
   
}