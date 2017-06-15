<%-- 
    Document   : listagem_produtos
    Created on : 28/05/2017, 01:30:00
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
        <a href="<c:url value='menuAdm'/>">Voltar ao Menu</a> <br><br>
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
                    <td><figure><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></figure></td>
                    <td>${prod.categoria.descricao}</td>
                    <td>${prod.administrador.nome}</td>
                    <td>
                        <a href="detalhe?id=${prod.id}"> Detalhar</a> 
                        &nbsp;
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
