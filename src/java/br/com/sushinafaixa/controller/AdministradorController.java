/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Administrador;
import br.com.sushinafaixa.dao.AdministradorDAO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class AdministradorController {

    private final AdministradorDAO dao;

    @Autowired
    public AdministradorController(AdministradorDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/formAdicionaAdmin")
    public String form() {
        return "administrador/formAdicionaAdmin";
    }

    @RequestMapping("/adicionaAdministrador")
    public String adiciona(Administrador adm) {
        dao.adiciona(adm);
        return "administrador/administrador_adicionado";
    }

    @RequestMapping("/listaAdministradores")
    public String lista(Model model) {
        model.addAttribute("listaAdmins", dao.lista());
        return "administrador/listagem_admins";
    }

    @RequestMapping("/removeAdmin")
    public String remove(Long id) {
        dao.removerAdministrador(id);
        return "redirect:/listaAdministradores";
    }

    @RequestMapping("/exibeAdmin")
    public String exibe(Long id, Model model) {
        model.addAttribute("adm", dao.buscarAdministradorPorId(id));
        return "administrador/exibe_administrador";
    }

    @RequestMapping("/alteraAdmin")
    public String altera(@Valid Administrador administrador, BindingResult result) {
        if (result.hasErrors()) {
            return "administrador/exibe_administrador";
        }
        dao.alterarAdministrador(administrador);
        return "redirect:/listaAdministradores";
    }
}
