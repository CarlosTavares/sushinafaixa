<%-- 
    Document   : finaliza_carrinho
    Created on : 15/06/2017, 11:39:27
    Author     : Carlos.Tavares
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra Efetuada</title>
    </head>
    <body>
        <h3>Compra efetuada</h3>
        <div >
            <h3>Agradecemos sua Preferência!</h3>
            O identificador de sua compra é: ${ultimoCarrinho.idCompra}
        </div>
    </body>
</html>
