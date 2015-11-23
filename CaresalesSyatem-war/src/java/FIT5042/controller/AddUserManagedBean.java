/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Customer;
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
public class AddUserManagedBean {
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
    
    private List<Customer> customerList; 
    private Customer newCustomer = new Customer();
//    private Customer newCustomer;
    
    @PostConstruct
    public void init(){
        try { 
            customerList = jPACarsalesRepSalesPersonSearchImpl.getAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(AddUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }



    
    
    public String addUser() throws Exception {

           
        String hashedPassword = encryptPassword(this.newCustomer.getPassword());        
        this.newCustomer.setPassword(hashedPassword);    
        
        Fit5042.entities.Groups group = new Fit5042.entities.Groups();
            group.setGroupname(this.newCustomer.getType().toString());
            group.setUsername(this.newCustomer.getEmail());
            group.setId(Long.valueOf("1").longValue());
       
       this.groupsFacade.create(group);
            
        Fit5042.entities.Users rluser = new Users();
        rluser.setPassword(this.newCustomer.getPassword());
        rluser.setUsername(this.newCustomer.getEmail());
        rluser.setId(Long.valueOf("1").longValue());
        this.usersFacade.create(rluser);
        
        
        
        this.customerFacade.create(this.newCustomer);
  
        this.newCustomer = new  Customer();       
        
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

//private static String byteToHex(final byte[] hash)
//{
////    Formatter formatter = new Formatter() {};
////    for (byte b : hash)
////    {
////        formatter.format("%02x", b);
////    }
////    String result = formatter.toString();
////    formatter.close();
//    
//     byte[] bytes = {-1, 0, 1, 2, 3 };
//    StringBuilder sb = new StringBuilder();
//    for (byte b : bytes) {
//        sb.append(String.format("%02X ", b));
//    }
//    System.out.println(sb.toString());
//    
//    
//    
//    
//    return result;
//}
    
    
    
    
    
}
    
    
    
//
//
//    public List<Car> findAll() throws Exception {
//
//        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
//        
//        return carList;
//    }
//    
//    
//   public String removeCar(int id) throws Exception {
//
//        this.jPACarsalesRepSalesPersonSearchImpl.removeCar(id);
//        
//        return null;
//        
//    }
//   
//    public String addCar() throws Exception {
//
//        this.carFacade.create(this.newcar);
//        
//        upload();
//        this.newcar = new  Car();
//        
//        
//        return "index";
//        
//    }
//   
//   
//   
//     public String removeCustomer(int id) throws Exception {
//
//        jPACarsalesRepSalesPersonSearchImpl.removeCustomer(id);
//        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
//        return null;
//        
//    }
//     
//   public String updateCar() throws Exception {
//
//        jPACarsalesRepSalesPersonSearchImpl.updateCar(selectedCar);
//        update();
//        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
//        selectedCar = null;
//        
//        return null;
//        
//    }
//   
//   public String updateCustomer(Customer customer) throws Exception {
//
//        
//       this.jPACarsalesRepSalesPersonSearchImpl.updateCustomer(customer);
//        
//        return null;
//        
//    }
//
//    public Car getSelectedCar() {
//        return selectedCar;
//    }
//
//    public void setSelectedCar(Car selectedCar) {
//        this.selectedCar = selectedCar;
//    }
//   
//      public String selectForModification(Car selectedCar) {
//        this.selectedCar = selectedCar;
//        return null;
//    }
//
//    public Car getNewcar() {
//        return newcar;
//    }
//
//    public void setNewcar(Car newcar) {
//        this.newcar = newcar;
//    }
//
//    public Part getFile1() {
//        return file1;
//    }
//
//    public void setFile1(Part file1) {
//        this.file1 = file1;
//    }
//    
//    public String upload()  throws IOException {
//        String path2 = ("C:\\data\\");
//        
//        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("addCar.xhtml");
//        System.out.println(path);        
//        String[] parts = path.split("dist");       
//        path = parts[0];    
//        parts = path.split("ZCaresalesSyatem");
//        path = parts[0];   
//        path = path + "\\ZCaresalesSyatem-war\\web\\resources\\images";
//        
//       
//        if(file1 != null){
//         FileOutputStream out;
//         
//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path)+"\\"+this.newcar.getThumbnail()+"-"+this.newcar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
//
//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path2)+"\\"+this.newcar.getThumbnail()+"-"+this.newcar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
//        out.close();
//        
//        }
//        
//  
//        return "index_6";  
//    }
//    
//    
//    
//    public String update()  throws IOException {
//
//        
//        String path2 = ("C:\\data\\");        
//        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("addCar.xhtml");
//        System.out.println(path);        
//        String[] parts = path.split("dist");       
//        path = parts[0];    
//        parts = path.split("ZCaresalesSyatem");
//        path = parts[0];   
//        path = path + "\\ZCaresalesSyatem-war\\web\\resources\\images";
//        
//       
//       if(file1 != null){
//        FileOutputStream out;
//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path)+"\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
//
//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path2)+"\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
//        out.close();
//         
//        }
////       else {
////       
////        FileOutputStream out;
////        path = path + "\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg";
////        
////        InputStream in = new FileInputStream(path);
////        byte[] data = new byte[in.available()];
////            in.read(data);
////            out = new FileOutputStream(new File(path));
////            out.write(data);
//// 
////       // path = path + "\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg";
////        
////            data = new byte[in.available()];
////            in.read(data);
////            out = new FileOutputStream(new File(path2)+"\\"+this.selectedCar.getThumbnail()+"-"+this.selectedCar.getVehicleIdentificationNumber()+".jpg");
////            out.write(data);
////            out.close();
////        }
//
//        
//        
//        return "index";  
//    }
//      
//      public static  String getFileName(Part part){
//          
//          for (String cd : part.getHeader("content-disposition").split(";")) {  
//            if (cd.trim().startsWith("filename")) {  
//                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
//                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
//            }  
//        }  
//        return null;  
//    }  
//
//    private String getFilename(Part file1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    

