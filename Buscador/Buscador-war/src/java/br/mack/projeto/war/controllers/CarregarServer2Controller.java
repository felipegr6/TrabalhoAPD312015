package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.ClienteWS2Local;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CarregarServer2Controller extends AbstractController {

    ClienteWS2Local clienteWS2 = lookupClienteWS2Local();

    @Override
    public void execute() {

        clienteWS2.carregarBD();
        setReturnPage("/adm/operacao_ok.jsp");

    }

    private ClienteWS2Local lookupClienteWS2Local() {

        try {

            Context c = new InitialContext();

            return (ClienteWS2Local) c.lookup("java:global/Buscador/Buscador-ejb/ClienteWS2!br.mack.projeto.ejb.facades.ClienteWS2Local");

        } catch (NamingException ne) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);

        }

    }

}
