/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.model;

import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos.Tavares
 */
public class Carrinho implements Serializable {

    private Long idCompra;
    private Cliente cliente;
    private final List<ItemCarrinho> itensCarrinho = new ArrayList<>();
    private String endereco;
    private String pagamento;

    public Carrinho() {
    }

    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemCarrinho> getItensCarrinho() {
        return this.itensCarrinho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    private ItemCarrinho buscaItemByProduto(Long idProduto) {
        for (ItemCarrinho item : this.itensCarrinho) {
            if (item.getProduto().getId().equals(idProduto)) {
                return item;
            }
        }
        return null;
    }

    public void addProduto(Produto produto, int quantidade) {
        ItemCarrinho item = this.buscaItemByProduto(produto.getId());

        if (item == null) {
            item = new ItemCarrinho();
            item.setQuantidade(0);
            item.setProduto(produto);
            this.itensCarrinho.add(item);
        }
        int novaQuantidade = item.getQuantidade() + quantidade;
        if (novaQuantidade <= 0) {
            this.itensCarrinho.remove(item);
        } else {
            item.setQuantidade(novaQuantidade);
        }
    }

    public void updateProduto(Long idProduto, int quantidade) {
        ItemCarrinho line = this.buscaItemByProduto(idProduto);

        if (line != null) {
            if (quantidade <= 0) {
                this.itensCarrinho.remove(line);
            } else {
                line.setQuantidade(quantidade);
            }
        }
    }

    public void removeProduto(Produto produto) {
        ItemCarrinho item = this.buscaItemByProduto(produto.getId());
        if (item != null) {
            this.itensCarrinho.remove(item);
        }
    }

    public boolean isEmpty() {
        return this.itensCarrinho.isEmpty();
    }

    public int getQuantidadeTotal() {
        int quantidade = 0;
        for (ItemCarrinho item : this.itensCarrinho) {
            quantidade += item.getQuantidade();
        }
        return quantidade;
    }

    public Double getPrecoTotal() {
        Double total = new Double(0);
        for (ItemCarrinho item : this.itensCarrinho) {
            total += item.getSubTotal();
        }
        return total;
    }

    public void updateQuantidade(Carrinho carrinhoForm) {
        if (carrinhoForm != null) {
            List<ItemCarrinho> itens = carrinhoForm.getItensCarrinho();
            for (ItemCarrinho item : itens) {
                this.updateProduto(item.getProduto().getId(), item.getQuantidade());
            }
        }
    }

    public void updatePagamento(Carrinho carrinhoForm) {
        if (carrinhoForm != null) {
            this.setEndereco(carrinhoForm.getEndereco());
            this.setPagamento(carrinhoForm.getPagamento());
        }
    }
}
