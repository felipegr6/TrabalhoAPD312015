package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.ProdServer2;
import br.mack.projeto.ejb.produtos.ProdutoServer2;
import br.mack.projeto.ejb.produtos.ResultadoWS2;
import br.mack.projeto.utils.Helper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionRolledbackLocalException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@Stateless
public class ClienteWS2 implements ClienteWS2Local {

    Gson gson = new Gson();
    List<ProdutoServer2> produtos;
    ResultadoWS2 resultado;

    @EJB
    ProdServer2FacadeLocal produto;

    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    public void carregarBD() {

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(Helper.URL_INTEGRACAO_2);

        try {

            HttpResponse response = httpClient.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuilder responseString = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                responseString.append(line);
            }

            System.out.println(responseString.toString());

            resultado = gson.fromJson(responseString.toString(), ResultadoWS2.class);
            produtos = resultado.getProdutos();

            for (ProdutoServer2 p : produtos) {

                Query query = em.createQuery("SELECT COUNT(p.id) FROM ProdServer2 p WHERE p.id=:y");
                Long num;

                query.setParameter("y", p.getCodigo());
                num = (Long) query.getSingleResult();

                System.out.println(num);

                if (num == 0) {

                    ProdServer2 prod = new ProdServer2();

                    prod.setCategoria(p.getCategoria().length() > 20 ? p.getCategoria().substring(0, 20) : p.getCategoria());
                    prod.setCodigo(p.getCodigo());
                    prod.setDescricao(p.getDescricao().length() > 100 ? p.getDescricao().substring(0, 100) : p.getDescricao());
                    prod.setId(p.getId());
                    prod.setPreco(p.getPreco());

                    produto.create(prod);

                }

            }

        } catch (IOException | TransactionRolledbackLocalException ex) {
            Logger.getLogger(ClienteWS1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
