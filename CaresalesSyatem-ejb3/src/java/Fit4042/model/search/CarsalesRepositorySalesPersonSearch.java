package Fit4042.model.search;

import Fit5042.entities.Car;
import Fit5042.entities.Customer;
import Fit5042.entities.SalesPerson;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;


public interface CarsalesRepositorySalesPersonSearch {

    public Car searchCarById(int id) throws Exception;
    public List<Car> getAllCars() throws Exception;
    public List<Car> getCarsByMake(String make) throws Exception;    
    public List<Car> getCarsByModelName(String modelName) throws Exception;
    public List<Car> getCarsByType(String carType) throws Exception;
    public void removeCar(int id) throws Exception;
    public void addCar(Car car) throws Exception;
    public void updateCar(Car car) throws Exception;
    
    
    
    
    public Customer searchCustomerById(int id) throws Exception;
    public List<Customer> getAllCustomers() throws Exception;
    public List<Customer> getCustomerByFirstName(String fName) throws Exception;    
    public List<Customer> getCustomerByLastName(String lName) throws Exception;
    public void removeCustomer(int id) throws Exception;
    public void addCustomer(Customer customer) throws Exception;
    public void updateCustomer(Customer customer) throws Exception;
    public List<Customer> getCustomerByType(String type) throws Exception;
    public List<Customer> getCustomerByEmail(String email) throws Exception;
    
    
    
    public SalesPerson searchSalesPersonById(int id) throws Exception;
    public List<SalesPerson> getAllSalesPerson() throws Exception;
    public List<SalesPerson> getSalesPersonByFirstName(String fName) throws Exception;    
    public List<SalesPerson> getSalesPersonByLastName(String lName) throws Exception;
    public void removeSalesPerson(int id) throws Exception;
    public void addSalesPerson(SalesPerson salesPerson) throws Exception;
    public void updateSalesPerson(SalesPerson salesPerson) throws Exception;
    public List<SalesPerson> getSalesPersonByType(String type) throws Exception;
    public List<SalesPerson> getSalesPersonByEmail(String email) throws Exception;

}
