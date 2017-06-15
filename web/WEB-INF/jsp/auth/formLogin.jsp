<%-- 
    Document   : formLogin
    Created on : 11/06/2017, 08:00:02
    Author     : Carlos.Tavares
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet" />
        <title>Login</title>
    </head>
    <body>
        <h3>Login</h3>
        <div class="msgErro">${msgLoginInvalido}</div><br>
        <form action="<c:url value='/efetuaLogin' />" method="POST">
            Login: <input type="text" name="login" /><br><br>
            Senha: <input type="password" name="senha" /><br><br>
            <input type="submit" value="Entrar" />
            <input type="button" value="Voltar" onclick="history.back()" />
        </form>
    </body>
</html>
