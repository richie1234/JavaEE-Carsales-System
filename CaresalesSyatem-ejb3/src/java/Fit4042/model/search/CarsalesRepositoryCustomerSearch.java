package Fit4042.model.search;


import Fit5042.entities.Car;
import java.util.List;


public interface CarsalesRepositoryCustomerSearch {

    public Car searchCarById(int id) throws Exception;
    public List<Car> getAllCars() throws Exception;
    public List<Car> getCarsByMake(String make) throws Exception;    
    public List<Car> getCarsByModelName(String modelName) throws Exception;
    public List<Car> getCarsByType(String carType) throws Exception;

}
