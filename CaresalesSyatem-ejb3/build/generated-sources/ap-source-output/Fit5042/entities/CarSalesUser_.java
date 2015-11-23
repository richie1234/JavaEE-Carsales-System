package Fit5042.entities;

import Fit5042.entities.Address;
import Fit5042.entities.enumuser.Type;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-24T08:21:51")
@StaticMetamodel(CarSalesUser.class)
public abstract class CarSalesUser_ { 

    public static volatile SingularAttribute<CarSalesUser, String> lastName;
    public static volatile SingularAttribute<CarSalesUser, String> firstName;
    public static volatile SingularAttribute<CarSalesUser, String> password;
    public static volatile SingularAttribute<CarSalesUser, Address> address;
    public static volatile SingularAttribute<CarSalesUser, String> phoneNumber;
    public static volatile SingularAttribute<CarSalesUser, Type> type;
    public static volatile SingularAttribute<CarSalesUser, Integer> userId;
    public static volatile SingularAttribute<CarSalesUser, String> email;

}