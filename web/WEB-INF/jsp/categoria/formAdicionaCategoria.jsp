<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Categoria</title>
    </head>
    <body>
        <h3>Adicionar Categoria</h3>
        <form action="<c:url value='/adicionaCategoria' />" method="post">
            Descrição: <input type="text" name="descricao" /> <br /><br />
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
