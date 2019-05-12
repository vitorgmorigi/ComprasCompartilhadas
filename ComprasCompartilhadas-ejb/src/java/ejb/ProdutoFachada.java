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
public class ProdutoFachada {
    @PersistenceContext(unitName = "ComprasCompartilhadas-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
        // Metodo que retorna a lista de usuarios armazenada na tabela Usuario
    public List<ejb.Produto> getListaProdutos() {
        Query query = em.createNamedQuery("Produto.findAll");
        return query.getResultList();
    }
    
public int getMaxId() {  // pega o maior ID de produto na tabela
    
   Query query = em.createNativeQuery("SELECT MAX(id) FROM PRODUTO");
   BigDecimal a = (BigDecimal) query.getSingleResult();
   int b = a.intValue();
   return b;
}
 
public void cadastrarProduto(Produto produto) {  // Cadastra o produto 
   produto.setId(getMaxId()+1);
   em.persist(produto);
}
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
