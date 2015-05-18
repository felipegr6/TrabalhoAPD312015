package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.entities.CatServer1;
import br.mack.projeto.ejb.entities.ProdServer1;
import br.mack.projeto.ejb.produtos.ProdutoServer1;
import br.mack.projeto.utils.Helper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
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
public class ClienteWS implements ClienteWSLocal {

    Gson gson = new Gson();
    List<ProdutoServer1> produtos;

    @EJB
    CatServer1FacadeLocal categoria;
    @EJB
    ProdServer1FacadeLocal produto;
    @PersistenceContext(unitName = "Buscador-ejbPU")
    private EntityManager em;

    @Override
    public List<ProdutoServer1> carregarBD() {

        HttpClient httpClient = new DefaultHttpClient();
        HttpGet request = new HttpGet(Helper.URL_INTEGRACAO_1);

        try {

            HttpResponse response = httpClient.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuilder responseString = new StringBuilder();
            String line;

            while ((line = rd.readLine()) != null) {
                responseString.append(line);
            }

            System.out.println(responseString.toString());
            Type collectionType = new TypeToken<List<ProdutoServer1>>() {
            }.getType();
            produtos = (List<ProdutoServer1>) gson.fromJson(responseString.toString(), collectionType);

            for (ProdutoServer1 p : produtos) {

                Query q1 = em.createQuery("SELECT COUNT(c.codCategoria) FROM CatServer1 c WHERE c.codCategoria=:x");
                q1.setParameter("x", p.getCodCategoria().getCodCategoria());

                Long n1 = (Long) q1.getSingleResult();
                System.out.println(n1);

                if (n1 == 0) {

                    CatServer1 cat = new CatServer1();

                    cat.setCodCategoria(p.getCodCategoria().getCodCategoria());
                    cat.setNomeCategoria(p.getCodCategoria().getNomeCategoria());

                    categoria.create(cat);

                }

                Query q2 = em.createQuery("SELECT COUNT(p.codProduto) FROM ProdServer1 p WHERE p.codProduto=:y");
                q2.setParameter("y", p.getCodProduto());
                Long n2 = (Long) q2.getSingleResult();

                System.out.println(n2);

                if (n2 == 0) {

                    ProdServer1 prod = new ProdServer1();

                    prod.setCodProduto(p.getCodProduto());
                    prod.setNomeProduto(p.getNomeProduto().length() > 50 ? p.getNomeProduto().substring(50) : p.getNomeProduto());
                    prod.setImgProduto(p.getImgProduto().length() > 50 ? p.getImgProduto().substring(50) : p.getImgProduto());
                    prod.setDescProduto(p.getDescProduto().length() > 200 ? p.getDescProduto().substring(200) : p.getDescProduto());
                    prod.setPreco(p.getPreco());

                    produto.create(prod);

                }

            }

            return produtos;

        } catch (IOException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<ProdutoServer1>();
        } catch (TransactionRolledbackLocalException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<ProdutoServer1>();
        }

    }

}
