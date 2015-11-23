package Fit4042.model.search;



import Fit5042.entities.Car;
import Fit5042.entities.Type;
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
public class JPACarsalesRepCustomerSearchImpl implements CarsalesRepositoryCustomerSearch {

     @PersistenceContext
    private EntityManager entityManager;
    
     @Override
    public Car searchCarById(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZCaresalesSyatem-ejb3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
  
//        Car car1 = new Car();       
//        car1.setModelName("camry");
//        car1.setDescription("Two seat sedan");
//        car1.setManufacturer("Toyota");
//        car1.setPreviewURL("www.amazon.com");
//        car1.setType("sedan");
//        car1.setVehicleIdentificationNumber("tre65765e5e5e72");// 
//        
//        em.persist(car1);
//        
//        Car car2 = new Car();       
//        car2.setModelName("Accord");
//        car2.setDescription("Three seat sedan");
//        car2.setManufacturer("Honda");
//        car2.setPreviewURL("www.2amazon.com");
//        car2.setType("Hatch Back");
//        car2.setVehicleIdentificationNumber("2tre65765e5e5e72");// 
//        
//        em.persist(car2);    
//        
//        
//        Car car3 = new Car();       
//        car3.setModelName("C class");
//        car3.setDescription("2 seat sprot");
//        car3.setManufacturer("Mecedes");
//        car3.setPreviewURL("www.amazon.com");
//        car3.setType("Four Wheel Drive");
//        car3.setVehicleIdentificationNumber("2tre65765e5e5e723");// 
//        
//        em.persist(car3); 
////  
//        em.getTransaction().commit();
        
        Car car = em.find(Car.class, id);     
        
       
        
        em.close();
        emf.close();
        
        return car;
    }

    @Override
    public List<Car> getAllCars() throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZCaresalesSyatem-ejb3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Car> list = em.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
        list.size();
        em.close();
        emf.close();
        return list;
    }

    @Override
    public List<Car> getCarsByMake(String manufacturer) throws Exception {
         
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZCaresalesSyatem-ejb3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("manufacturer").as(String.class), manufacturer));
        List<Car> list = em.createQuery(query).getResultList();
        list.size();
        em.close();
        emf.close();
        
        return list;
        
        
    }

    @Override
    public List<Car> getCarsByModelName(String modelName) throws Exception {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZCaresalesSyatem-ejb3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("modelName").as(String.class), modelName));
        
        List<Car> list = em.createQuery(query).getResultList();
        list.size();
        em.close();
        emf.close();
        
        return list;
    }

    @Override
    public List<Car> getCarsByType(String type) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ZCaresalesSyatem-ejb3PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Car.class);
        Root<Car> p = query.from(Car.class);
        query.select(p).where(builder.equal(p.get("type").as(String.class), type));
        
        Type ctype = Type.valueOf(type);
        
        
        List<Car> list = em.createNamedQuery("Car.findByType").setParameter("type", ctype).getResultList();
        
        
        list.size();
        em.close();
        emf.close();
        
        return list;
        
    }


   
}

//    @PersistenceContext(unitName = "ZCaresalesSyatem-ejb3PU")
//    private EntityManager em;
//    
//     @Override
//    public Car searchCarById(int id) throws Exception {
//       
//        Car car = em.find(Car.class, id);     
//         return car;
//    }
//
//    @Override
//    public List<Car> getAllCars() throws Exception {
//        
//
//        List<Car> list = em.createNamedQuery(Car.GET_ALL_QUERY_NAME).getResultList();
//        list.size();
//
//        return list;
//    }
//
//    @Override
//    public List<Car> getCarsByMake(String manufacturer) throws Exception {
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Car.class);
//        Root<Car> p = query.from(Car.class);
//        query.select(p).where(builder.equal(p.get("manufacturer").as(String.class), manufacturer));
//        List<Car> list = em.createQuery(query).getResultList();
//        list.size();
//
//        
//        return list;
//        
//        
//    }
//
//    @Override
//    public List<Car> getCarsByModelName(String modelName) throws Exception {
//  
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Car.class);
//        Root<Car> p = query.from(Car.class);
//        query.select(p).where(builder.equal(p.get("modelName").as(String.class), modelName));
//        
//        List<Car> list = em.createQuery(query).getResultList();
//        list.size();
//
//        
//        return list;
//    }
//
//    @Override
//    public List<Car> getCarsByType(String type) throws Exception {
//
//        
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery query = builder.createQuery(Car.class);
//        Root<Car> p = query.from(Car.class);
//        query.select(p).where(builder.equal(p.get("type").as(String.class), type));
//        
//        List<Car> list = em.createQuery(query).getResultList();
//        list.size();
//
//        
//        return list;
//        
//    }
//
//
//   
//}
//
