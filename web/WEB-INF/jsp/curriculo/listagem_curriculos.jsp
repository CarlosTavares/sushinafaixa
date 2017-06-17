<%-- 
    Document   : listagem_curriculos
    Created on : 27/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Curriculos</title>
    </head>
    <body>
        <input type="button" value="Voltar" onclick="history.back()" /><br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Email</th>
                <th>Arquivo</th>
            </tr>
            <c:forEach items="${listaCurriculo}" var="cur">
                <tr>
                    <td>${cur.id}</td>
                    <td>${cur.nome}</td>
                    <td>${cur.email}</td>
                    <td>${cur.arquivoPath}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
