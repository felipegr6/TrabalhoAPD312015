package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
