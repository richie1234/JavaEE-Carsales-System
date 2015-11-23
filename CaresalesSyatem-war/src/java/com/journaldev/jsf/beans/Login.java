package com.journaldev.jsf.beans;
 
import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Customer;
import Fit5042.entities.SalesPerson;
import Fit5042.model.CustomerFacade;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

 
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    @EJB
    private CustomerFacade customerFacade;
 
    private static final long serialVersionUID = 1094801825228386363L;
    
    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;
    
    
     
    private String pwd;
    private String msg;
    private String user;
 
    public String getPwd() {
        return pwd;
    }
 
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
 
    public String getMsg() {
        return msg;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }
 
    public String getUser() {
        return user;
    }
 
    public void setUser(String user) {
        this.user = user;
    }
 
    //validate login
    public String validateUsernamePassword() {
      //  boolean valid = LoginDAO.validate(user, pwd);
        
        boolean valid  = false;
        boolean validcustomer  = false;
        boolean validsalesperson  = false;
        List<Customer> customer= new ArrayList<>();
        List<SalesPerson> salesPersons= new ArrayList<>();
        try {
            customer = jPACarsalesRepSalesPersonSearchImpl.getCustomerByEmail(user);
            salesPersons = jPACarsalesRepSalesPersonSearchImpl.getSalesPersonByEmail(user);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
           
          if(customer.size()>0 && customer.get(0).getPassword().equals(encryptPassword(pwd)) )
          {
               valid = true;
               validcustomer = true;
          }
          else if(salesPersons.size()>0 && salesPersons.get(0).getPassword().equals(encryptPassword(pwd)) )
          {
               valid = true;
               validsalesperson = true;
               validcustomer = true;
          }
   
        if (valid && validcustomer && validsalesperson) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", user);
            session.setAttribute("salesperson", "true");           
            return "salesperson/index";
        } else if(valid && validcustomer){
            
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", user);
            session.setAttribute("customer", "true");
            
            return "customer/index";

        }
        
        
        
        else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login";
        }
    }
    
    private static String encryptPassword(String password)
{
    String sha1 = "";
    try
    {
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes("UTF-8"));
        StringBuffer sb = new StringBuffer();
        byte[] result = crypt.digest();
         for (int i = 0; i < result.length; i++) {
      sb.append(String.format("%02x", result[i]));
    }

    return sb.toString(); 

    }
    catch(NoSuchAlgorithmException e)
    {
        e.printStackTrace();
    }
    catch(UnsupportedEncodingException e)
    {
        e.printStackTrace();
    }

    
    return null;
}
    
    
    
    
    
 
    //logout event, invalidate session
    public String logout() {
        
        try{  
        HttpSession session = SessionBean.getSession();
       
      
        session.invalidate();
    } catch(Exception e)
    {
    
    }
        
        
        return "/login.xhtml";
    }
}