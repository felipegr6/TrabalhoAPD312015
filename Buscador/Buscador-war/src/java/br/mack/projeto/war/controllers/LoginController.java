package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.entities.Usuario;
import br.mack.projeto.ejb.facades.UsuarioFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LoginController extends AbstractController {

    UsuarioFacadeLocal usuarioFacade = lookupUsuarioFacadeLocal();

    @Override
    public void execute() {
        
        Usuario usuario = usuarioFacade.findByName(getRequest().getParameter("email"));
        
        
    }

    private UsuarioFacadeLocal lookupUsuarioFacadeLocal() {

        try {
            Context c = new InitialContext();
            return (UsuarioFacadeLocal) c.lookup("java:global/Buscador/Buscador-ejb/UsuarioFacade!br.mack.projeto.ejb.facades.UsuarioFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }

    }

}
