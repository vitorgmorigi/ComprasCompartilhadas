/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.ListaCompras;
import ejb.ListaComprasFachada;
import ejb.Usuario;
import ejb.UsuarioFachada;
import ejb.UsuarioLista;
import ejb.UsuarioListaFachada;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author 55489
 */
@Named(value = "usuarioListaMBean")
@SessionScoped
public class UsuarioListaMBean implements Serializable {

    @EJB
    private UsuarioListaFachada ulFachada;
    
    private UsuarioLista usuarioLista = new UsuarioLista();
     
    
    public UsuarioListaMBean() {
    }
    
    public void vinculaListaAUsuario(UsuarioLista usuarioLista){
         ulFachada.vinculaListaAoUsuario(usuarioLista);
    }
    
        public List<ListaCompras> getListasUsuario(Integer idUsuario) {
        return ulFachada.getListasUsuario(idUsuario);
    }
    
}
