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
@Table(name = "salesperson")
@NamedQueries({
    @NamedQuery(name = SalesPerson.GET_ALL_QUERY_NAME, query = "SELECT c FROM SalesPerson c")})
public class SalesPerson extends CarSalesUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String GET_ALL_QUERY_NAME = "SalesPerson.getAll";

    @OneToMany(mappedBy = "salesPersonId")
    private List<Sale> saleList;

    public SalesPerson() {
    }

    @XmlTransient
    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    
}
