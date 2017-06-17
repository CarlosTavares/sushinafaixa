<%-- 
    Document   : listagem_compras
    Created on : 16/06/2017, 15:46:49
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
        <title>Lista de Compras</title>
    </head>
    <body>
        <input type="button" value="Voltar" onclick="history.back()" /><br><br>
        <h3>Lista de Compras</h3>
        <a href="<c:url value='menuAdm'/>">Voltar ao Menu</a> <br><br>
        <spring:url value="/listaCompras" var="listaComprasUrl" />
        <form:form method="POST" action="${listaComprasUrl}" modelAttribute="status">
            <label for="status">Status: </label>
            <select name="status">
                <option value="Todos" label="Todos" />
                <c:forEach items="${statuses}" var="status">
                    <option value="${status}" label="${status.descricao}" />
                </c:forEach>
            </select>
            <input type="submit" value="Listar" />
        </form:form>
        <table>
            <tr>
                <th>Id</th>
                <th>Cliente</th>
                <th>Status</th>
                <th>Data de Compra</th>
                <th>Preço Total</th>
                <th>Endereço</th>
                <th>Forma de Pagamento</th>
                <th>Ação</th>
            </tr>
            <c:forEach items="${compras}" var="compra">
                <tr>
                    <td>${compra.id}</td>
                    <td>${compra.cliente.nome}</td>
                    <c:if test="${compra.entregue eq true}">
                        <td>Entregue</td>
                    </c:if>
                    <c:if test="${compra.entregue eq false}">
                        <td id="compra_${compra.id}">
                            Não foi Entregue! <br>
                            <a href="#" onclick="entregaAgora(${compra.id})"> Entregar agora? </a>
                        </td>
                    </c:if>
                    <td>
                        <fmt:formatDate value="${compra.data.time}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td><span >
                            <fmt:formatNumber value="${compra.precoTotal}" type="currency"/>
                        </span></td>
                    <td>${compra.endereco}</td>
                    <td>${compra.pagamento}</td>
                    <td>
                        <a href="exibeCompra?id=${compra.id}"> Consultar </a> 
                        &nbsp;
                    </td>
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/sushi.js"></script>
    </body>
</html>
