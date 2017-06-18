<%-- 
    Document   : produto_adicionado
    Created on : 28/05/2017, 00:36:17
    Author     : Carlos.Tavares
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../auth/nav_admin.jsp" %>
<section>
    <!-- Aqui come�a o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    Produto adicionado com sucesso!
                    <br />
                    <a href="<c:url value='formAdicionaProduto'/>" title="Adicionar outro produto">Adicionar Produto</a>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>

