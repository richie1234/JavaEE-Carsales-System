/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view.controller;


import Fit4042.model.search.JPACarsalesRepCustomerSearchImpl;
import Fit5042.entities.Car;
import fit5042.tutex.gui.view.CarSalesGUI;
import fit5042.tutex.gui.view.SystemRegistry;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruchitha
 */
public class ViewActionListener implements ActionListener{
//    @EJB
//    private CarsalesRepositoryCustomerSearch carsalesRepositoryCustomerSearch;
    private CarSalesGUI carSalesGUI;
    JPACarsalesRepCustomerSearchImpl repo = new JPACarsalesRepCustomerSearchImpl();    
    List<Car> carlist;
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        SystemRegistry registry=SystemRegistry.getSingletonInstance();
        
//        try {
//            this.propertyRepository = PropertyRepositoryFactory.getInstance();
//        } catch (Exception ex) {
//            Logger.getLogger(SearchActionListener.class.getName()).log(Level.SEVERE, null, ex);
//        }
	this.carSalesGUI = registry.getCarSalesGUI();
      
         DefaultTableModel model =null;
         model = (DefaultTableModel) carSalesGUI.getMainPanel().getDetailPanel().getjTable1().getModel();
        try {   
            carlist = repo.getAllCars();
        } catch (Exception ex) {
            Logger.getLogger(ViewActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
        if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            
        
        try {
            for (Car car : carlist) {
                
               model.addRow(new Object[]{car.getModelNo(), car.getManufacturer(), car.getModelName()});
                
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
   
}