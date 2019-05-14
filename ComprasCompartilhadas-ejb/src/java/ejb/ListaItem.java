/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 55489
 */
@Entity
@Table(name = "LISTA_ITEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaItem.findAll", query = "SELECT l FROM ListaItem l")
    , @NamedQuery(name = "ListaItem.findByIdLista", query = "SELECT l FROM ListaItem l WHERE l.listaItemPK.idLista = :idLista")
    , @NamedQuery(name = "ListaItem.findByIdItem", query = "SELECT l FROM ListaItem l WHERE l.listaItemPK.idItem = :idItem")
    , @NamedQuery(name = "ListaItem.findByQuantidade", query = "SELECT l FROM ListaItem l WHERE l.quantidade = :quantidade")})
public class ListaItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListaItemPK listaItemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @JoinColumn(name = "ID_ITEM", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "ID_LISTA", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ListaCompras listaCompras;

    public ListaItem() {
    }

    public ListaItem(ListaItemPK listaItemPK) {
        this.listaItemPK = listaItemPK;
    }

    public ListaItem(ListaItemPK listaItemPK, int quantidade) {
        this.listaItemPK = listaItemPK;
        this.quantidade = quantidade;
    }

    public ListaItem(int idLista, int idItem) {
        this.listaItemPK = new ListaItemPK(idLista, idItem);
    }

    public ListaItemPK getListaItemPK() {
        return listaItemPK;
    }

    public void setListaItemPK(ListaItemPK listaItemPK) {
        this.listaItemPK = listaItemPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public ListaCompras getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(ListaCompras listaCompras) {
        this.listaCompras = listaCompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listaItemPK != null ? listaItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaItem)) {
            return false;
        }
        ListaItem other = (ListaItem) object;
        if ((this.listaItemPK == null && other.listaItemPK != null) || (this.listaItemPK != null && !this.listaItemPK.equals(other.listaItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ListaItem[ listaItemPK=" + listaItemPK + " ]";
    }
    
}
