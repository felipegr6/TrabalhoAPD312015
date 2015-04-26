package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Avaliacao;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AvaliacaoFacadeLocal {

    void create(Avaliacao avaliacao);

    void edit(Avaliacao avaliacao);

    void remove(Avaliacao avaliacao);

    Avaliacao find(Object id);

    List<Avaliacao> findAll();

    List<Avaliacao> findRange(int[] range);

    int count();

}
