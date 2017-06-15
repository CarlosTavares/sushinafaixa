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
        <a href="<c:url value='menuAdm'/>">Voltar ao Menu</a> <br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Ação</th>
            </tr>
            <c:forEach items="${listaCategorias}" var="cat">
                <tr>
                    <td>${cat.id}</td>
                    <td>${cat.descricao}</td>
                    <td>
                        <a href="exibeCategoria?id=${cat.id}"> Alterar </a> 
                        &nbsp;
                        <a href="removeCategoria?id=${cat.id}" 
                           onclick="return confirm('Deseja realmente excluir?')" > Remover </a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
