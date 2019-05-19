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
    
    @EJB
    private ListaComprasFachada lcFachada;
    
    @EJB
    private UsuarioFachada uFachada;
    
    private UsuarioLista usuarioLista = new UsuarioLista();
     
   
//        public String criaListaCompras(Usuario usuario, ListaCompras listaCompras){
//        lcFachada.criaListaCompras(listaCompras);
//        System.out.println("ID DO USUARIO:" + usuario.getId());
//        System.out.println("ID DA LISTA:" + listaCompras.getId());
//        UsuarioLista usuarioLista = new UsuarioLista(usuario.getId(), listaCompras.getId());
////        usuarioLista.setUsuario(usuario);
////        usuarioLista.setListaCompras(listaCompras);
//        ulFachada.criaEVinculaListaAoUsuario(usuarioLista);
//        return "menu_logado";
//    }
    
    public UsuarioListaMBean() {
    }
    
    public void vinculaListaAUsuario(UsuarioLista usuarioLista){
         ulFachada.vinculaListaAoUsuario(usuarioLista);
    }
    
}
