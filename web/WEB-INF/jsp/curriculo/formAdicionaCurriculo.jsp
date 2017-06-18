<%-- 
    Document   : formAdicionaCurriculo
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
                    <h3>Adicionar Curriculo</h3>
                    <spring:hasBindErrors name="curriculo">
                        <c:forEach var="error" items="${errors.allErrors}">
                            <b><spring:message message="${error}" /></b>
                            <br />
                        </c:forEach>
                    </spring:hasBindErrors>
                    <spring:url value="/adicionaCurriculo" var="addCurriculoUrl" />
                    <form:form action="${addCurriculoUrl}" method="post" modelAttribute="curriculo" enctype="multipart/form-data">
                        Nome <form:input type="text" path="nome" /> <br /><br />
                        Email: <form:input type="text" path="email" /> <br /><br />
                        Arquivo: <input type="file" name="arquivo"/> <br /><br />
                        <form:button>Adicionar</form:button>
                    </form:form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
