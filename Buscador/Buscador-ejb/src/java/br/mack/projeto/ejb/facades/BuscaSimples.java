package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer1;
import br.mack.projeto.ejb.entities.ProdServer2;
import br.mack.projeto.ejb.produtos.AbstractProduto;
import br.mack.projeto.ejb.produtos.ProdutoServer1;
import br.mack.projeto.ejb.produtos.ProdutoServer2;
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
    public List<AbstractProduto> findByCriteria(String produto) {

        List<AbstractProduto> result = new ArrayList<>();;

        List<ProdServer1> produtos1;
        List<ProdServer2> produtos2;

        Query q1 = em.createQuery("SELECT p FROM ProdServer1 p WHERE p.descProduto LIKE :x OR p.nomeProduto LIKE :x");
        q1.setParameter("x", "%" + produto + "%").setMaxResults(10);
        produtos1 = (List<ProdServer1>) q1.getResultList();

        Query q2 = em.createQuery("SELECT p FROM ProdServer2 p WHERE p.descricao LIKE :x");
        q2.setParameter("x", "%" + produto + "%").setMaxResults(10);
        produtos2 = (List<ProdServer2>) q2.getResultList();

        for (ProdServer1 p : produtos1) {
            result.add(new ProdutoServer1(p.getNomeProduto(), p.getDescProduto(), p.getPreco()));
        }

        for (ProdServer2 p : produtos2) {
            result.add(new ProdutoServer2(p.getDescricao(), p.getPreco()));
        }

        return result;

        /*
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
         */
    }

    @Override
    public List<AbstractProduto> findByCriteriaServer1(String produto) {

        List<ProdServer1> produtos;
        List<AbstractProduto> result;

        Query query = em.createQuery("SELECT p FROM ProdServer1 p WHERE p.descProduto LIKE :x OR p.nomeProduto LIKE :x");

        query.setParameter("x", "%" + produto + "%").setMaxResults(10);

        produtos = (List<ProdServer1>) query.getResultList();
        result = new ArrayList<>();

        for (ProdServer1 p : produtos) {
            result.add(new ProdutoServer1(p.getNomeProduto(), p.getDescProduto(), p.getPreco()));
        }

        System.out.println(produtos.size());

        return result;

    }

}
