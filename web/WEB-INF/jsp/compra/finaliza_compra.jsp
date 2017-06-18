<%-- 
    Document   : finaliza_compra
    Created on : 15/06/2017, 10:18:03
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
                    <h3>Dados de Pagamento</h3>
                    <spring:url value="/finalizaCompra" var="finalizaCompraUrl" />
                    <form:form method="POST" action="${finalizaCompraUrl}" modelAttribute="carrinhoForm">
                        <table>
                            <tr>
                                <td>Endereço: </td>
                                <td><form:input type="text" path="endereco" /></td>
                            </tr>
                            <tr>
                                <td>Forma de Pagamento: </td>
                                <td><form:select path="pagamento">
                                        <form:option value="" label="Forma de Pagamento" />
                                        <form:option value="DINHEIRO" label="Dinheiro" />
                                        <form:option value="CARTAO" label="Cartão de Crédito" />
                                    </form:select></td>
                            </tr>
                            <tr>
                                <td>&nbsp;</td>
                                <td><input type="submit" value="Confirma" /> <input type="reset"
                                                                                    value="Reset" /></td>
                            </tr>
                        </table>
                    </form:form>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
