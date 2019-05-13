/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.ListaCompras;
import ejb.ListaComprasFachada;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author igor
 */
@ManagedBean(name = "listaComprasMBean")
@SessionScoped
public class ListaComprasMBean {
     @EJB
    private ListaComprasFachada lcFachada;

    
    private ListaCompras listaCompras = new ListaCompras();  // Guarda os dados do formulário
    
    
    public List<ListaCompras> getListasCompras() {
        return lcFachada.getListasCompras();
    }

    /**
     * Creates a new instance of ListaComprasMBean
     */
    public ListaComprasMBean() {
        
    }
    
    public ListaCompras getListaCompras(){
        return listaCompras;
    }
    
    public void setListaCompras(ListaCompras listaCompras){
        this.listaCompras = listaCompras;
    }
    
    public String criaListaCompras(){
        lcFachada.criaListaCompras(listaCompras);
        listaCompras = new ListaCompras();
        return "index";
    }
    
    public String salvaListaCompras(){
        lcFachada.salvarListaCompras(listaCompras);
        return "index";
    }
    
    public String removerListaCompras(Integer listaComprasID){
        lcFachada.removerListaCompras(listaComprasID);
        return "index";
    }
}
