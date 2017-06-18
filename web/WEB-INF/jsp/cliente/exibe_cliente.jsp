<%-- 
    Document   : exibe_cliente
    Created on : 22/05/2017, 09:02:40
    Author     : User
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../auth/nav_admin.jsp" %>
<section>
    <!-- Aqui começa o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    <h3>Alterar Cliente - ${cliente.id}</h3>
                    <form action="<c:url value='/alteraCliente'/>" method="post">
                        <input type="hidden" name="id" value="${cliente.id}" />
                        Nome:
                        <form:errors path="cliente.nome" cssStyle="color:red"/>
                        <input name="nome" value="${cliente.nome}" />
                        <br><br>
                        Login: ${cliente.usuario.login}
                        <br><br>
                        CPF:
                        <input name="cpf" value="${cliente.cpf}" />
                        <br><br>
                        Endereço:
                        <input name="endereco" value="${cliente.endereco}" />
                        <br><br>
                        <input type="submit" value="Alterar"/>
                        <br><br>            
                    </form>
                    <a href="<c:url value='/listaCliente'/>">Voltar</a>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>