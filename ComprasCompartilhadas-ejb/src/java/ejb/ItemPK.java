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
 * @author Igor Glatz
 */
@Embeddable
public class ItemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LISTA")
    private int idLista;

    public ItemPK() {
    }

    public ItemPK(int id, int idLista) {
        this.id = id;
        this.idLista = idLista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash += (int) id;
        hash += (int) idLista;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPK)) {
            return false;
        }
        ItemPK other = (ItemPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.idLista != other.idLista) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.ItemPK[ id=" + id + ", idLista=" + idLista + " ]";
    }
    
}
