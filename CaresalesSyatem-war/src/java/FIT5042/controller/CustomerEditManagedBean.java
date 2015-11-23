/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.CarSalesUser;
import Fit5042.entities.Customer;
import Fit5042.model.CustomerFacade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Ruchitha
 */
@ManagedBean
//@SessionScoped
@ViewScoped
public class CustomerEditManagedBean {
    @EJB
    private CustomerFacade customerFacade;
    
    
 
    
    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;
    
    private Customer selectedCustomer =  new  Customer();    
    private List<Customer> customerList; 
    private CarSalesUser newCustomer =  new  Customer();
    
    
    
    @PostConstruct
    public void init(){
        try { 
            customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(CustomerEditManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }


    public List<Customer> findAll() throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        
        return customerList;
    }
    
    
   public String removeCar(int id) throws Exception {

        this.jPACarsalesRepSalesPersonSearchImpl.removeCar(id);
        
        return null;
        
    }
   
    public String addCar() throws Exception {

        this.customerFacade.create((Customer)this.newCustomer);

        this.newCustomer = new  Customer();
        
        
        return "salesPersonCustomerEdit";
        
    }
   
   
   
     public String removeCustomer(int id) throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.removeCustomer(id);
        customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        return null;
        
    }
     
   public String updateCustomer() throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.updateCustomer(selectedCustomer);      
        customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        selectedCustomer = null;
        
        return null;
        
    }
   
   public String updateCustomer(Customer customer) throws Exception {

        
       this.jPACarsalesRepSalesPersonSearchImpl.updateCustomer(customer);
        
        return null;
        
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Customer getNewCustomer() {
        return (Customer)newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }
    
    public String selectForModification(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
        return null;
    }

   
    
    
    
}
