/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 55489
 */
@Entity
@Table(name = "USUARIO_LISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioLista.findAll", query = "SELECT u FROM UsuarioLista u")
    , @NamedQuery(name = "UsuarioLista.findByIdUsuario", query = "SELECT u FROM UsuarioLista u WHERE u.usuarioListaPK.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuarioLista.findByIdLista", query = "SELECT u FROM UsuarioLista u WHERE u.usuarioListaPK.idLista = :idLista")})
public class UsuarioLista implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioListaPK usuarioListaPK;
    @JoinColumn(name = "ID_LISTA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ListaCompras listaCompras;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioLista() {
    }

    public UsuarioLista(UsuarioListaPK usuarioListaPK) {
        this.usuarioListaPK = usuarioListaPK;
    }

    public UsuarioLista(int idUsuario, int idLista) {
        this.usuarioListaPK = new UsuarioListaPK(idUsuario, idLista);
    }

    public UsuarioListaPK getUsuarioListaPK() {
        return usuarioListaPK;
    }

    public void setUsuarioListaPK(UsuarioListaPK usuarioListaPK) {
        this.usuarioListaPK = usuarioListaPK;
    }

    public ListaCompras getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ListaCompras listaCompras) {
        this.listaCompras = listaCompras;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioListaPK != null ? usuarioListaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioLista)) {
            return false;
        }
        UsuarioLista other = (UsuarioLista) object;
        if ((this.usuarioListaPK == null && other.usuarioListaPK != null) || (this.usuarioListaPK != null && !this.usuarioListaPK.equals(other.usuarioListaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.UsuarioLista[ usuarioListaPK=" + usuarioListaPK + " ]";
    }
    
}
