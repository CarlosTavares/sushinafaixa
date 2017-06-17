/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.interceptors;

import br.com.sushinafaixa.util.Utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author User
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object controller) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.endsWith("loginForm")
                || uri.endsWith("efetuaLogin")
                || uri.endsWith("menuGeral")
                || uri.endsWith("formAdicionaMensagem")
                || uri.endsWith("formAdicionaCurriculo")
                || uri.contains("listaProdutosByCategoria")
                || uri.contains("detalheProduto")
                || uri.contains("compraProduto")
                || uri.endsWith("/")
                || uri.contains("resources")) {
            return true;
        }

        if (Utils.getUsuarioLogado(request) != null) {
            return true;
        }

        response.sendRedirect("loginForm");
        return false;
    }

}
