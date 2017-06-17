<%-- 
    Document   : listage_produtos_categoria
    Created on : 17/06/2017, 15:23:42
    Author     : Carlos.Tavares
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="customTags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Produtos</title>
    </head>
    <body>
        <input type="button" value="Voltar" onclick="history.back()" /><br><br>
        <h3>${categoria.descricao}</h3>
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
                    <td><span >
                            <fmt:formatNumber value="${prod.preco}" type="currency"/>
                        </span></td>
                    <td>
                        <a href="detalheProduto?id=${prod.id}">
                            <figure><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></figure>
                        </a>
                    </td>
                    <td>${prod.categoria.descricao}</td>
                    <td>${prod.administrador.nome}</td>
                    <td>
                        <a href="detalhe?id=${prod.id}"> Detalhar</a> 
                        &nbsp;
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
