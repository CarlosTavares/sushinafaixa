<%-- 
    Document   : exibe_administrador
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
                    <h3>Alterar Administrador - ${adm.id}</h3>
                    <form action="<c:url value='/alteraAdmin'/>" method="post">
                        <input type="hidden" name="id" value="${adm.id}" />
                        Nome:
                        <form:errors path="adm.nome" cssStyle="color:red"/>
                        <input name="nome" value="${adm.nome}" />
                        <br><br>
                        Login: ${adm.usuario.login}
                        <br><br>
                        <input type="submit" value="Alterar"/>
                        <br><br>            
                    </form>
                    <a href="<c:url value='/listaAdministradores'/>">Voltar</a>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
