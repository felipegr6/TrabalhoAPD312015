package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.ClienteWSLocal;
import br.mack.projeto.ejb.produtos.ProdutoServer1;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CarregarServer1Controller extends AbstractController {

    ClienteWSLocal clienteWS = lookupClienteWSLocal();

    @Override
    public void execute() {

        List<ProdutoServer1> produtos = clienteWS.carregarBD();
        
        for (ProdutoServer1 p : clienteWS.carregarBD()) {

            System.out.println(p.getNomeProduto());
            System.out.println(p.getDescProduto());

        }

        setReturnPage("/adm/index.html");

    }

    private ClienteWSLocal lookupClienteWSLocal() {

        try {

            Context c = new InitialContext();

            return (ClienteWSLocal) c.lookup("java:global/Buscador/Buscador-ejb/ClienteWS!br.mack.projeto.ejb.facades.ClienteWSLocal");

        } catch (NamingException ne) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);

        }

    }

}
