package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.AvaliacaoLoja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AvaliacaoLojaFacade extends AbstractFacade<AvaliacaoLoja> implements AvaliacaoLojaFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvaliacaoLojaFacade() {
        super(AvaliacaoLoja.class);
    }

}
