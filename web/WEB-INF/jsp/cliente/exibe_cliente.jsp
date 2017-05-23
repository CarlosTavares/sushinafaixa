<%-- 
    Document   : exibe-cliente
    Created on : 22/05/2017, 09:02:40
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cliente</title>
    </head>
    <body>
        <h3>Alterar Cliente - ${cliente.id}</h3>
        <form action="<c:url value='/alteraCliente'/>" method="post">
            <input type="hidden" name="id" value="${cliente.id}" />
            Nome:
            <form:errors path="cliente.nome" cssStyle="color:red"/>
            <input name="nome" value="${cliente.nome}" />
            <br><br>
            Login:
            <input name="cpf" value="${cliente.cpf}" />
            <br><br>
            Senha:
            <input name="endereco" value="${cliente.endereco}" />
            <br><br>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/'/>">Voltar</a>
    </body>
</html>
