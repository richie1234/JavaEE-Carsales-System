package Fit5042.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ruchitha
 */
@Entity
@Table(name = "sale")
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "saleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer saleId;
    @Column(name = "saleDate")
    private String saleDate;
    @JoinColumn(name = "carId", referencedColumnName = "modelNo")
    @ManyToOne
    private Car carId;
    @JoinColumn(name = "customerId", referencedColumnName = "userId")
    @ManyToOne
    private Customer customerId;
    @JoinColumn(name = "salesPersonId", referencedColumnName = "userId")
    @ManyToOne
    private SalesPerson salesPersonId;

    public Sale() {
    }

    public Sale(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public SalesPerson getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(SalesPerson salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FIT5042.carsales.repository.entities2.Sale[ saleId=" + saleId + " ]";
    }
    
}
