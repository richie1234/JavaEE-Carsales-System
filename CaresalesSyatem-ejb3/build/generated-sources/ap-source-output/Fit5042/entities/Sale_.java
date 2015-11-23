package Fit5042.entities;

import Fit5042.entities.Car;
import Fit5042.entities.Customer;
import Fit5042.entities.SalesPerson;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-24T08:21:51")
@StaticMetamodel(Sale.class)
public class Sale_ { 

    public static volatile SingularAttribute<Sale, Integer> saleId;
    public static volatile SingularAttribute<Sale, Customer> customerId;
    public static volatile SingularAttribute<Sale, String> saleDate;
    public static volatile SingularAttribute<Sale, Car> carId;
    public static volatile SingularAttribute<Sale, SalesPerson> salesPersonId;

}