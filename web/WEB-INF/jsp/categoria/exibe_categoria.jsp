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
        <title>Alterar Categoria</title>
    </head>
    <body>
        <h3>Alterar Categoria - ${categoria.id}</h3>
        <form action="<c:url value='/alteraCategoria'/>" method="post">
            <input type="hidden" name="id" value="${categoria.id}" />
            Nome:           
            <input name="descricao" value="${categoria.descricao}" />
            <form:errors path="categoria.descricao" cssStyle="color:red"/>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/listaCategoria'/>">Voltar</a>
    </body>
</html>
