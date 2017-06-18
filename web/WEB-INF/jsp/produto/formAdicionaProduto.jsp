<%-- 
    Document   : formAdicionaProduto
    Created on : 22/05/2017, 00:36:17
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
                    <h3>Adicionar Produto</h3>
                    <spring:hasBindErrors name="produto">
                        <c:forEach var="error" items="${errors.allErrors}">
                            <b><spring:message message="${error}" /></b>
                            <br />
                        </c:forEach>
                    </spring:hasBindErrors>
                    <spring:url value="/adicionaProduto" var="addProdutoUrl" />
                    <form:form action="${addProdutoUrl}" method="post" modelAttribute="produto" enctype="multipart/form-data">
                        Descrição: <form:input type="text" path="descricao" /> <br /><br />
                        Preço: <form:input type="number" path="preco" /> <br /><br />
                        Imagem: <input type="file" name="imagem"/> <br /><br />

                        <label for="categoria">Categoria:</label>
                        <form:select path="categoria.id">
                            <form:option value="" label="Escolha a Categoria" />
                            <form:options items="${cats}" itemValue="id" itemLabel="descricao" />
                        </form:select>
                        <form:errors path="categoria" />
                        <br /><br />
                        <label for="administrador">Administrador:</label>
                        <form:select path="administrador.id" multiple="true">
                            <form:option value="" label="Escolha o Administrador" />
                            <form:options items="${admins}" itemValue="id" itemLabel="nome" />
                        </form:select>
                        <form:errors path="administrador" />
                        <form:button>Adicionar</form:button>
                    </form:form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>

