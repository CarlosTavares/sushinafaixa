<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Curriculo</title>
    </head>
    <body>
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
    </body>
</html>
