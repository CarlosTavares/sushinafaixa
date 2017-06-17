<%-- 
    Document   : formRegistro
    Created on : 17/06/2017, 16:01:25
    Author     : Carlos.Tavares
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
    </head>
    <body>
        <h3>Registrar</h3>
        <form action="<c:url value='/efetuaRegistro' />" method="post">
            Nome: <input type="text" name="nome" /> <br /><br />
            Login: <input type="text" name="usuario.login" /> <br /><br />
            Senha: <input type="password" name="usuario.senha" /> <br /><br />
            CPF: <input type="text" name="cpf" /> <br /><br />
            Endereço: <input type="text" name="endereco" /> <br /><br />
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
