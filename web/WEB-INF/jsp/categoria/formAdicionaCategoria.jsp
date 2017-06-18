<%-- 
    Document   : formRegistro
    Created on : 10/06/2017, 16:01:25
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
                    <h3>Adicionar Categoria</h3>
                    <form action="<c:url value='/adicionaCategoria' />" method="post">
                        Descrição: <input type="text" name="descricao" /> <br /><br />
                        <input type="submit" value="Adicionar">
                    </form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>