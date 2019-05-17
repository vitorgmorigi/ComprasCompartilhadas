/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Igor Glatz
 */
@Entity
@Table(name = "LISTA_COMPRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaCompras.findAll", query = "SELECT l FROM ListaCompras l")
    , @NamedQuery(name = "ListaCompras.findById", query = "SELECT l FROM ListaCompras l WHERE l.id = :id")})
public class ListaCompras implements Serializable {

    @JoinTable(name = "USUARIO_LISTA", joinColumns = {
        @JoinColumn(name = "ID_LISTA", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<ListaCompras> listaComprasCollection;
    @ManyToMany(mappedBy = "listaComprasCollection")
    private Collection<ListaCompras> listaComprasCollection1;

    @Size(max = 255)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaCompras")
    private Collection<UsuarioLista> usuarioListaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listaCompras")
    private Collection<ListaItem> listaItemCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
//    @Column(name = "ID_USUARIO")
//    private String idUsuario;

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

//    public String getIdUsuario() {
//        return idUsuario;
//    }
//
//    public void setIdUsuario(String idUsuario) {
//        this.idUsuario = idUsuario;
//    }

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<UsuarioLista> getUsuarioListaCollection() {
        return usuarioListaCollection;
    }

    public void setUsuarioListaCollection(Collection<UsuarioLista> usuarioListaCollection) {
        this.usuarioListaCollection = usuarioListaCollection;
    }

    @XmlTransient
    public Collection<ListaItem> getListaItemCollection() {
        return listaItemCollection;
    }

    public void setListaItemCollection(Collection<ListaItem> listaItemCollection) {
        this.listaItemCollection = listaItemCollection;
    }

    @XmlTransient
    public Collection<ListaCompras> getListaComprasCollection() {
        return listaComprasCollection;
    }

    public void setListaComprasCollection(Collection<ListaCompras> listaComprasCollection) {
        this.listaComprasCollection = listaComprasCollection;
    }

    @XmlTransient
    public Collection<ListaCompras> getListaComprasCollection1() {
        return listaComprasCollection1;
    }

    public void setListaComprasCollection1(Collection<ListaCompras> listaComprasCollection1) {
        this.listaComprasCollection1 = listaComprasCollection1;
    }
    
}
