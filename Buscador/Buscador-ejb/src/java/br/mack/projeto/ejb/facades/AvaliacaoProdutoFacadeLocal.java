package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.AvaliacaoProduto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AvaliacaoProdutoFacadeLocal {

    void create(AvaliacaoProduto avaliacaoProduto);

    void edit(AvaliacaoProduto avaliacaoProduto);

    void remove(AvaliacaoProduto avaliacaoProduto);

    AvaliacaoProduto find(Object id);

    List<AvaliacaoProduto> findAll();

    List<AvaliacaoProduto> findRange(int[] range);

    int count();

}
