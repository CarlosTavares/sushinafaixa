/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.util;

import br.com.sushinafaixa.model.Carrinho;
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

    public static String getUltimaURI(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("ultimaURI");
    }

    public static void setUltimaURI(HttpServletRequest request, String uri) {
        if (uri.endsWith("loginForm")
                || uri.endsWith("efetuaLogin")
                || uri.endsWith("logout")
                || uri.endsWith("efetuaRegistro")
                || uri.endsWith("registra")
                || uri.endsWith("/")
                || uri.contains("resources")) {
            System.out.println("UtilsURI: " + uri + " nao adicionou.");
        } else {

            request.getSession().setAttribute("ultimaURI", getAcao(uri));
        }
    }

    private static String getAcao(String uri) {
        String[] vetorUri = uri.split("/");
        String resultado = "";
        for (int i = 2; i < vetorUri.length; i++) {
            resultado = "/" + vetorUri[i];
        }
        return resultado;
    }
}
