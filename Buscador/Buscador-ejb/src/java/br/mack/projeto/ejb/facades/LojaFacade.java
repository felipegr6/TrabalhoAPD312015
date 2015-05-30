package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Loja;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LojaFacade extends AbstractFacade<Loja> implements LojaFacadeLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LojaFacade() {
        super(Loja.class);
    }

}
