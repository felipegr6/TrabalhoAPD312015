<%@page import="br.mack.projeto.ejb.entities.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
        <title>Buscador - ADM</title>
    </head>
    <body>
        <div>
            <h1>Lista de Usuários</h1>
        </div>
        <div class="table-responsive">
            <table class="table table-bordered">
                <tr>
                    <th>Nome</th>
                    <th>E-mail</th>
                </tr>
                <%
                    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");

                    for (Usuario u : usuarios) {
                %>
                <tr>
                    <td><%=u.getNome()%></td>
                    <td><%=u.getEmail()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>