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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ruchitha
 */
public class SearchActionListener implements ActionListener{
//    @EJB
//    private static CarsalesRepositoryCustomerSearch carsalesRepositoryCustomerSearch;
    
        JPACarsalesRepCustomerSearchImpl repo = new JPACarsalesRepCustomerSearchImpl();    
        private CarSalesGUI carSalesGUI;
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        SystemRegistry registry=SystemRegistry.getSingletonInstance();
        
//        try {
//            this.propertyRepository = PropertyRepositoryFactory.getInstance();
//        } catch (Exception ex) {
//            Logger.getLogger(SearchActionListener.class.getName()).log(Level.SEVERE, null, ex);
//        }
	this.carSalesGUI = registry.getCarSalesGUI();
        List<Car> carlist = new ArrayList<>();
      
         DefaultTableModel model =null;
         model = (DefaultTableModel) carSalesGUI.getMainPanel().getDetailPanel().getjTable1().getModel();
         Car car =null;
                 
         String carIdstr = carSalesGUI.getMainPanel().getInputPanel().getSmallInputPanelId().getCartxTfield().getText();
         int id; 
         System.out.println("carIdstr="+carIdstr.length());
         
         
         String carmake = carSalesGUI.getMainPanel().getInputPanel().getSmallInputPanelManufacturer().getCartxTfield().getText();
         
         System.out.println("carmake="+carmake);
        
         String carmodel = carSalesGUI.getMainPanel().getInputPanel().getSmallInputPanelModel().getCartxTfield().getText();
         System.out.println("carmodel="+carmodel);
         
         String cartype = carSalesGUI.getMainPanel().getInputPanel().getSmallInputPanelType().getCartxTfield().getText();
         System.out.println("cartype="+cartype);


         
         
        try {

            //System.out.println(id);
//            car = this.carsalesRepositoryCustomerSearch.searchCarById(id);
        if(carIdstr != null && !carIdstr.isEmpty()){
            
                    id = Integer.parseInt(carIdstr);
                    
                    car = repo.searchCarById(id);
                    carlist.add(car);
        }
        else if(carmake != null && !carmake.isEmpty()){
        
                    carlist = repo.getCarsByMake(carmake);
        }   
        else if(carmodel != null &&  !carmodel.isEmpty()){
        
                    carlist = repo.getCarsByModelName(carmodel);
        }
           
        else if(cartype != null &&  !cartype.isEmpty()){
        
                    carlist = repo.getCarsByType(cartype);
        }
            
            
            
            
          
            
        } catch (Exception ex) {
            Logger.getLogger(SearchActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
         if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }
            
        
        try {
            for (Car cartemp : carlist) {
               
               if(cartemp != null){
               model.addRow(new Object[]{cartemp.getModelNo(),  cartemp.getManufacturer(), cartemp.getModelName()});
               } 
            }
        } catch (Exception ex) {
            Logger.getLogger(ViewActionListener.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
   
}
                
        
//        if (model.getRowCount() > 0) {
//                for (int i = model.getRowCount() - 1; i > -1; i--) {
//                    model.removeRow(i);
//                }
//            }
//            
//        
//        if(car != null){     
//            model.addRow(new Object[]{ car.getModelNo(), car.getManufacturer(),
//                    car.getModelNo(), car.getType(), car.getModelName()});
////           }
//           } 
//      
//    }
//    
//   
//}

//model.addRow(new Object[]{ 1, "Hello",
//                    "Hello", "Hello", "Hello"});