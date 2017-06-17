<%-- 
    Document   : exibe_compra
    Created on : 16/06/2017, 16:53:35
    Author     : Carlos.Tavares
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta Compra</title>
    </head>
    <body>
    <fmt:setLocale value="pt_BR" scope="session"/>
    <h3>Confirmar Compra</h3>
    <spring:url value="/confirmaCompra" var="confirmaCompraUrl" />
    <div >
        <h3>Dados do Cliente:</h3>
        <ul>
            <li>Nome:  ${compra.cliente.nome}</li>
            <li>Address: ${compra.endereco}</li>
        </ul>
        <h3>Compra:</h3>
        <ul>
            <li>Preço Total:
                <span >
                    <fmt:formatNumber value="${compra.precoTotal}" type="currency"/>
                </span></li>
        </ul>
        <h3>Itens: </h3>
        <c:forEach items="${compra.itens}" var="item">
            <div >
                <ul>
                    <li><img src="${item.produto.imagemPath}" width="25px" alt="${item.produto.descricao}" /></li>
                    <li>Id do Produto: ${item.produto.id}</li>
                    <li>Descrição: ${item.produto.descricao}</li>
                    <li>Preço: <span >
                            <fmt:formatNumber value="${item.produto.preco}" type="currency"/>
                        </span></li>
                    <li>Quantidade: ${item.quantidade}</li>
                    <li>Subtotal:
                        <span >
                            <fmt:formatNumber value="${item.preco}" type="currency"/>
                        </span>
                    </li>
                    </li>
                </ul>
            </div>
        </c:forEach>

    </div>
</body>
</html>
