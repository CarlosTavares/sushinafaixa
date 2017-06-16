<%-- 
    Document   : mensagem_adicionada
    Created on : 22/05/2017, 00:36:17
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
        <title>Cliente adicionado</title>
    </head>
    <body>
        Cliente adicionado com sucesso!
        <br />
	<a href="<c:url value='formAdicionaCliente'/>" title="Adicionar outro cliente">Adicionar outro Cliente</a>
    </body>
</html>
