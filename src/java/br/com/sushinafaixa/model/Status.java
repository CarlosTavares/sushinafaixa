/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.model;

/**
 *
 * @author Carlos.Tavares
 */
public enum Status {
    GERADO("Gerado"),
    ENTREGUE("Entregue");
    
    private String descricao;

    private Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
