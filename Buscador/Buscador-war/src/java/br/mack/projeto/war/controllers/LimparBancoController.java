package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.facades.CatServer1FacadeLocal;
import br.mack.projeto.ejb.facades.OfertaFacadeLocal;
import br.mack.projeto.ejb.facades.ProdServer1FacadeLocal;
import br.mack.projeto.ejb.facades.ProdServer2FacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LimparBancoController extends AbstractController {

    CatServer1FacadeLocal catServer1Facade = lookupCatServer1FacadeLocal();
    ProdServer2FacadeLocal prodServer2Facade = lookupProdServer2FacadeLocal();
    ProdServer1FacadeLocal prodServer1Facade = lookupProdServer1FacadeLocal();
    OfertaFacadeLocal ofertaFacade = lookupOfertaFacadeLocal();

    @Override
    public void execute() {

        ofertaFacade.removeAll();
        catServer1Facade.removeAll();
        prodServer1Facade.removeAll();
        prodServer2Facade.removeAll();

        this.setReturnPage("/adm/operacao_ok.jsp");

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

    private ProdServer1FacadeLocal lookupProdServer1FacadeLocal() {

        try {
            Context c = new InitialContext();
            return (ProdServer1FacadeLocal) c.lookup("java:global/Buscador/Buscador-ejb/ProdServer1Facade!br.mack.projeto.ejb.facades.ProdServer1FacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

    private ProdServer2FacadeLocal lookupProdServer2FacadeLocal() {

        try {
            Context c = new InitialContext();
            return (ProdServer2FacadeLocal) c.lookup("java:global/Buscador/Buscador-ejb/ProdServer2Facade!br.mack.projeto.ejb.facades.ProdServer2FacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

    private CatServer1FacadeLocal lookupCatServer1FacadeLocal() {

        try {
            Context c = new InitialContext();
            return (CatServer1FacadeLocal) c.lookup("java:global/Buscador/Buscador-ejb/CatServer1Facade!br.mack.projeto.ejb.facades.CatServer1FacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

}
