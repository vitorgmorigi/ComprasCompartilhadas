/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Igor Glatz
 */
@Entity
@Table(name = "LISTA_COMPRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaCompras.findAll", query = "SELECT l FROM ListaCompras l")
    , @NamedQuery(name = "ListaCompras.findById", query = "SELECT l FROM ListaCompras l WHERE l.id = :id")
    , @NamedQuery(name = "ListaCompras.findByIdUsuario", query = "SELECT l FROM ListaCompras l WHERE l.idUsuario = :idUsuario")})
public class ListaCompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ID_USUARIO")
    private String idUsuario;

    public ListaCompras() {
    }

    public ListaCompras(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaCompras)) {
            return false;
        }
        ListaCompras other = (ListaCompras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ListaCompras[ id=" + id + " ]";
    }
    
}
