<%-- 
    Document   : formAdicionaAdmin
    Created on : 22/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../auth/nav_admin.jsp" %>
<section>
    <!-- Aqui começa o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    <h3>Adicionar Administrador</h3>
                    <form action="<c:url value='/adicionaAdministrador' />" method="post">
                        Nome: <input type="text" name="nome" /> <br /><br />
                        Login: <input type="text" name="usuario.login" /> <br /><br />
                        Senha: <input type="password" name="usuario.senha" /> <br /><br />
                        <input type="submit" value="Adicionar">
                    </form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
