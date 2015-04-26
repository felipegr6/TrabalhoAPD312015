package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Produto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProdutoFacadeLocal {

    void create(Produto produto);

    void edit(Produto produto);

    void remove(Produto produto);

    Produto find(Object id);

    List<Produto> findAll();

    List<Produto> findRange(int[] range);

    int count();

}
