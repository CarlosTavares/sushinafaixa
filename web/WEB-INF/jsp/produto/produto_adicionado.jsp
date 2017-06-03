<%-- 
    Document   : produto_adicionado
    Created on : 28/05/2017, 00:36:17
    Author     : Carlos.Tavares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produto adicionado</title>
    </head>
    <body>
        Produto adicionado com sucesso!
        <br />
	<a href="<c:url value='/listaProduto'/>" title="Adicionar outro produto">Adicionar Produto</a>
    </body>
</html>
