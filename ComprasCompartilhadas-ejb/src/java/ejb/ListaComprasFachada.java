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

/**
 *
 * @author Igor Glatz
 */
@Stateless
@LocalBean
public class ListaComprasFachada {
 @PersistenceContext(unitName = "ComprasCompartilhadas-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
        // Metodo que retorna a lista de compras armazenada na tabela ListaCompras
    public List<ejb.ListaCompras> getListasCompras() {
        Query query = em.createNamedQuery("ListaCompras.findAll");
        return query.getResultList();
    }
    
    public int getMaxId() {  // pega o maior ID de lista de compras na tabela

       Query query = em.createNativeQuery("SELECT MAX(id) FROM LISTA_COMPRAS");
       BigDecimal a = (BigDecimal) query.getSingleResult();
       int b = a.intValue();
       return b;
    }
 
    public void criaListaCompras(ListaCompras listaCompras) {  // Cadastra o produto 
       listaCompras.setId(getMaxId()+1);
       em.persist(listaCompras);
    }

    public void salvarListaCompras(ListaCompras listaCompras) {
        em.merge(listaCompras);
        em.flush();
    }

    public void removerListaCompras(Integer listaComprasID) {
            em.remove(em.find(ListaCompras.class, listaComprasID));
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
