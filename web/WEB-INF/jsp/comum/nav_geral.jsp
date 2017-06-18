<%-- 
    Document   : navigation
    Created on : 17/06/2017, 17:20:41
    Author     : Carlos.Tavares
--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                <span class="sr-only">Toggle navigation</span> 
            </button> 
            <a class="navbar-brand" href="#">SushiNaFaixa</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li class="active"><a href="formAdicionaMensagem" >Contato</a></li>
                <li class="active"><a href="formAdicionaCurriculo" >Curriculos</a></li>
                <li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Categorias <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${listaCategorias}" var="cat">
                            <li class="divider"></li>
                            <li><a href="listaProdutosByCategoria?idCategoria=${cat.id}">${cat.descricao}</a></li>
                        </c:forEach>
                    </ul>
                </li>
                <li class="active"><a href="loginForm">Logar</a></li>
                <li class="active"><a href="registra">Registrar-se</a></li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
                <div class="form-group"><input class="form-control" type="text" placeholder="Pesquisar" /></div>
                <button class="btn btn-default" type="submit">Pesquisar</button>
            </form>
        </div>
    </div>
</nav>