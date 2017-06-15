<%-- 
    Document   : confirma_compra
    Created on : 15/06/2017, 10:47:22
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
        <title>Confirmar Compra</title>
    </head>
    <body>
        <fmt:setLocale value="pt_BR" scope="session"/>
        <h3>Confirmar Compra</h3>
        <spring:url value="/confirmaCompra" var="confirmaCompraUrl" />
        <div >
            <h3>Dados do Cliente:</h3>
            <ul>
                <li>Nome:  ${meuCarrinho.cliente.nome}</li>
                <li>Address: ${meuCarrinho.endereco}</li>
            </ul>
            <h3>Compra:</h3>
            <ul>
                <li>Quantidade: ${meuCarrinho.quantidadeTotal}</li>
                <li>Preço Total:
                    <span >
                        <fmt:formatNumber value="${meuCarrinho.precoTotal}" type="currency"/>
                    </span></li>
            </ul>
        </div>

        <form method="POST" action="${confirmaCompraUrl}">
            <a href="<c:url value='/carrinhoCompra'/>">Editar Compra</a>
            <a href="<c:url value='/finalizaCompra'/>">Editar Dados de Pagamento</a>
            <input type="submit" value="Confirma" />
        </form>

        <div >

            <c:forEach items="${myCart.itensCarrinho}" var="item">
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
                        <li>Quantidade: ${itemCarrinho.quantidade}</li>
                        <li>Subtotal:
                            <span >
                                <fmt:formatNumber value="${item.subTotal}" type="currency"/>
                            </span>
                        </li>
                        </li>
                    </ul>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
