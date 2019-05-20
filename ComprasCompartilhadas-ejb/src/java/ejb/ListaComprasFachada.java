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
       if (a != null) {
            return a.intValue();
        } else {
            return 0;
        }
    }
    
    public ListaCompras getListaByNome(String nome){
        Query query = em.createNamedQuery("ListaCompras.findByNome");
        query.setParameter(":nome", nome);
        ListaCompras lc = (ListaCompras)query.getSingleResult();
        return lc;
    }
 
    public void criaListaCompras(Usuario usuario, ListaCompras listaCompras) {  // Cadastra o produto 
       usuario.getListaComprasCollection().add(listaCompras);
       em.persist(listaCompras);
    }

    public void salvarListaCompras(ListaCompras listaCompras) {
        em.merge(listaCompras);
        em.flush();
    }

    public void removerListaCompras(String nome) {
        em.remove(em.find(ListaCompras.class, nome));
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
