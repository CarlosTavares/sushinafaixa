<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Mensagem</title>
    </head>
    <body>
        <h3>Adicionar Mensagem</h3>
        <form action="<c:url value='/adicionaMensagem' />" method="post">
            Assunto: <br />
            <select name="motivo">
                <option value="PERGUNTA">Pergunta</option>
                <option value="CRITICA">Crítica</option>
                <option value="SUGESTAO">Sugestão</option>
            </select> <br />
            Conteúdo: <br />
            <textarea name="conteudo" rows="5" cols="100"></textarea> <br />

            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
