<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Produto</title>
    </head>
    <body>
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
    </body>
</html>
