package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.Oferta;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OfertaFacadeLocal {

    void create(Oferta oferta);

    void edit(Oferta oferta);

    void remove(Oferta oferta);

    Oferta find(Object id);

    List<Oferta> findAll();

    List<Oferta> findRange(int[] range);

    int count();
    
    void removeAll();

}
