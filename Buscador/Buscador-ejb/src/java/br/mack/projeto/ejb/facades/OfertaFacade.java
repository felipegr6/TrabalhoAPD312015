package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OfertaFacade extends AbstractFacade<Oferta> implements OfertaFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OfertaFacade() {
        super(Oferta.class);
    }

    @Override
    public void removeAll() {

        Query query = em.createQuery("DELETE from Oferta o");

        query.executeUpdate();

    }

}
