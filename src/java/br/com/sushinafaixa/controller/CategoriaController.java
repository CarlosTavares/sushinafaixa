/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Categoria;
import br.com.sushinafaixa.dao.CategoriaDAO;
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
public class CategoriaController {

    private final CategoriaDAO dao;

    @Autowired
    public CategoriaController(CategoriaDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/formAdicionaCategoria")
    public String form() {
        return "categoria/formAdicionaCategoria";
    }

    @RequestMapping("/adicionaCategoria")
    public String adiciona(Categoria cat) {
        dao.adiciona(cat);
        return "categoria/categoria_adicionada";
    }

    @RequestMapping("/listaCategoria")
    public String lista(Model model) {
        model.addAttribute("listaCategorias", dao.lista());
        return "categoria/listagem_categorias";
    }

    @RequestMapping("/removeCategoria")
    public String remove(Long id) {
        dao.removerCategoria(id);
        return "redirect:/listaCategoria";
    }

    @RequestMapping("/exibeCategoria")
    public String exibe(Long id, Model model) {
        model.addAttribute("categoria", dao.buscarCategoriaPorId(id));
        return "categoria/exibe_categoria";
    }

    @RequestMapping("/alteraCategoria")
    public String altera(@Valid Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "categoria/exibe_categoria";
        }
        dao.alterarCategoria(categoria);
        return "redirect:/listaCategoria";
    }

}
