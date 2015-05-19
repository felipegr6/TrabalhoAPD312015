package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer2;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProdServer2Facade extends AbstractFacade<ProdServer2> implements ProdServer2FacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdServer2Facade() {
        super(ProdServer2.class);
    }

    @Override
    public void removeAll() {

        Query query = em.createQuery("DELETE from ProdServer2 p");

        query.executeUpdate();

    }

}
