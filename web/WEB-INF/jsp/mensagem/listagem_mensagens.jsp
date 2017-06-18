<%-- 
    Document   : listagem_mensagens
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
                            <th>Assunto</th>
                            <th>Conteudo</th>
                        </tr>
                        <c:forEach items="${listaMensagens}" var="msg">
                            <tr>
                                <td>${msg.id}</td>
                                <td>${msg.motivo}</td>
                                <td>${msg.conteudo}</td>
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
