package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Avaliacao;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AvaliacaoFacade extends AbstractFacade<Avaliacao> implements AvaliacaoFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvaliacaoFacade() {
        super(Avaliacao.class);
    }

}
