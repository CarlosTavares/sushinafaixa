<%-- 
    Document   : exibe_produto
    Created on : 28/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Produto</title>
    </head>
    <body>
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
    </body>
</html>
