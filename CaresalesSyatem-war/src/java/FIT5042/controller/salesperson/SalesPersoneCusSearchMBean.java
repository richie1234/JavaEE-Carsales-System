/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.salesperson;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Customer;
import Fit5042.model.CustomerFacade;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;



/**
 *
 * @author Ruchitha
 */
@ManagedBean
//@ViewScoped
@SessionScoped
public class SalesPersoneCusSearchMBean {
   
    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;
    
    private CustomerSearchValidation searchedcustomer =  new  CustomerSearchValidation();
    
      private Customer selectedCustomer= new  Customer();
    
    private List<Customer> customerList;
    private List<Customer> customerCombinationSearchlist;
    private Part file1;
    
    @PostConstruct
    public void init(){
        try { 
            customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
            customerCombinationSearchlist = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
     public List<Customer> findAllCustomer() throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        
        return customerList;
    }
    
      public List<Customer> findCustomerByID(int id) throws Exception {

        Customer customer = jPACarsalesRepSalesPersonSearchImpl.searchCustomerById(id);
        customerList = new ArrayList<>();
        customerList.add(customer);
        
        return customerList;
    }

    public List<Customer> findCustomerByLastName(String cLastName) throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getCustomerByLastName(cLastName);

        return customerList;
    }

    public List<Customer> findCustomerByFirstName(String cFirstName) throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getCustomerByFirstName(cFirstName);

        return customerList;
    }

    public List<Customer> findCustomerByType(String customerType) throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getCustomerByType(customerType);

        return customerList;
    }

    
     public List<Customer> findCustomerByEmail(String customerEmail) throws Exception {

        customerList = jPACarsalesRepSalesPersonSearchImpl.getCustomerByEmail(customerEmail);

        return customerList;
    }

    public CustomerSearchValidation getSearchedcustomer() {
        return searchedcustomer;
    }

    public void setSearchedcustomer(CustomerSearchValidation searchedcustomer) {
        this.searchedcustomer = searchedcustomer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
     
     
     public String searchButtonPressed() {
          
        if(searchedcustomer.getUserId() != null && searchedcustomer.getUserId() >0 )
        {
            
            try {
                customerList = findCustomerByID(searchedcustomer.getUserId());
                customerCombinationSearchlist.addAll(customerList);
                
            } catch (Exception ex) {
                Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        if(searchedcustomer.getLastName() != null && !searchedcustomer.getLastName().isEmpty() )                
        {
        
            try {
                customerList =  findCustomerByLastName(searchedcustomer.getLastName());
                customerCombinationSearchlist.addAll(customerList);
            } catch (Exception ex) {
                Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        
        if(searchedcustomer.getFirstName()!= null && !searchedcustomer.getFirstName().isEmpty())                
        {
        
            try {
                customerList =  findCustomerByFirstName(searchedcustomer.getFirstName());
                customerCombinationSearchlist.addAll(customerList);
            } catch (Exception ex) {
                Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
          
        if(searchedcustomer.getEmail()!= null && !searchedcustomer.getEmail().isEmpty())                
        {
        
            try {
                customerList =  findCustomerByEmail(searchedcustomer.getEmail());
                customerCombinationSearchlist.addAll(customerList);
            } catch (Exception ex) {
                Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
        if(searchedcustomer.getType()!= null && !searchedcustomer.getType().toString().isEmpty())                
        {
        
          
            try {
                customerList =  findCustomerByType(searchedcustomer.getType().toString());
                customerCombinationSearchlist.addAll(customerList);
            } catch (Exception ex) {
                Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        }
     
        Set<Customer> hs = new HashSet<>();
        hs.addAll(customerCombinationSearchlist);
        customerCombinationSearchlist.clear();
        customerCombinationSearchlist.addAll(hs);
        
        
        if(customerCombinationSearchlist.size()>0){
        
            customerList = this.customerCombinationSearchlist;
        
        }
          
        customerCombinationSearchlist = new ArrayList<>();
          
        this.searchedcustomer = new  CustomerSearchValidation();
        
        return "salesPersonCustomerSearch";

    } 
    
     public String viewAllButtonPressed() {
          
        try {
            customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(SalesPersoneCusSearchMBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "salesPersonCustomerSearch";
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }
    
    
    public String updateCustomer() throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.updateCustomer(selectedCustomer);       
        customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        selectedCustomer = null;
        
        return null;
        
    }
    
        public String selectForModification(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
        return null;
    }
        
        
        
}
