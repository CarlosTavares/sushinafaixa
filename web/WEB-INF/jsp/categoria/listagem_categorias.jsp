<%-- 
    Document   : listagem_categorias
    Created on : 22/05/2017, 01:30:00
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
                            <th>Ação</th>
                        </tr>
                        <c:forEach items="${listaCategorias}" var="cat">
                            <tr>
                                <td>${cat.id}</td>
                                <td>${cat.descricao}</td>
                                <td>
                                    <a href="exibeCategoria?id=${cat.id}"> Alterar </a> 
                                    &nbsp;
                                    <a href="removeCategoria?id=${cat.id}" 
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
