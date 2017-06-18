<%-- 
    Document   : listagem_admins
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
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Ação</th>
                        </tr>
                        <c:forEach items="${listaAdmins}" var="adm">
                            <tr>
                                <td>${adm.id}</td>
                                <td>${adm.nome}</td>
                                <td>${adm.usuario.login}</td>
                                <td>
                                    <a href="exibeAdmin?id=${adm.id}"> Alterar </a> 
                                    &nbsp;
                                    <a href="removeAdmin?id=${adm.id}" 
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
