<%-- 
    Document   : menuAdm
    Created on : 12/06/2017, 15:36:18
    Author     : Carlos.Tavares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
        <title>Sushi Na Faixa</title>
    </head>

    <body>
    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                    <span class="sr-only">Toggle navigation</span> 
                </button> 
                <a class="navbar-brand" href="#">SushiNaFaixa</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li class="dropdown"><a class="dropdown-toggle" href="" data-toggle="dropdown">Categorias <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="formAdicionaCategoria">Nova Categoria</a></li>
                            <li class="divider"></li>
                            <li><a href="listaCategoria">Listar Categorias</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Produtos<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="formAdicionaProduto">Novo Produto</a></li>
                            <li class="divider"></li>
                            <li><a href="listaProduto">Listar Produtos</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Mensagens<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="listaMensagens">Listar Mensagens</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Curriculos<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="listaCurriculo">Listar Curriculos</a></li>
                        </ul>
                    </li>
                    <li><a href="logout">Sair</a></li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group"><input class="form-control" type="text" placeholder="Pesquisar" /></div>
                    <button class="btn btn-default" type="submit">Pesquisar</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container -->
    </nav> <!-- Fim do menu superior -->
    <!-- Aqui começa o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9"></div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
    <footer> <!-- Aqui e a area do footer -->
        <div class="container">
            <div class="row">
                <div id="linksImportantes" class="col-md-3"></div> <!-- Aqui e a area dos links importantes -->
                <div id="redesSociais" class="col-md-3"></div> <!-- Aqui e a area das redes sociais -->
                <div id="logoFooter" class="col-md-offset-3 col-md-3"></div> <!-- Aqui e a area da logo do rodape -->
            </div>
        </div>
    </footer>
    <script type="text/javascript" src="resources/js/jquery.js"></script>
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</body>
</html>

