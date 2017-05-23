<%-- 
    Document   : listagem_mensagens
    Created on : 22/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Clientes</title>
    </head>
    <body>
        <a href="<c:url value='/index'/>">Voltar</a> <br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Endereço</th>
                <th>Ação</th>
            </tr>
            <c:forEach items="${listaClientes}" var="clt">
                <tr>
                    <td>${clt.id}</td>
                    <td>${clt.nome}</td>
                    <td>${clt.cpf}</td>
                    <td>${clt.endereco}</td>
                    <td>
                        <a href="exibeCliente?id=${clt.id}"> Alterar </a> 
                        &nbsp;
                        <a href="removeCliente?id=${clt.id}" 
                           onclick="return confirm('Deseja realmente excluir?')" > Remover </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
