package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Loja;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LojaFacadeLocal {

    void create(Loja loja);

    void edit(Loja loja);

    void remove(Loja loja);

    Loja find(Object id);

    List<Loja> findAll();

    List<Loja> findRange(int[] range);

    int count();

}
