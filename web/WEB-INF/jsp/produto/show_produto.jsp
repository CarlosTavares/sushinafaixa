<%-- 
    Document   : show_produto
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
                    <h3>Detalhe do Produto</h3>
                    <spring:hasBindErrors name="produto">
                        <c:forEach var="error" items="${errors.allErrors}">
                            <b><spring:message message="${error}" /></b>
                            <br />
                        </c:forEach>
                    </spring:hasBindErrors>
                    Descrição: ${produto.descricao}<br /><br />
                    Preço: 
                    <span >
                        <fmt:formatNumber value="${produto.preco}" type="currency"/>
                    </span>
                    <br /><br />
                    Imagem: <figure><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></figure><br /><br />
                    <a href="<c:url value='/compraProduto?idProduto=${produto.id}'/>">Adicionar ao Carrinho</a>
                    <a href="<c:url value='/listaProduto'/>">Voltar</a>        
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>

