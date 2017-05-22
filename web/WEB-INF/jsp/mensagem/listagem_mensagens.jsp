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
        <title>Listagem de Mensagens</title>
    </head>
    <body>
        <a href="<c:url value='/index'/>">Voltar</a> <br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Assunto</th>
                <th>Conteudo</th>
            </tr>
            <c:forEach items="${listaMensagens}" var="msg">
                <tr>
                    <td>${msg.id}</td>
                    <td>${msg.motivo}</td>
                    <td>${msg.conteudo}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
