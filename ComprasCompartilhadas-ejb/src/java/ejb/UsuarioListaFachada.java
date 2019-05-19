/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
    

    
    public void criaEVinculaListaAoUsuario(UsuarioLista usuarioLista)
    {
        em.persist(usuarioLista);
    }
    
    
        
    
        
        
}
