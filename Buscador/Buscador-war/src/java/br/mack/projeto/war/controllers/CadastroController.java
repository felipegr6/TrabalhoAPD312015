package br.mack.projeto.war.controllers;

import br.mack.projeto.ejb.entities.Usuario;
import br.mack.projeto.ejb.facades.UsuarioFacadeLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CadastroController extends AbstractController {
    
    UsuarioFacadeLocal usuarioFacade = lookupUsuarioFacadeLocal();
    
    @Override
    public void execute() {
        
        String nome = getRequest().getParameter("nome");
        String email = getRequest().getParameter("email");
        String senha = getRequest().getParameter("senha");
        String confirmarSenha = getRequest().getParameter("confirmar_senha");
        
        Usuario usuario = new Usuario();
        
        usuario.setAtivo(1);
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTokenFb("");
        
        usuarioFacade.create(usuario);
        
        setReturnPage("/index.html");
        
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
