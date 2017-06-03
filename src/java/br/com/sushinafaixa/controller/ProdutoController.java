/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Produto;
import br.com.sushinafaixa.components.FileSaver;
import br.com.sushinafaixa.dao.AdministradorDAO;
import br.com.sushinafaixa.dao.CategoriaDAO;
import br.com.sushinafaixa.dao.ProdutoDAO;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Carlos.Tavares
 */
@Controller
public class ProdutoController {

    private final ProdutoDAO dao;
    private final CategoriaDAO daoCategoria;
    private final AdministradorDAO daoAdministrador;
    @Autowired
    private FileSaver fileSaver;

    @Autowired
    public ProdutoController(ProdutoDAO dao, CategoriaDAO daoCategoria, AdministradorDAO daoAdministrador) {
        this.dao = dao;
        this.daoCategoria = daoCategoria;
        this.daoAdministrador = daoAdministrador;
    }

    @RequestMapping("/formAdicionaProduto")
    public String form(@Valid Produto produto, Model model) {
        model.addAttribute("cats", daoCategoria.lista());
        model.addAttribute("admins", daoAdministrador.lista());
        return "produto/formAdicionaProduto";
    }

    @RequestMapping("/adicionaProduto")
    public String adiciona(MultipartFile imagem, @Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/formAdicionaProduto";
        }
        String webPath = fileSaver.write("resources/uploaded-images", imagem);
        produto.setImagemPath(webPath);
        dao.adiciona(produto);
        return "produto/produto_adicionado";
    }

    @RequestMapping("/listaProduto")
    public String lista(Model model) {
        model.addAttribute("listaProdutos", dao.lista());
        return "produto/listagem_produtos";
    }

    @RequestMapping("/removeProduto")
    public String remove(Long id) {
        dao.removerProduto(id);
        return "redirect:/listaProduto";
    }

    @RequestMapping("/exibeProduto")
    public String exibe(Long id, Model model) {
        model.addAttribute("produto", dao.buscarProdutoPorId(id));
        return "produto/exibe_produto";
    }

    @RequestMapping("/alteraProduto")
    public String altera(MultipartFile imagem, @Valid Produto produto, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/exibe_produto";
        }
        String webPath = fileSaver.write("resources/uploaded-images", imagem);
        produto.setImagemPath(webPath);
        dao.alterarProduto(produto);
        return "redirect:/listaProduto";
    }
}
