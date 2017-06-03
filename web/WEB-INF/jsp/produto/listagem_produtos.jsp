<%-- 
    Document   : listagem_produtos
    Created on : 28/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Produtos</title>
    </head>
    <body>
        <a href="<c:url value='/index'/>">Voltar</a> <br><br>
        <table>
            <tr>
                <th>Id</th>
                <th>Descrição</th>
                <th>Preço</th>
                <th>Imagem</th>
                <th>Categoria</th>
                <th>Administrador</th>
                <th>Ação</th>
            </tr>
            <c:forEach items="${listaProdutos}" var="prod">
                <tr>
                    <td>${prod.id}</td>
                    <td>${prod.descricao}</td>
                    <td>${prod.preco}</td>
                    <td><figure><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></figure></td>
                    <td>${prod.categoria.descricao}</td>
                    <td>${prod.administrador.nome}</td>
                    <td>
                        <a href="exibeProduto?id=${prod.id}"> Alterar </a> 
                        &nbsp;
                        <a href="removeProduto?id=${prod.id}" 
                           onclick="return confirm('Deseja realmente excluir?')" > Remover </a> 
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
