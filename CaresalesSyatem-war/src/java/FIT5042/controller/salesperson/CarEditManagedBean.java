/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.salesperson;

import Fit4042.model.search.CarsalesRepositorySalesPersonSearch;
import Fit5042.entities.Car;
import Fit5042.entities.Customer;
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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;


/**
 *
 * @author Ruchitha
 */
@ManagedBean
//@SessionScoped
@ViewScoped
public class CarEditManagedBean {
    
    @EJB
    private CarFacade carFacade;

    @EJB
    private CarsalesRepositorySalesPersonSearch jPACarsalesRepSalesPersonSearchImpl;
    
    

    private List<Car> carList;
    private Car selectedCar = new  Car();
    private Part file1;
  
    
    
    private Car newcar =  new  Car();
    
    @PostConstruct
    public void init(){
        try { 
            carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        } catch (Exception ex) {
            Logger.getLogger(CarEditManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public List<Car> findCarByID(int id) throws Exception {

        Car car = jPACarsalesRepSalesPersonSearchImpl.searchCarById(id);
        carList = new ArrayList<>();
        carList.add(car);
        
        return carList;
    }


    public List<Car> findAll() throws Exception {

        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        
        return carList;
    }
    
    
   public String removeCar(int id) throws Exception {

        this.jPACarsalesRepSalesPersonSearchImpl.removeCar(id);
        
        return null;
        
    }
   
    public String addCar() throws Exception {

        try{
        this.carFacade.create(this.newcar);
        upload();
        }catch(Exception ex){
         return "index";
        }
        this.newcar = new  Car();
        
        
        return "index";
        
    }
   
   
   
     public String removeCustomer(int id) throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.removeCustomer(id);
        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        return null;
        
    }
     
   public String updateCar() throws Exception {

        jPACarsalesRepSalesPersonSearchImpl.updateCar(selectedCar);
        update();
        carList = jPACarsalesRepSalesPersonSearchImpl.getAllCars();
        selectedCar = null;
        
        return null;
        
    }
   
   public String updateCustomer(Customer customer) throws Exception {

        
       this.jPACarsalesRepSalesPersonSearchImpl.updateCustomer(customer);
        
        return null;
        
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
   
    public String selectForModification(Car selectedCar) {
       this.selectedCar = selectedCar;
//        this.selectedCar = this.carList.get(0);
        return null;
    }

    public Car getNewcar() {
        return newcar;
    }

    public void setNewcar(Car newcar) {
        this.newcar = newcar;
    }

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }
    
    public String upload()  throws IOException {
//        String path2 = ("C:\\data\\");
        
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("index.xhtml");
        System.out.println(path);        
        String[] parts = path.split("ZCaresalesSyatem");       
        path = parts[0];   
        path = path + "//ZCaresalesSyatem-war//web//resources//images";
        
       
        if(file1 != null){
         FileOutputStream out;
         
        try (InputStream in = file1.getInputStream()) {
            byte[] data = new byte[in.available()];
            in.read(data);
            out = new FileOutputStream(new File(path)+"//"+this.newcar.getThumbnail()+"-"+this.newcar.getVehicleIdentificationNumber()+".jpg");
            out.write(data);
        }

//        try (InputStream in = file1.getInputStream()) {
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            out = new FileOutputStream(new File(path2)+"\\"+this.newcar.getThumbnail()+"-"+this.newcar.getVehicleIdentificationNumber()+".jpg");
//            out.write(data);
//        }
        out.close();
        
        }
        
  
        return "index";  
    }
    
    
    
    public String update()  throws IOException {

        
//        String path2 = ("C:\\data\\");        
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("index.xhtml");
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
      
      public static  String getFileName(Part part){
          
          for (String cd : part.getHeader("content-disposition").split(";")) {  
            if (cd.trim().startsWith("filename")) {  
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");  
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.  
            }  
        }  
        return null;  
    }  

    private String getFilename(Part file1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
