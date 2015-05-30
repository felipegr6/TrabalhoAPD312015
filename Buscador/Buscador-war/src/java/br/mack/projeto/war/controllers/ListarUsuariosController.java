package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.entities.Usuario;
import br.mack.projeto.ejb.facades.UsuarioFacadeLocal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ListarUsuariosController extends AbstractController {

    UsuarioFacadeLocal usuarioFacade = lookupUsuarioFacadeLocal();

    @Override
    public void execute() {

        List<Usuario> usuarios = usuarioFacade.findAll();

        if (usuarios.isEmpty()) {
            setReturnPage("/adm/usuario_nulo.html");
        } else {
            getRequest().setAttribute("usuarios", usuarios);
            setReturnPage("/adm/usuarios.jsp");
        }

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
