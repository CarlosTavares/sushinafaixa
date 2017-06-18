<%-- 
    Document   : exibe_produto
    Created on : 28/05/2017, 01:30:00
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
                    <h3>Alterar Produto - ${produto.id}</h3>
                    <spring:hasBindErrors name="produto">
                        <c:forEach var="error" items="${errors.allErrors}">
                            <b><spring:message message="${error}" /></b>
                            <br />
                        </c:forEach>
                    </spring:hasBindErrors>
                    <spring:url value="/alteraProduto" var="altProdutoUrl" />
                    <form:form action="${altProdutoUrl}" method="post" modelAttribute="produto" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="${produto.id}" />
                        Descrição: <form:input type="text" path="descricao" /> <br /><br />
                        <form:errors path="descricao" cssStyle="color:red"/>
                        Preço: <form:input type="number" path="preco" /> <br /><br />
                        Imagem: <input type="file" name="imagem"/> <br /><br />
                        Categoria: ${produto.categoria.descricao} <br /><br />
                        <input type="hidden" name="categoria.id" value="${produto.categoria.id}" />
                        Administrador: ${produto.administrador.nome} <br /><br />
                        <input type="hidden" name="administrador.id" value="${produto.administrador.id}" />
                        <form:button>Alterar</form:button> <br /><br />
                    </form:form>
                    <a href="<c:url value='/listaProduto'/>">Voltar</a>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>

