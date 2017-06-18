<%-- 
    Document   : finaliza_carrinho
    Created on : 15/06/2017, 11:39:27
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
                    <h3>Compra efetuada</h3>
                    <div >
                        <h3>Agradecemos sua Preferência!</h3>
                        O identificador de sua compra é: ${ultimoCarrinho.idCompra}
                    </div>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
