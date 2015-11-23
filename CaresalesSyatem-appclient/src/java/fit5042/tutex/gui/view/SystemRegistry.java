/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.gui.view;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ruchitha
 */
public class SystemRegistry {

    private static SystemRegistry singletonInstance = new SystemRegistry();
   
  
    
    
    private CarSalesGUI carSalesGUI;

//    private PropertyRepository propertyRepository;

    private SystemRegistry() {
        try {
//            propertyRepository = PropertyRepositoryFactory.getInstance();
        } catch (Exception ex) {
            Logger.getLogger(SystemRegistry.class.getName()).log(Level.SEVERE, null, ex);
        }
        carSalesGUI = new CarSalesGUI();

    }

    public CarSalesGUI getCarSalesGUI() {
        return carSalesGUI;
    }

    public void initializeModel() {
        carSalesGUI = new CarSalesGUI();
    }

//    public PropertyRepository getPropertyRepository() {
//        return propertyRepository;
//    }
//
//    public void setPropertyRepository(PropertyRepository propertyRepository) {
//        this.propertyRepository = propertyRepository;
//    }

    public static SystemRegistry getSingletonInstance() {

        return singletonInstance;

    }

}
