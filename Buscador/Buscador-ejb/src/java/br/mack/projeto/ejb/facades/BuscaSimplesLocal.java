package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.produtos.AbstractProduto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface BuscaSimplesLocal {

    List<AbstractProduto> findByCriteria(String produto);

    List<AbstractProduto> findByCriteriaServer1(String produto);

}
