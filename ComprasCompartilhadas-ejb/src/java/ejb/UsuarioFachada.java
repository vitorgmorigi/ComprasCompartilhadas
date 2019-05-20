/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static ejb.Usuario_.login;
import java.math.BigDecimal;
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
public class UsuarioFachada {

    @PersistenceContext(unitName = "ComprasCompartilhadas-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Metodo que retorna a lista de usuarios armazenada na tabela Usuario
    public List<ejb.Usuario> getListaUsuarios() {
        Query query = em.createNamedQuery("Usuario.findAll");
        return query.getResultList();
    }

    public int getMaxId() {  // pega o maior ID de usuário na tabela

        Query query = em.createNativeQuery("SELECT MAX(id) FROM USUARIO");
        BigDecimal a = (BigDecimal) query.getSingleResult();
        if (a != null) {
            return a.intValue();
        } else {
            return 0;
        }

    }

    public void cadastrarUsuario(Usuario usuario) {  // Cadastra o usuario 
        usuario.setId(getMaxId() + 1);
        em.persist(usuario);
    }

    public void salvarUsuario(Usuario usuario) {
        em.merge(usuario);
        em.flush();
    }

    public void removerUsuario(Integer usuarioId) {
        em.remove(em.find(Usuario.class, usuarioId));
    }

    public Usuario getUsuario(String login, String senha) {

        try {
            Usuario usuario = (Usuario) em.createQuery(
            "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
         .setParameter("login", login)
                    .setParameter("senha", senha).getSingleResult();

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Usuario getUsuarioById(Integer id) {

        try {
            Usuario usuario = (Usuario) em.createQuery(
            "SELECT u FROM Usuario u WHERE u.id = :id ")
         .setParameter("id", id);

            return usuario;
        } catch (NoResultException e) {
            return null;
        }
    }
}
