/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.controller;

import Fit5042.model.CarFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ruchitha
 */
@ManagedBean
@SessionScoped
public class CarController {
    @EJB
    private CarFacade carFacade;

    
    public CarController() {
    }
    
    
    public List<Fit5042.entities.Car> findAll(){
    
        return this.carFacade.findAll();
    }
    
    
}
