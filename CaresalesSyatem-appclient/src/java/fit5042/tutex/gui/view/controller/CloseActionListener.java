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

/**
 *
 * @author Ruchitha
 */
public class CloseActionListener  implements ActionListener{
//    @EJB
//    private CarsalesRepositoryCustomerSearch carsalesRepositoryCustomerSearch;
    private CarSalesGUI carSalesGUI;
    JPACarsalesRepCustomerSearchImpl repo = new JPACarsalesRepCustomerSearchImpl();
    List<Car> carlist;
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        SystemRegistry registry=SystemRegistry.getSingletonInstance();
        

	this.carSalesGUI = registry.getCarSalesGUI();
        carSalesGUI.setVisible(false); 
        carSalesGUI.dispose();
      
    }
    
   
}
        
