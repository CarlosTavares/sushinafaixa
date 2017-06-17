/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.dao.LoginDAO;
import br.com.sushinafaixa.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class LoginController {

    private final LoginDAO dao;

    @Autowired
    public LoginController(LoginDAO dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "loginForm")
    public String efetuaLogin() {
        return "auth/formLogin";
    }

    @RequestMapping(value = "efetuaLogin")
    public String efetuaLogin(Usuario usuario, Model model,
            HttpServletRequest request) {
        Usuario usuarioLogado = dao.buscaUsuarioByLogin(usuario.getLogin());
        if (usuarioLogado != null) {
            request.getSession(true)
                    .setAttribute("usuario", usuarioLogado);
            if (usuarioLogado.getRole().equals(Role.ADMIN)) {
                return "redirect:menuAdm";
            } else {
                return "redirect:menuCliente";
            }
        } else {
            model.addAttribute("msgLoginInvalido", "Não é um usuario válido.");
            return "redirect:loginForm";
        }
    }

    @RequestMapping(value = "menuAdm")
    public String menuAdmin() {
        return "auth/menuAdm";
    }

    @RequestMapping(value = "menuCliente")
    public String menuCliente() {
        return "auth/menuCliente";
    }

    @RequestMapping(value = "menuGeral")
    public String menuGeral() {
        return "menuGeral";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
        return "redirect:menuGeral";
    }
}
