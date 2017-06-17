/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.dao.CategoriaDAO;
import br.com.sushinafaixa.dao.ClienteDAO;
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

    @Autowired
    private LoginDAO dao;

    @Autowired
    private ClienteDAO daoCliente;

    @RequestMapping(value = "loginForm")
    public String efetuaLogin() {
        return "auth/formLogin";
    }

    @RequestMapping(value = "registra")
    public String registraForm() {
        return "auth/formRegistro";
    }

    @RequestMapping(value = "efetuaLogin")
    public String efetuaLogin(Usuario usuario, Model model,
            HttpServletRequest request) {
        Usuario usuarioLogado = dao.buscaUsuarioByLogin(usuario.getLogin(), usuario.getSenha());
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

    @RequestMapping(value = "efetuaRegistro")
    public String efetuaRegistro(Cliente clt,HttpServletRequest request) {
        daoCliente.adiciona(clt);
        request.getSession(true)
                    .setAttribute("usuario", clt.getUsuario());
        return "cliente/clente_adicionado";
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
        return "redirect:menuGeral";
    }
}
