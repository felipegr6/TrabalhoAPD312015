package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.AvaliacaoProduto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AvaliacaoProdutoFacade extends AbstractFacade<AvaliacaoProduto> implements AvaliacaoProdutoFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvaliacaoProdutoFacade() {
        super(AvaliacaoProduto.class);
    }

}
