/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author 55489
 */
@Named(value = "controladorTelas")
@RequestScoped
public class ControladorTelas {

    /**
     * Creates a new instance of ControladorTelas
     */
    public ControladorTelas() {
    }
    
    public String voltaHome()
    {
        return "index";
    }
    
}
