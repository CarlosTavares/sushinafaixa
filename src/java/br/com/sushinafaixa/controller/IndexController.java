/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class IndexController {
    @Autowired
    private CategoriaDAO categoriaDAO;
    
    @RequestMapping("/")
    public String index() {
        return "redirect:/menuGeral";
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
    public String menuGeral(Model model) {
        System.out.println("br.com.sushinafaixa.controller.LoginController.menuGeral()");
        model.addAttribute("listaCategorias", categoriaDAO.lista());
        return "menuGeral";
    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "/403";
    }
}
