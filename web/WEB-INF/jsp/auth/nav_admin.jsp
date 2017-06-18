<%-- 
    Document   : nav_admin
    Created on : 17/06/2017, 17:42:33
    Author     : Carlos.Tavares
--%>
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
                <li class="dropdown"><a class="dropdown-toggle" href="" data-toggle="dropdown">Compras <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="listaCompras">Listar Compras</a></li>
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
