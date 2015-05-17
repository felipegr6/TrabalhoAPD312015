package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.OfertaFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LimparBancoController extends AbstractController {

    OfertaFacadeLocal ofertaFacade = lookupOfertaFacadeLocal();

    @Override
    public void execute() {

        ofertaFacade.removeAll();

        this.setReturnPage("/adm/index.html");

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
