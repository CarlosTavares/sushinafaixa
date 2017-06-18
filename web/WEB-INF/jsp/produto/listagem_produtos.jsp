<%-- 
    Document   : listagem_produtos
    Created on : 28/05/2017, 01:30:00
    Author     : Carlos.Tavares
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../auth/nav_admin.jsp" %>
<section>
    <!-- Aqui começa o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    <input type="button" value="Voltar" onclick="history.back()" /><br><br>
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
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>

