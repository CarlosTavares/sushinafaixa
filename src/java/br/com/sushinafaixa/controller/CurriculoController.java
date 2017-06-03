/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.controller;

import br.com.sushinafaixa.bean.Curriculo;
import br.com.sushinafaixa.components.FileSaver;
import br.com.sushinafaixa.dao.CurriculoDAO;
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
public class CurriculoController {

    private final CurriculoDAO dao;
    @Autowired
    private FileSaver fileSaver;

    @Autowired
    public CurriculoController(CurriculoDAO dao) {
        this.dao = dao;
    }

    @RequestMapping("/formAdicionaCurriculo")
    public String form(@Valid Curriculo curriculo, Model model) {
        return "curriculo/formAdicionaCurriculo";
    }

    @RequestMapping("/adicionaCurriculo")
    public String adiciona(MultipartFile arquivo, @Valid Curriculo curriculo, BindingResult result) {
        if (result.hasErrors()) {
            return "produto/formAdicionaCurriculo";
        }
        String webPath = fileSaver.write("resources/curriculos", arquivo);
        curriculo.setArquivoPath(webPath);
        dao.adiciona(curriculo);
        return "curriculo/curriculo_adicionado";
    }

    @RequestMapping("/listaCurriculo")
    public String lista(Model model) {
        model.addAttribute("listaCurriculo", dao.lista());
        return "curriculo/listagem_curriculos";
    }

}
