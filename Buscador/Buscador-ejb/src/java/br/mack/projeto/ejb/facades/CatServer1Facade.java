package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.CatServer1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CatServer1Facade extends AbstractFacade<CatServer1> implements CatServer1FacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CatServer1Facade() {
        super(CatServer1.class);
    }

    @Override
    public void removeAll() {

        Query query = em.createQuery("DELETE from CatServer1 c");

        query.executeUpdate();

    }

}
