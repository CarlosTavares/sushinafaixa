<%-- 
    Document   : confirma_compra
    Created on : 15/06/2017, 10:47:22
    Author     : Carlos.Tavares
--%>
<%@include file="../comum/header.jsp" %>
<%@include file="../auth/nav_admin.jsp" %>
<section>
    <!-- Aqui come�a o conteudo -->
    <div class="wrapper" role="main">
        <div class="container">
            <div class="row">
                <div id="conteudo" class="col-md-9">
                    <fmt:setLocale value="pt_BR" scope="session"/>
                    <h3>Confirmar Compra</h3>
                    <spring:url value="/confirmaCompra" var="confirmaCompraUrl" />
                    <div >
                        <h3>Dados do Cliente:</h3>
                        <ul>
                            <li>Nome:  ${meuCarrinho.cliente.nome}</li>
                            <li>Address: ${meuCarrinho.endereco}</li>
                        </ul>
                        <h3>Compra:</h3>
                        <ul>
                            <li>Quantidade: ${meuCarrinho.quantidadeTotal}</li>
                            <li>Pre�o Total:
                                <span >
                                    <fmt:formatNumber value="${meuCarrinho.precoTotal}" type="currency"/>
                                </span></li>
                        </ul>
                    </div>

                    <form method="POST" action="${confirmaCompraUrl}">
                        <a href="<c:url value='/carrinhoCompra'/>">Editar Compra</a>
                        <a href="<c:url value='/finalizaCompra'/>">Editar Dados de Pagamento</a>
                        <input type="submit" value="Confirma" />
                    </form>

                    <div >

                        <c:forEach items="${myCart.itensCarrinho}" var="item">
                            <div >
                                <ul>
                                    <li><img src="${prod.imagemPath}" width="25px" alt="${prod.descricao}" /></li>
                                    <li>Id do Produto: ${item.produto.id} <form:hidden
                                            path="itensCarrinho[${varStatus.index}].produto.id" />
                                    </li>
                                    <li>Descri��o: ${item.produto.descricao}</li>
                                    <li>Pre�o: <span >
                                            <fmt:formatNumber value="${item.produto.preco}" type="currency"/>
                                        </span></li>
                                    <li>Quantidade: ${itemCarrinho.quantidade}</li>
                                    <li>Subtotal:
                                        <span >
                                            <fmt:formatNumber value="${item.subTotal}" type="currency"/>
                                        </span>
                                    </li>
                                    </li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                </div> <!-- Aqui e a area do conteudo -->
                <div id="sidebar" class="col-md-3"></div> <!-- Aqui e a area do sidebar -->
            </div>
        </div>
    </div> <!-- Fim do conteudo -->
</section>
<%@include file="../comum/footer.jsp" %>
