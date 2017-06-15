<%-- 
    Document   : show_produto
    Created on : 28/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhe do Produto</title>
    </head>
    <body>
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
        <a href="<c:url value='/compra?idProduto=${produto.id}'/>">Adicionar ao Carrinho</a>
        <a href="<c:url value='/listaProduto'/>">Voltar</a>        
    </body>
</html>
