<%-- 
    Document   : finaliza_compra
    Created on : 15/06/2017, 10:18:03
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
        <title>Finalizar Compra</title>
    </head>
    <body>
        <h3>Dados de Pagamento</h3>
        <spring:url value="/finalizaCompra" var="finalizaCompraUrl" />
        <form:form method="POST" action="${finalizaCompraUrl}" modelAttribute="carrinhoForm">
            <table>
                <tr>
                    <td>Endereço: </td>
                    <td><form:input type="text" path="endereco" /></td>
                </tr>
                <tr>
                    <td>Forma de Pagamento: </td>
                    <td><form:select path="pagamento">
                            <form:option value="" label="Forma de Pagamento" />
                            <form:option value="DINHEIRO" label="Dinheiro" />
                            <form:option value="CARTAO" label="Cartão de Crédito" />
                        </form:select></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Confirma" /> <input type="reset"
                                                                        value="Reset" /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
