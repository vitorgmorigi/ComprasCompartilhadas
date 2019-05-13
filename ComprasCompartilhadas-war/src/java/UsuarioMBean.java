/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.Usuario;
import ejb.UsuarioFachada;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 55489
 */
@ManagedBean (name = "usuarioMBean")
@SessionScoped
public class UsuarioMBean {

    @EJB
    private UsuarioFachada usuarioFachada;

    
    private Usuario usuario = new Usuario();  // Guarda os dados do formulário
    
    
    public List<Usuario> getListaUsuarios() {
        return usuarioFachada.getListaUsuarios();
    }


    /**
     * Creates a new instance of UsuarioMBean
     */
    public UsuarioMBean() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String cadastrarUsuario(){
        usuarioFachada.cadastrarUsuario(usuario);
        usuario = new Usuario();
        return "index";        
    }
    
    public String salvarUsuario() {
        usuarioFachada.salvarUsuario(this.usuario);
        return "index";
    }

    public String removerUsuario(Integer usuarioId) {
        usuarioFachada.removerUsuario(usuarioId);
        return "index";
    }

    
    

}
