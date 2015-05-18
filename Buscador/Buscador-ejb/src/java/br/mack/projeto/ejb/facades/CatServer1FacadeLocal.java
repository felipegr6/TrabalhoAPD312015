package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.CatServer1;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CatServer1FacadeLocal {

    void create(CatServer1 catServer1);

    void edit(CatServer1 catServer1);

    void remove(CatServer1 catServer1);

    CatServer1 find(Object id);

    List<CatServer1> findAll();

    List<CatServer1> findRange(int[] range);

    int count();

}
