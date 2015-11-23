/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.salesperson;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.SalesPerson;
import Fit5042.entities.Users;
import Fit5042.model.CustomerFacade;
import Fit5042.model.SalesPersonFacade;
import Fit5042.model.jaas.GroupsFacade;
import Fit5042.model.jaas.UsersFacade;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class AddSalespersonManagedBean {
    @EJB
    private GroupsFacade groupsFacade;
    @EJB
    private UsersFacade usersFacade;
    
    @EJB
    private SalesPersonFacade salesPersonFacade;
    
    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;
 
    private List<SalesPerson> salesPersonList; 
    private SalesPerson newSalesPerson = new SalesPerson();
    
    @PostConstruct
    public void init(){
        try { 
            salesPersonList = jPACarsalesRepSalesPersonSearchImpl.getAllSalesPerson();
        } catch (Exception ex) {
            Logger.getLogger(AddSalespersonManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public SalesPerson getNewSalesPerson() {
        return newSalesPerson;
    }

    public void setNewSalesPerson(SalesPerson newSalesPerson) {
        this.newSalesPerson = newSalesPerson;
    }





    
    
    public String addUser() throws Exception {

        try{
            
                    
            String hashedPassword = encryptPassword(this.newSalesPerson.getPassword());        
            this.newSalesPerson.setPassword(hashedPassword); 
            
            String emails = this.newSalesPerson.getEmail();
            
            Fit5042.entities.Groups group = new Fit5042.entities.Groups();
            group.setGroupname(this.newSalesPerson.getType().toString());
            group.setUsername(this.newSalesPerson.getEmail());
            group.setId(Long.valueOf("1").longValue());
       
       this.groupsFacade.create(group);
            
        Fit5042.entities.Users rluser = new Users();
        rluser.setPassword(this.newSalesPerson.getPassword());
        rluser.setUsername(this.newSalesPerson.getEmail());
        rluser.setId(Long.valueOf("1").longValue());
        this.usersFacade.create(rluser);

        
       
        this.salesPersonFacade.create(this.newSalesPerson);
       
        
        }catch(Exception ex){
            
            return "error";
        
        
        }
        this.newSalesPerson = new  SalesPerson();
        
        
        return "index";
        
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
    
   
}
    
        


