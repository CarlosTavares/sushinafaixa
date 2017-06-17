/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.model;

import br.com.sushinafaixa.bean.Produto;
import java.io.Serializable;

/**
 *
 * @author Carlos.Tavares
 */
public class ItemCarrinho implements Serializable {
    
    private Produto produto;
    private int quantidade;

    public ItemCarrinho() {
        this.quantidade = 0;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubTotal() {
        return this.produto.getPreco()*this.quantidade;
    }
}
