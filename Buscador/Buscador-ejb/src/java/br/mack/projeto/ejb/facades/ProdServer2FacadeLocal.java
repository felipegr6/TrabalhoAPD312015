package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer2;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProdServer2FacadeLocal {

    void create(ProdServer2 prodServer2);

    void edit(ProdServer2 prodServer2);

    void remove(ProdServer2 prodServer2);

    ProdServer2 find(Object id);

    List<ProdServer2> findAll();

    List<ProdServer2> findRange(int[] range);

    int count();
    
    void removeAll();

}
