package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.produtos.ProdutoServer1;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ClienteWS1Local {

    List<ProdutoServer1> carregarBD();

}
