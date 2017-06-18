<%-- 
    Document   : listagem_curriculos
    Created on : 27/05/2017, 01:30:00
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
                            <th>Email</th>
                            <th>Arquivo</th>
                        </tr>
                        <c:forEach items="${listaCurriculo}" var="cur">
                            <tr>
                                <td>${cur.id}</td>
                                <td>${cur.nome}</td>
                                <td>${cur.email}</td>
                                <td>${cur.arquivoPath}</td>
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
