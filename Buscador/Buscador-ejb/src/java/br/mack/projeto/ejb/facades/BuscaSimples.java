package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import br.mack.projeto.ejb.entities.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BuscaSimples implements BuscaSimplesLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    public List<Oferta> findByCriteria(String produto) {

        List<Oferta> ofertas = new ArrayList<>();

        TypedQuery<Produto> query = em.createNamedQuery("SELECT * FROM produto WHERE nome_produto LIKE %" + produto + "%", Produto.class);

        for (Produto p : query.getResultList()) {

            TypedQuery<Oferta> query2 = em.createNamedQuery("SELECT * FROM oferta where id_produto=" + p.getIdProduto(), Oferta.class);

            for (Oferta oferta : query2.getResultList()) {
                ofertas.add(oferta);
            }

        }

        return ofertas;

    }

}
