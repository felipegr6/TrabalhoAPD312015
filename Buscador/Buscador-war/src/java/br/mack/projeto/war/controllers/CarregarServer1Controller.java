package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.ClienteWS1Local;
import br.mack.projeto.ejb.produtos.ProdutoServer1;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CarregarServer1Controller extends AbstractController {
    
    ClienteWS1Local clienteWS1 = lookupClienteWS1Local();

    @Override
    public void execute() {

        List<ProdutoServer1> produtos = clienteWS1.carregarBD();

        clienteWS1.carregarBD().stream().map((p) -> {
            System.out.println(p.getNome());
            return p;
        }).forEach((p) -> {
            System.out.println(p.getDescricao());
        });

        setReturnPage("/adm/operacao_ok.jsp");

    }

    private ClienteWS1Local lookupClienteWS1Local() {
        try {
            Context c = new InitialContext();
            return (ClienteWS1Local) c.lookup("java:global/Buscador/Buscador-ejb/ClienteWS1!br.mack.projeto.ejb.facades.ClienteWS1Local");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}