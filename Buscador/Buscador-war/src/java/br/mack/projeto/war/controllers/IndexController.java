package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.BuscaSimplesLocal;
import br.mack.projeto.ejb.produtos.AbstractProduto;
import java.util.Collections;
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

        String produto = this.getRequest().getParameter("produto");

        List<AbstractProduto> ofertas = buscaSimples.findByCriteria(produto);
        Collections.sort(ofertas);
        
        this.getRequest().setAttribute("pesquisa", produto);
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
