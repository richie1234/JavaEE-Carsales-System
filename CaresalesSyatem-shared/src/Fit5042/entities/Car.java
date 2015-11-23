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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author Ruchitha
 */
@Entity
@Table(name = "car",uniqueConstraints={@UniqueConstraint(columnNames={"vehicleIdentificationNumber"})})
@NamedQueries({
    @NamedQuery(name = "Car.findAll", query = "SELECT c FROM Car c"),
    @NamedQuery(name = "Car.findByModelno", query = "SELECT c FROM Car c WHERE c.modelNo = :modelNo"),
    @NamedQuery(name = "Car.findByDescription", query = "SELECT c FROM Car c WHERE c.description = :description"),
    @NamedQuery(name = "Car.findByManufacturer", query = "SELECT c FROM Car c WHERE c.manufacturer = :manufacturer"),
    @NamedQuery(name = "Car.findByModelname", query = "SELECT c FROM Car c WHERE c.modelName = :modelName"),
    @NamedQuery(name = "Car.findByPreviewurl", query = "SELECT c FROM Car c WHERE c.previewURL = :previewURL"),
    @NamedQuery(name = "Car.findByThumbnail", query = "SELECT c FROM Car c WHERE c.thumbnail = :thumbnail"),
    @NamedQuery(name = "Car.findByType", query = "SELECT c FROM Car c WHERE c.type = :type"),
    @NamedQuery(name = Car.GET_ALL_QUERY_NAME, query = "SELECT c FROM Car c")})
public class Car implements Serializable {
    
    public static final String GET_ALL_QUERY_NAME = "Car.getAll";
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modelNo")
    private Integer modelNo;
    @Basic(optional = false)
    @Column(name = "vehicleIdentificationNumber")
        @Pattern(regexp="^(([a-h,A-H,j-n,J-N,p-z,P-Z,0-9]{9})([a-h,A-H,j-n,J-N,p,P,r-t,R-T,v-z,V-Z,0-9])([a-h,A-H,j-n,J-N,p-z,P-Z,0-9])(\\d{6}))$",
             message="{invalid.VIN}") 
    @NotNull
    private String vehicleIdentificationNumber;
    @Basic(optional = false)
    @Column(name = "modelName")
    @NotNull
    private String modelName;
    @Basic(optional = false)
    @Column(name = "manufacturer")
    @NotNull
    private String manufacturer;
    @Basic(optional = false)
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
    @Column(name = "thumbnail")
    @Basic(optional = false)
    @NotNull
    private String thumbnail;
    @Column(name = "description")
    @Basic(optional = false)
    @NotNull
    private String description;
    
    @Column(name = "previewURL")
        @Pattern(regexp="\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",
             message="{invalid.URL}")
    @NotNull
    private String previewURL;

    public Car() {
    }

    public Car(Integer modelNo) {
        this.modelNo = modelNo;
    }

    public Car(Integer modelNo, String vehicleIdentificationNumber, String modelName) {
        this.modelNo = modelNo;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.modelName = modelName;
    }

    public Integer getModelNo() {
        return modelNo;
    }

    public void setModelNo(Integer modelNo) {
        this.modelNo = modelNo;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }





    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (modelNo != null ? modelNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.modelNo == null && other.modelNo != null) || (this.modelNo != null && !this.modelNo.equals(other.modelNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FIT5042.carsales.repository.entities2.Car[ modelNo=" + modelNo + " ]";
    }
    
}
