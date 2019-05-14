/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 55489
 */
@Embeddable
public class UsuarioListaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LISTA")
    private int idLista;

    public UsuarioListaPK() {
    }

    public UsuarioListaPK(int idUsuario, int idLista) {
        this.idUsuario = idUsuario;
        this.idLista = idLista;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsuario;
        hash += (int) idLista;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioListaPK)) {
            return false;
        }
        UsuarioListaPK other = (UsuarioListaPK) object;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idLista != other.idLista) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.UsuarioListaPK[ idUsuario=" + idUsuario + ", idLista=" + idLista + " ]";
    }
    
}
