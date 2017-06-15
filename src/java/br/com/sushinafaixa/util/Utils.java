/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.util;

import br.com.sushinafaixa.bean.Carrinho;
import br.com.sushinafaixa.bean.Usuario;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Carlos.Tavares
 */
public class Utils {

    // Produtos no carrinho, mantidos na Session.
    public static Carrinho getCarrinhoSession(HttpServletRequest request) {
        // Pega o carrinho da Session.
        Carrinho carrinho = (Carrinho) request.getSession().getAttribute("meuCarrinho");
        // Se o carrinho nao tiver sido criado.
        if (carrinho == null) {
            // Cria um carrinho
            carrinho = new Carrinho();
            // E o coloca na Session.
            request.getSession().setAttribute("meuCarrinho", carrinho);
        }
        return carrinho;
    }

    public static void removeCarrinhoSession(HttpServletRequest request) {
        request.getSession().removeAttribute("meuCarrinho");
    }

    public static void setUltimoCarrinhoSession(HttpServletRequest request, Carrinho carrinho) {
        request.getSession().setAttribute("ultimoCarrinho", carrinho);
    }

    public static Carrinho getUltimoCarrinhoSession(HttpServletRequest request) {
        return (Carrinho) request.getSession().getAttribute("ultimoCarrinho");
    }

    public static Usuario getUsuarioLogado(HttpServletRequest request) {
        return (Usuario) request.getSession().getAttribute("usuario");
    }
}
