/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.model.Carrinho;
import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Produto;
import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.dao.ClienteDAO;
import br.com.sushinafaixa.dao.CompraDAO;
import br.com.sushinafaixa.dao.ProdutoDAO;
import br.com.sushinafaixa.util.Utils;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class CarrinhoController {

    @Autowired
    private ProdutoDAO produtoDAO;
    @Autowired
    private CompraDAO compraDAO;
    @Autowired
    private ClienteDAO clienteDAO;

    @RequestMapping({"/compraProduto"})
    public String listProductHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "idProduto", defaultValue = "0") Long idProduto) {
        Produto produto = produtoDAO.buscarProdutoPorId(idProduto);
        if (produto != null) {
            Carrinho carrinho = Utils.getCarrinhoSession(request);
            carrinho.addProduto(produto, 1);
        }
        return "redirect:/carrinhoCompra";
    }

    @RequestMapping(value = {"/carrinhoCompra"}, method = RequestMethod.GET)
    public String carrinhoHandler(HttpServletRequest request, Model model) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        model.addAttribute("carrinhoForm", carrinho);
        return "compra/carrinho_compra";
    }

    @RequestMapping(value = {"/carrinhoCompra"}, method = RequestMethod.POST)
    public String updateQtdCarrinhoCompra(HttpServletRequest request, Model model,
            @ModelAttribute("carrinhoForm") Carrinho carrinhoForm) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        carrinho.updateQuantidade(carrinhoForm);
        return "redirect:/carrinhoCompra";
    }

    @RequestMapping({"/removeProdutoCarrinhoCompra"})
    public String removeProductHandler(HttpServletRequest request, Model model, //
            @RequestParam(value = "idProduto", defaultValue = "") Long idProduto) {
        Produto produto = produtoDAO.buscarProdutoPorId(idProduto);
        if (produto != null) {
            Carrinho carrinho = Utils.getCarrinhoSession(request);
            carrinho.removeProduto(produto);
        }
        return "redirect:/carrinhoCompra";
    }

    @RequestMapping(value = {"/finalizaCompra"}, method = RequestMethod.GET)
    public String finalizaCompraForm(HttpServletRequest request, Model model) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        if (carrinho.isEmpty()) {
            return "redirect:/carrinhoCompra";
        }
        model.addAttribute("carrinhoForm", carrinho);
        return "compra/finaliza_compra";
    }

    @RequestMapping(value = {"/finalizaCompra"}, method = RequestMethod.POST)
    public String finalizaCompraSave(HttpServletRequest request, @Valid Carrinho carrinhoForm, BindingResult result) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        Usuario usuario = Utils.getUsuarioLogado(request);
        Cliente cliente = clienteDAO.buscarClienteByUsuario(usuario.getId());
        if (result.hasErrors()) {
            return "compra/finaliza_compra";
        }
        if (cliente== null) {
            return "redirect:/finalizaCompra";
        }
        if (carrinho.isEmpty()) {
            return "redirect:/carrinhoCompra";
        }
        carrinho.setCliente(cliente);
        carrinho.updatePagamento(carrinhoForm);
        return "redirect:/confirmaCompra";
    }

    @RequestMapping(value = {"/confirmaCompra"}, method = RequestMethod.GET)
    public String confirmaCompraForm(HttpServletRequest request, Model model) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        if (carrinho.isEmpty()) {
            return "redirect:/carrinhoCompra";
        }
        return "compra/confirma_compra";
    }

    @RequestMapping(value = {"/confirmaCompra"}, method = RequestMethod.POST)
    public String confirmaCompraSave(HttpServletRequest request, Model model) {
        Carrinho carrinho = Utils.getCarrinhoSession(request);
        if (carrinho.isEmpty()) {
            return "redirect:/carrinhoCompra";
        }
        try {
            compraDAO.adiciona(carrinho);
        } catch (Exception e) {
            return "redirect:/confirmaCompra";
        }
        Utils.removeCarrinhoSession(request);
        Utils.setUltimoCarrinhoSession(request, carrinho);
        return "redirect:/finalizaCarrinho";
    }

    @RequestMapping(value = {"/finalizaCarrinho"}, method = RequestMethod.GET)
    public String finalizaCarrinho(HttpServletRequest request, Model model) {
        Carrinho carrinho = Utils.getUltimoCarrinhoSession(request);
        if (carrinho.isEmpty()) {
            return "redirect:/carrinhoCompra";
        }
        return "compra/finaliza_carrinho";
    }
}
