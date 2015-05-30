package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProdServer1Facade extends AbstractFacade<ProdServer1> implements ProdServer1FacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdServer1Facade() {
        super(ProdServer1.class);
    }

    @Override
    public void removeAll() {
    
        Query query = em.createQuery("DELETE from ProdServer1 p");

        query.executeUpdate();
}
    
}
