<%-- 
    Document   : curriculo_adicionada
    Created on : 27/05/2017, 00:36:17
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
        <title>Curriculo adicionado</title>
    </head>
    <body>
        Curriculo adicionado com sucesso!
        <br />
	<a href="<c:url value='/listaCurriculo'/>" title="Adicionar outro curriculo">Adicionar Curriculo</a>
    </body>
</html>
