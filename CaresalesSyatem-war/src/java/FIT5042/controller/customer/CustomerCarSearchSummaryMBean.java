/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.customer;

import FIT5042.controller.salesperson.CarSearchValidation;
import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Car;
import Fit5042.entities.Sale;
import Fit5042.model.CarFacade;
import com.journaldev.jsf.beans.SessionBean;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Ruchitha
 */
@ManagedBean
//@SessionScoped
@ViewScoped
public class CustomerCarSearchSummaryMBean {
    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;

    @EJB
    private CarFacade carFacade;

    private CarSearchValidation searchcar =  new  CarSearchValidation();
    
    Car selestedToBuyCar;
    

    private List<Car> carList;

    @PostConstruct
    public void init() {
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
            selestedToBuyCar = new  Car();
        } catch (Exception ex) {
            Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    @PostActivate
    public void init2() {
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
            selestedToBuyCar = new  Car();
        } catch (Exception ex) {
            Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
        
    @PrePassivate
    public void init3() {
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
            selestedToBuyCar = new  Car();
        } catch (Exception ex) {
            Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @PreDestroy
    public void init4() {
        try {
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
            selestedToBuyCar = new  Car();
        } catch (Exception ex) {
            Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        else if(searchcar.getModelName() != null && !searchcar.getModelName().isEmpty() )                
        {
        
            try {
                carList =  findCarByModelName(searchcar.getModelName());
            } catch (Exception ex) {
                Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        else if(searchcar.getManufacturer() != null && !searchcar.getManufacturer().isEmpty())                
        {
        
            try {
                carList =  findCarByMake(searchcar.getManufacturer());
            } catch (Exception ex) {
                Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        else if(searchcar.getType() != null && !searchcar.getType().toString().isEmpty())                
        {
        
          
            try {
                carList =  findCarByType(searchcar.getType().toString());
            } catch (Exception ex) {
                Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        
        }
          
          
        this.searchcar = new  CarSearchValidation();
        
        return "customerCarSearch";
          
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
            Logger.getLogger(CustomerCarSearchSummaryMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "customerCarSearch";
    }
    public String selectToBuy(int id) throws Exception {
        
        //List<Car> car = findCarByID(id);
       Car car =  carFacade.find(id);
        
        selestedToBuyCar = car;
        int id2 = selestedToBuyCar.getModelNo();
        
        Sale sale = new Sale();
        HttpSession session = SessionBean.getSession();
        String username = (String) session.getAttribute("username");
        
        return "customerCarSearch";
    }

    public Car getSelestedToBuyCar() {
        return selestedToBuyCar;
    }

    public void setSelestedToBuyCar(Car selestedToBuyCar) {
        this.selestedToBuyCar = selestedToBuyCar;
    }
    
    public String customerAprovedPayment() {
          
        
        
        
        
        selestedToBuyCar = new Car();
        
        
        return "customerCarSearch";
    }
    
    

    
}
