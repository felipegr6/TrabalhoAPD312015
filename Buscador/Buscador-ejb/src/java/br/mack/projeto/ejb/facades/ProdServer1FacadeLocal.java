package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer1;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProdServer1FacadeLocal {

    void create(ProdServer1 prodServer1);

    void edit(ProdServer1 prodServer1);

    void remove(ProdServer1 prodServer1);

    ProdServer1 find(Object id);

    List<ProdServer1> findAll();

    List<ProdServer1> findRange(int[] range);

    int count();
    
}
