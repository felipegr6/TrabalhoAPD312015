package br.mack.projeto.ejb.facades;

import br.mack.projeto.ejb.produtos.CategoriaServer1;
import br.mack.projeto.ejb.produtos.ProdutoServer1;
import br.mack.projeto.utils.Helper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@Stateless
public class ClienteWS implements ClienteWSLocal {

    Gson gson = new Gson();
    List<ProdutoServer1> produtos;

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
                
            }
            
            return produtos;

        } catch (IOException ex) {
            Logger.getLogger(ClienteWS.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

}
