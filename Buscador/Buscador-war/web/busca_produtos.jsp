<%@page import="java.text.NumberFormat"%>
<%@page import="br.mack.projeto.ejb.entities.ProdServer1"%>
<%@page import="java.util.List"%>
<%@page import="br.mack.projeto.ejb.entities.Oferta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Buscador</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">

            <!-- Static navbar -->
            <nav class="navbar navbar-default navbar-static-top">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Buscador</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="index.html">Home</a></li>
                            <li><a href="login.html">Login</a></li>
                            <li><a href="cadastro.html">Cadastro</a></li>
                            <!--
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            -->
                            <!--
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                            -->
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </nav>

            <div id="busca">
                <input type="text" id="texto_buscar" required autofocus/> <input type="button" class="btn" value="Buscar" onclick="buscar()"/>
            </div>
            <div id="resultado">
                <h1>Pesquisa para <%=(String) request.getAttribute("pesquisa")%></h1>
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <%
                            List<ProdServer1> ofertas = (List<ProdServer1>) request.getAttribute("ofertas");

                            for (ProdServer1 o : ofertas) {
                        %>
                        <tr>
                            <td><%=o.getNomeProduto()%></td>
                            <td><%=o.getDescProduto()%></td>
                            <td><%=NumberFormat.getCurrencyInstance().format(o.getPreco())%></td>
                            <!--<td><a href="-->
                            <!--o.getUrlOferta()%">--><!--Link da Oferta</a></td>-->
                        </tr>
                        <%
                            }
                        %>

                    </table>
                </div>
            </div>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
                    function buscar() {
                        location.href = "FrontController?control=Index&produto=" + document.getElementById("texto_buscar").value;
                    }
        </script>
    </body>
</html>
