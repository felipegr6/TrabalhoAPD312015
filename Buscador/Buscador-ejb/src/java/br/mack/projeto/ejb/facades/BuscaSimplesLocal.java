package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BuscaSimplesLocal {

    List<Oferta> findByCriteria(String produto);

}
