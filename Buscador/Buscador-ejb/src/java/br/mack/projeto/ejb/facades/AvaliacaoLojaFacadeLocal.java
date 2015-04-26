package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.AvaliacaoLoja;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AvaliacaoLojaFacadeLocal {

    void create(AvaliacaoLoja avaliacaoLoja);

    void edit(AvaliacaoLoja avaliacaoLoja);

    void remove(AvaliacaoLoja avaliacaoLoja);

    AvaliacaoLoja find(Object id);

    List<AvaliacaoLoja> findAll();

    List<AvaliacaoLoja> findRange(int[] range);

    int count();

}
