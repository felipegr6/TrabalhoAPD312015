package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario findByName(String name) {
        
        TypedQuery<Usuario> tq = em.createQuery("select u from Usuario u where u.nome = :nome", Usuario.class);
        tq.setParameter("nome", name);
        
        return tq.getSingleResult();
        
    }

}
