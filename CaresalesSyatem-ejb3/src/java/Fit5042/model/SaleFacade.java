/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fit5042.model;

import Fit5042.entities.Sale;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ruchitha
 */
@Stateless
public class SaleFacade extends AbstractFacade<Sale> {
    @PersistenceContext(unitName = "ZCaresalesSyatem-ejb3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SaleFacade() {
        super(Sale.class);
    }
    
}
