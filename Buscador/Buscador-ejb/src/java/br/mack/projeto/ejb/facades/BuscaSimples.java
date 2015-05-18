package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import br.mack.projeto.ejb.entities.ProdServer1;
import br.mack.projeto.ejb.entities.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(mappedName = "busca")
public class BuscaSimples implements BuscaSimplesLocal {

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    public List<Oferta> findByCriteria(String produto) {

        List<Oferta> ofertas = new ArrayList<>();

        Query query = em.createQuery("SELECT p FROM Produto p WHERE p.nomeProduto LIKE :x");

        query.setParameter("x", "%" + produto + "%").setMaxResults(10);

        for (Produto p : (List<Produto>) query.getResultList()) {

            Query query2 = em.createQuery("SELECT o FROM Oferta o WHERE o.idProduto = :xyz");
            query2.setParameter("xyz", p);

            List<Oferta> ofertaList = query2.getResultList();

            for (Oferta oferta : ofertaList) {
                ofertas.add(oferta);
            }

        }

        return ofertas;

    }

    @Override
    public List<ProdServer1> findByCriteriaServer1(String produto) {

        List<ProdServer1> produtos;
        Query query = em.createQuery("SELECT p FROM ProdServer1 p WHERE p.descProduto LIKE :x");

        query.setParameter("x", "%" + produto + "%").setMaxResults(10);

        produtos = (List<ProdServer1>) query.getResultList();
        
        System.out.println(produtos.size());

        return produtos;

    }

}
