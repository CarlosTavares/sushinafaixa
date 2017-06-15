/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.interceptors;

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
                || uri.contains("resources")) {
            return true;
        }

        if (request.getSession().getAttribute("usuario") != null) {
            return true;
        }

        response.sendRedirect("loginForm");
        return false;
    }

}
