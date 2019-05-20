/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 *
 * @author matheus
 */
@Stateless
@LocalBean
public class ItemFachada {
    @PersistenceContext (name = "ShoppingList-ejbPU") 
    EntityManager em;
  
    public List<Item> getListaItens() {
        Query query = em.createNamedQuery("Item.findAll");
        return query.getResultList();
    }
    
    public int getMaxId() {
        Query query = em.createNativeQuery("SELECT MAX(id) FROM ITEM");
        BigDecimal result = (BigDecimal) query.getSingleResult();
        
        if (result != null) {
            return result.intValue();
        } else {
            return 0;
        }
    }
    
    public void salvarItem(Item item) {
        try {
            em.merge(item);
            em.flush();
        }catch (ConstraintViolationException e) {
            for(ConstraintViolation cv: e.getConstraintViolations()) {
                System.out.println(cv.toString());
            }
         }
    }

    public void cadastrarItem(ListaCompras lista, Item item) {
        int id = this.getMaxId() + 1;
        item.setItemPK(new ItemPK(id, lista.getId()));
        item.setListaCompras(lista);
        try {
            em.persist(item);
            em.flush();
            lista.getItemCollection().add(item);
        } catch (ConstraintViolationException e) {
            for(ConstraintViolation cv: e.getConstraintViolations()) {
                System.out.println(cv.toString());
            }
         }
        em.merge(lista);
    }
    
    public void removerItem(ListaCompras lista, Item item) {
        em.remove(em.find(Item.class, item.getItemPK()));
        em.flush();
        lista.getItemCollection().remove(item);
        em.merge(lista);
    }
}
