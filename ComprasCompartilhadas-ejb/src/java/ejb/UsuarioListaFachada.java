/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 55489
 */
@Stateless
@LocalBean
public class UsuarioListaFachada {

    @PersistenceContext(unitName = "ComprasCompartilhadas-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    

    
    public void vinculaListaAoUsuario(UsuarioLista usuarioLista)
    {
        em.persist(usuarioLista);
    }
    
    public List<ListaCompras> getListasUsuario(Integer idUsuario)
    {
        Query query = em.createQuery("SELECT l.id, l.nome FROM UsuarioLista u JOIN ListaCompras l ON u.usuarioListaPK.idLista = l.id WHERE u.usuarioListaPK.idUsuario = :idUsuario")
                .setParameter("idUsuario", idUsuario);
        
        List<ListaCompras> result = query.getResultList();
        return result;
    }
    
    
        
    
        
        
}
