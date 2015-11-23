package Fit5042.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ruchitha
 */
@Entity
@Table(name = "customer")
@NamedQueries({
    @NamedQuery(name = "Customer.findByType", query = "SELECT c FROM Customer c WHERE c.type = :type"),
    @NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c")})
public class Customer extends CarSalesUser implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
            
    @OneToMany(mappedBy = "customerId")
    private List<Sale> saleList;


    public Customer() {
    }


    @XmlTransient
    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    
}
