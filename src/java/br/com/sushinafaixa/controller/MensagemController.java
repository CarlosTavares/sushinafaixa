/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Mensagem;
import br.com.sushinafaixa.dao.MensagemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class MensagemController {
    
    private final MensagemDAO dao;

    @Autowired
    public MensagemController(MensagemDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/formAdicionaMensagem")
    public String form() {
        return "mensagem/formAdicionaMensagem";
    }
    
    @RequestMapping("/adicionaMensagem")
    public String adiciona(Mensagem msg) {
        dao.adiciona(msg);
        return "mensagem/mensagem_adicionada";
    }
    
    @RequestMapping("/listaMensagens")
    public String lista(Model model) {
        model.addAttribute("listaMensagens", dao.lista());
        return "mensagem/listagem_mensagens";
    }
}
