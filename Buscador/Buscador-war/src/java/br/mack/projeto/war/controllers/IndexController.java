package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.entities.Oferta;
import br.mack.projeto.ejb.facades.BuscaSimplesLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class IndexController extends AbstractController {

    BuscaSimplesLocal buscaSimples = lookupBuscaSimplesLocal();

    @Override
    public void execute() {

        List<Oferta> ofertas = buscaSimples.findByCriteria(this.getRequest().getParameter("produto"));

        this.getRequest().setAttribute("ofertas", ofertas);
        this.setReturnPage("/busca_produtos.jsp");

    }

    private BuscaSimplesLocal lookupBuscaSimplesLocal() {

        try {

            Context c = new InitialContext();

            return (BuscaSimplesLocal) c.lookup("java:global/Buscador/Buscador-ejb/BuscaSimples!br.mack.projeto.ejb.facades.BuscaSimplesLocal");

        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

}
