<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Administrador</title>
    </head>
    <body>
        <h3>Adicionar Administrador</h3>
        <form action="<c:url value='/adicionaAdministrador' />" method="post">
            Nome: <input type="text" name="nome" /> <br /><br />
            Login: <input type="text" name="login" /> <br /><br />
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
