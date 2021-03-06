/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.dao.ClienteDAO;
import br.com.sushinafaixa.util.Utils;
import javax.servlet.http.HttpServletRequest;
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
public class ClienteController {

    @Autowired
    private ClienteDAO dao;

    @RequestMapping("/formAdicionaCliente")
    public String form() {
        return "cliente/formAdicionaCliente";
    }

    @RequestMapping("/adicionaCliente")
    public String adiciona(Cliente clt) {
        dao.adiciona(clt);
        return "cliente/clente_adicionado";
    }

    @RequestMapping("/listaCliente")
    public String lista(Model model) {
        model.addAttribute("listaClientes", dao.lista());
        return "cliente/listagem_clientes";
    }

    @RequestMapping("/removeCliente")
    public String remove(Long id) {
        dao.removerCliente(id);
        return "redirect:/listaCliente";
    }

    @RequestMapping("/exibeCliente")
    public String exibe(Long id, Model model) {
        model.addAttribute("cliente", dao.buscarClientePorId(id));
        return "cliente/exibe_cliente";
    }

    @RequestMapping("/visualizaClienteLogado")
    public String exibe(HttpServletRequest request, Model model) {
        Usuario usuario = Utils.getUsuarioLogado(request);
        Cliente cliente = dao.buscarClienteByUsuario(usuario.getId());
        model.addAttribute("cliente", dao.buscarClientePorId(cliente.getId()));
        return "cliente/exibe_cliente";
    }

    @RequestMapping("/alteraCliente")
    public String altera(@Valid Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            return "cliente/exibe_cliente";
        }
        dao.alterarCliente(cliente);
        return "redirect:/listaCliente";
    }

}
