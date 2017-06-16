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
        <title>Alterar Administrador</title>
    </head>
    <body>
        <h3>Alterar Administrador - ${adm.id}</h3>
        <form action="<c:url value='/alteraAdmin'/>" method="post">
            <input type="hidden" name="id" value="${adm.id}" />
            Nome:
            <form:errors path="adm.nome" cssStyle="color:red"/>
            <input name="nome" value="${adm.nome}" />
            <br><br>
            Login: ${adm.usuario.login}
            <br><br>
            <input type="submit" value="Alterar"/>
            <br><br>            
        </form>
        <a href="<c:url value='/listaAdministradores'/>">Voltar</a>
    </body>
</html>
