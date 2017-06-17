<%-- 
    Document   : entrega_compra
    Created on : 16/06/2017, 16:19:58
    Author     : Carlos.Tavares
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${compra.entregue eq true}">
    Entregue
</c:if>
<c:if test="${compra.entregue eq false}">
    Não foi Entregue!
</c:if>