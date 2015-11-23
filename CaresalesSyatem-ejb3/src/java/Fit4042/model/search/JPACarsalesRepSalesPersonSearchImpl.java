package Fit4042.model.search;

import Fit5042.entities.Car;
import Fit5042.entities.Customer;
import Fit5042.entities.SalesPerson;
import Fit5042.entities.Type;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class JPACarsalesRepSalesPersonSearchImpl implements CarsalesRepositorySalesPersonSearch {

    @PersistenceContext(unitName = "ZCaresalesSyatem-ejb3PU")
    private EntityManager em;

    @Override
    public Car searchCarById(int id) throws Exception {

        Car car = em.find(Car.class, id);
        return car;
    }

    @Override
    public List<Car> getAllCars() throws Exception {

        List<Car> list = em.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        list.size();
        return list;

    }

    @Override
    public List<Car> getCarsByMake(String manufacturer) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("manufacturer").as(String.class), manufacturer));
        List<Car> list = em.createQuery(query).getResultList();
        list.size();

        return list;

    }

    @Override
    public List<Car> getCarsByModelName(String modelName) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("modelName").as(String.class), modelName));

        List<Car> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<Car> getCarsByType(String type) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("type").as(String.class), type));
        
        Type ctype = Type.valueOf(type);
        
        
        
        List<Car> list = em.createNamedQuery("Car.findByType").setParameter("type", ctype).getResultList();
        
//        List<Car> list = em.createQuery(query).getResultList();
        
        
        
        
        list.size();

        return list;

    }

    @Override
    public Customer searchCustomerById(int id) throws Exception {

        Customer customer = em.find(Customer.class, id);

        return customer;

    }

    @Override
    public List<Customer> getAllCustomers() throws Exception {

        List<Customer> list = em.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Customer.class);
        Root<Customer> p = query.from(Customer.class);
        query.select(p).where(builder.equal(p.get("firstName").as(String.class), firstName));

        List<Customer> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<Customer> getCustomerByLastName(String lastName) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Customer.class);
        Root<Customer> p = query.from(Customer.class);
        query.select(p).where(builder.equal(p.get("lastName").as(String.class), lastName));

        List<Customer> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    @Override
    public void removeCar(int carid) throws Exception {

        Car car = em.find(Car.class, carid);
        if (car != null) {
            em.remove(car);
        }
    }

    @Override
    public void addCar(Car car) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCustomer(int customerid) throws Exception {
        Customer customer = em.find(Customer.class, customerid);
        if (customer != null) {
            em.remove(customer);
        }
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCar(Car car) throws Exception {

        em.merge(car);
    
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {

        em.merge(customer);
    }

    @Override
    public List<Customer> getCustomerByType(String type) throws Exception {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Customer.class);
        Root<Customer> p = query.from(Customer.class);
        query.select(p).where(builder.equal(p.get("type").as(String.class), type));

        Fit5042.entities.enumuser.Type ctype = Fit5042.entities.enumuser.Type.valueOf(type);
  
        List<Customer> list = em.createNamedQuery("Customer.findByType").setParameter("type", ctype).getResultList();
        
        
//        List<Customer> list = em.createQuery(query).getResultList();
 
        list.size();

        return list;
    }

    @Override
    public List<Customer> getCustomerByEmail(String email) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Customer.class);
        Root<Customer> p = query.from(Customer.class);
        query.select(p).where(builder.equal(p.get("email").as(String.class), email));

        List<Customer> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    
    
    
    
    
    
    
    
    
    
    
     @Override
    public SalesPerson searchSalesPersonById(int id) throws Exception {

        SalesPerson salesPerson = em.find(SalesPerson.class, id);

        return salesPerson;

    }

    @Override
     public List<SalesPerson> getAllSalesPerson() throws Exception{

        List<SalesPerson> list = em.createNamedQuery(SalesPerson.GET_ALL_QUERY_NAME).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<SalesPerson> getSalesPersonByFirstName(String firstName) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SalesPerson.class);
        Root<SalesPerson> p = query.from(SalesPerson.class);
        query.select(p).where(builder.equal(p.get("firstName").as(String.class), firstName));

        List<SalesPerson> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<SalesPerson> getSalesPersonByLastName(String lastName) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SalesPerson.class);
        Root<SalesPerson> p = query.from(SalesPerson.class);
        query.select(p).where(builder.equal(p.get("lastName").as(String.class), lastName));

        List<SalesPerson> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }
    
    
     @Override
    public void removeSalesPerson(int salesPersonid) throws Exception {
        SalesPerson salesPerson = em.find(SalesPerson.class, salesPersonid);
        if (salesPerson != null) {
            em.remove(salesPerson);
        }
    }

    @Override
    public void addSalesPerson(SalesPerson salesPerson) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     @Override
    public void updateSalesPerson(SalesPerson salesPerson) throws Exception {

        em.merge(salesPerson);
    }

    @Override
    public List<SalesPerson> getSalesPersonByType(String type) throws Exception {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SalesPerson.class);
        Root<SalesPerson> p = query.from(SalesPerson.class);
        query.select(p).where(builder.equal(p.get("type").as(String.class), type));

        List<SalesPerson> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }

    @Override
    public List<SalesPerson> getSalesPersonByEmail(String email) throws Exception {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(SalesPerson.class);
        Root<SalesPerson> p = query.from(SalesPerson.class);
        query.select(p).where(builder.equal(p.get("email").as(String.class), email));

        List<SalesPerson> list = em.createQuery(query).getResultList();
        list.size();

        return list;
    }
    
    
    
    
    
    
    
    
    
}
