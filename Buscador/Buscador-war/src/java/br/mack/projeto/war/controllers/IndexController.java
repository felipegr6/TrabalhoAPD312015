package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.entities.Oferta;
import br.mack.projeto.ejb.entities.Produto;
import br.mack.projeto.ejb.facades.LojaFacadeLocal;
import br.mack.projeto.ejb.facades.OfertaFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class IndexController extends AbstractController {

    OfertaFacadeLocal ofertaFacade = lookupOfertaFacadeLocal();

    @Override
    public void execute() {

        List<Oferta> produtos = ofertaFacade.findAll();

        this.getRequest().setAttribute("produtos", produtos);
        this.setReturnPage("/busca_produtos.jsp");

    }

    private OfertaFacadeLocal lookupOfertaFacadeLocal() {

        try {
            Context c = new InitialContext();
            return (OfertaFacadeLocal) c.lookup("java:global/Buscador/Buscador-ejb/OfertaFacade!br.mack.projeto.ejb.facades.OfertaFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

}
