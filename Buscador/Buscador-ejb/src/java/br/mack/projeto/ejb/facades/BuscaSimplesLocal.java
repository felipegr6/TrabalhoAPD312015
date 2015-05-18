package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import br.mack.projeto.ejb.entities.ProdServer1;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface BuscaSimplesLocal {

    List<Oferta> findByCriteria(String produto);

    List<ProdServer1> findByCriteriaServer1(String produto);

}
