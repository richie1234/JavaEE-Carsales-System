/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller.salesperson;

import Fit5042.entities.Type;

/**
 *
 * @author Ruchitha
 */
public class CarSearchValidation {

    private Integer modelNo;

    private String modelName;

    private String manufacturer;

    private Type type;

    public Integer getModelNo() {
        return modelNo;
    }

    public void setModelNo(Integer modelNo) {
        this.modelNo = modelNo;
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



    
    
}
