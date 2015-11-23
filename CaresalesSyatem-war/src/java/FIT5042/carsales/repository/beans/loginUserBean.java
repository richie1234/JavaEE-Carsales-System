/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FIT5042.carsales.repository.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ruchitha
 */
@ManagedBean
@RequestScoped
public class loginUserBean {
    
    private String name;
    private String password;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String setSaveUser() {
        System.out.println("1");
        
//        return "show";
        return null;
    }
    
    
}
