/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.dao.ClienteDAO;
import br.com.sushinafaixa.dao.CompraDAO;
import br.com.sushinafaixa.model.Status;
import br.com.sushinafaixa.util.Utils;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class CompraController {

    @Autowired
    private CompraDAO compraDAO;
    @Autowired
    private ClienteDAO clienteDAO;

    @RequestMapping(value = "/listaCompras", method = RequestMethod.GET)
    public String lista(Model model) {
        model.addAttribute("statuses", Arrays.asList(Status.values()));
        model.addAttribute("compras", compraDAO.lista());
        return "compra/listagem_compras";
    }

    @RequestMapping(value = "/listaCompras", method = RequestMethod.POST)
    public String listaPorStatus(Model model, @ModelAttribute("status") String status) {
        if ("Todos".equalsIgnoreCase(status)) {
            model.addAttribute("compras", compraDAO.lista());
        } else {
            Status sta = Enum.valueOf(Status.class, status);
            model.addAttribute("compras", compraDAO.lista(sta));
        }
        model.addAttribute("statuses", Arrays.asList(Status.values()));
        return "compra/listagem_compras";
    }

    @RequestMapping(value = "/listaComprasCliente", method = RequestMethod.GET)
    public String listaPorCLiente(HttpServletRequest request, Model model) {
        Usuario usuario = Utils.getUsuarioLogado(request);
        Cliente cliente = clienteDAO.buscarClienteByUsuario(usuario.getId());
        model.addAttribute("statuses", Arrays.asList(Status.values()));
        model.addAttribute("compras", compraDAO.lista(cliente));
        return "compra/listagem_compras";
    }

    @RequestMapping("/exibeCompra")
    public String exibe(Long id, Model model) {
        model.addAttribute("compra", compraDAO.buscarCompraById(id));
        return "compra/exibe_compra";
    }

    @RequestMapping("/alteraStatusCompra")
    public String altera(Long id, Model model) {
        compraDAO.entregaCompra(id);
        model.addAttribute("compra", compraDAO.buscarCompraById(id));
        return "compra/entrega_compra";
    }
}
