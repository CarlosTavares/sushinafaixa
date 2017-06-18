<%-- 
    Document   : exibe_categoria
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
                    <h3>Alterar Categoria - ${categoria.id}</h3>
                    <form action="<c:url value='/alteraCategoria'/>" method="post">
                        <input type="hidden" name="id" value="${categoria.id}" />
                        Nome:           
                        <input name="descricao" value="${categoria.descricao}" />
                        <form:errors path="categoria.descricao" cssStyle="color:red"/>
                        <input type="submit" value="Alterar"/>
                        <br><br>            
                    </form>
                    <a href="<c:url value='/listaCategoria'/>">Voltar</a>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
