<%-- 
    Document   : carrinhoCompra
    Created on : 15/06/2017, 08:08:20
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
        <title>Carrinho de Compras</title>
    </head>
    <body>
        <fmt:setLocale value="pt_BR" scope="session"/>
        <h3>Carrinho de Compras</h3>
        <spring:url value="/carrinhoCompra" var="carrinhoCompraUrl" />

        <c:if test="${empty carrinhoForm or empty carrinhoForm.itensCarrinho}">
            <h2>Não há itens no Carrinho</h2>
            <a href="<c:url value='/listaProduto'/>">Lista de Produtos</a>
        </c:if>

        <c:if test="${not empty carrinhoForm and not empty carrinhoForm.itensCarrinho}">
            <form:form method="POST" modelAttribute="carrinhoForm"
                       action="${carrinhoCompraUrl}">
                <c:forEach items="${carrinhoForm.itensCarrinho}" var="item"
                           varStatus="varStatus">
                    <div >
                        <ul>
                            <li><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></li>
                            <li>Id do Produto: ${item.produto.id} <form:hidden
                                    path="itensCarrinho[${varStatus.index}].produto.id" />
                            </li>
                            <li>Descrição: ${item.produto.descricao}</li>
                            <li>Preço: <span >
                                    <fmt:formatNumber value="${item.produto.preco}" type="currency"/>
                                </span></li>
                            <li>Quantidade: <form:input
                                    path="itensCarrinho[${varStatus.index}].quantidade" /></li>
                            <li>Subtotal:
                                <span >
                                    <fmt:formatNumber value="${item.subTotal}" type="currency"/>
                                </span>
                            </li>
                            <li><a href="removeProdutoCarrinhoCompra?idProduto=${item.produto.id}">
                                    Remove Produto </a></li>
                        </ul>
                    </div>
                </c:forEach>
                <div style="clear: both"></div>
                <input type="submit" value="Atualiza Quantidade" />
                <a href="<c:url value='/finalizaCompra'/>">Finalizar Compra</a>
                <a href="<c:url value='/listaProduto'/>">Continuar Comprando</a>
                </form:form>
            </c:if>
    </body>
</html>
