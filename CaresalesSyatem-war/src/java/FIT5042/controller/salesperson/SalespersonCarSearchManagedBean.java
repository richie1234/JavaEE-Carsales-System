/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.salesperson;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Car;
import Fit5042.model.CarFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


/**
 *
 * @author Ruchitha
 */
@ManagedBean
@SessionScoped
public class SalespersonCarSearchManagedBean {
    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;

    @EJB
    private CarFacade carFacade;

    private CarSearchValidation searchcar =  new  CarSearchValidation();
    private Part file1;
    private Car selectedCar = new  Car();
    

    private List<Car> carList;

    @PostConstruct
    public void init() {
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        } catch (Exception ex) {
            Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Car> findAllCars() throws Exception {

        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();

        return carList;
    }

    public List<Car> findCarByID(int id) throws Exception {

        Car car = jPACarsalesRepSalesPersonSearchImpl.searchCarById(id);
        carList = new ArrayList<>();
        carList.add(car);
        
        return carList;
    }

    public List<Car> findCarByMake(String make) throws Exception {

        carList = jPACarsalesRepSalesPersonSearchImpl.getCarsByMake(make);

        return carList;
    }

    public List<Car> findCarByModelName(String modelName) throws Exception {

        carList = jPACarsalesRepSalesPersonSearchImpl.getCarsByModelName(modelName);

        return carList;
    }

    public List<Car> findCarByType(String carType) throws Exception {

        carList = jPACarsalesRepSalesPersonSearchImpl.getCarsByType(carType);

        return carList;
    }

    public CarSearchValidation getSearchcar() {
        return searchcar;
    }

    public void setSearchcar(CarSearchValidation searchcar) {
        this.searchcar = searchcar;
    }
    
      public String searchButtonPressed() {
          
        if(searchcar.getModelNo() != null && searchcar.getModelNo() >0 )
        {
            
            try {
                carList = findCarByID(searchcar.getModelNo());
            } catch (Exception ex) {
                Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else if(searchcar.getModelName() != null && !searchcar.getModelName().isEmpty() )                
        {
        
            try {
                carList =  findCarByModelName(searchcar.getModelName());
            } catch (Exception ex) {
                Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        else if(searchcar.getManufacturer() != null && !searchcar.getManufacturer().isEmpty())                
        {
        
            try {
                carList =  findCarByMake(searchcar.getManufacturer());
            } catch (Exception ex) {
                Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        else if(searchcar.getType() != null && !searchcar.getType().toString().isEmpty())                
        {
        
          
            try {
                carList =  findCarByType(searchcar.getType().toString());
            } catch (Exception ex) {
                Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        
        }
          
          
        this.searchcar = new  CarSearchValidation();
        
        return "salesPersonCarSearch";
          
//        this.searchcar = searchcar;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
    
    public String viewAllButtonPressed() {
          
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        } catch (Exception ex) {
            Logger.getLogger(SalespersonCarSearchManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "salesPersonCarSearch";
    }
    
    public String removeCar(int id) throws Exception {

        this.jPACarsalesRepSalesPersonSearchImpl.removeCar(id);
        
         return "salesPersonCarSearch";
        
    }
    
    public String update()  throws IOException {

        
//        String path2 = ("C:\\data\\");        
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("addCar.xhtml");
        System.out.println(path);        
        String[] parts = path.split("ZCaresalesSyatem");       
        path = parts[0];   
        path = path + "//ZCaresalesSyatem-war//web//resources//images";
        
       
       if(file1 != null){
        FileOutputStream out;
        try (InputStream in = file1.getInputStream()) {
            byte[] data = new byte[in.available()];
            in.read(data);
            out = new FileOutputStream(new File(path)+"//"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
            out.write(data);
        }

//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path2)+"\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
        out.close();
         
        }
//       else {
//       
//        FileOutputStream out;
//        path = path + "\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg";
//        
//        InputStream in = new FileInputStream(path);
//        byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path));
//            out.write(data);
// 
//       // path = path + "\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg";
//        
//            data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path2)+"\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//            out.close();
//        }

        
        
        return "index";  
    }
    
     public String updateCar() throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.updateCar(selectedCar);
        update();
        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        selectedCar = null;
        
        return null;
        
    }
     
    public String selectForModification(Car selectedCar) {
        this.selectedCar = selectedCar;
        return null;
    }
    

    
}
