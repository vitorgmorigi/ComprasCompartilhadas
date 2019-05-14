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
public class ListaItemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LISTA")
    private int idLista;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ITEM")
    private int idItem;

    public ListaItemPK() {
    }

    public ListaItemPK(int idLista, int idItem) {
        this.idLista = idLista;
        this.idItem = idItem;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLista;
        hash += (int) idItem;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaItemPK)) {
            return false;
        }
        ListaItemPK other = (ListaItemPK) object;
        if (this.idLista != other.idLista) {
            return false;
        }
        if (this.idItem != other.idItem) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ListaItemPK[ idLista=" + idLista + ", idItem=" + idItem + " ]";
    }
    
}
