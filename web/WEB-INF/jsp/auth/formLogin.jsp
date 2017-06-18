<%-- 
    Document   : formLogin
    Created on : 11/06/2017, 08:00:02
    Author     : Carlos.Tavares
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../comum/nav_geral.jsp" %>
<section>
    <!-- Aqui começa o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    <h3>Login</h3>
                    <div class="msgErro">${msgLoginInvalido}</div><br>
                    <form action="<c:url value='/efetuaLogin' />" method="POST">
                        Login: <input type="text" name="login" /><br><br>
                        Senha: <input type="password" name="senha" /><br><br>
                        <input type="submit" value="Entrar" />
                        <input type="button" value="Voltar" onclick="history.back()" />
                    </form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
