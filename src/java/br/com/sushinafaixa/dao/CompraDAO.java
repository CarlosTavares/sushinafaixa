/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Carrinho;
import br.com.sushinafaixa.bean.Compra;
import br.com.sushinafaixa.bean.ItemCarrinho;
import br.com.sushinafaixa.bean.ItemCompra;
import br.com.sushinafaixa.bean.Status;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos.Tavares
 */
@Repository
public class CompraDAO {

    private final Connection connection;

    @Autowired
    public CompraDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Carrinho carrinho) {
        boolean resultado = false;
        Compra compra = new Compra();
        compra.setCliente(carrinho.getCliente());
        compra.setStatus(Status.GERADO);
        compra.setData(Calendar.getInstance());
        compra.setPrecoTotal(carrinho.getPrecoTotal());
        compra.setEndereco(carrinho.getEndereco());
        compra.setPagamento(carrinho.getPagamento());

        String sql = "insert into compra (cliente_idcliente,status,data,preco_total,endereco,pagamento) values (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, compra.getCliente().getId());
            stmt.setString(2, compra.getStatus().toString());
            stmt.setDate(3, new Date(compra.getData().getTimeInMillis()));
            stmt.setDouble(4, compra.getPrecoTotal());
            stmt.setString(5, compra.getEndereco());
            stmt.setString(6, compra.getPagamento());
            stmt.execute();
            compra.setId(this.getMaxCompra());
            carrinho.setIdCompra(compra.getId());
            for (ItemCarrinho item : carrinho.getItensCarrinho()) {
                resultado = this.adicionaItem(item, compra);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public boolean adicionaItem(ItemCarrinho item, Compra compra) {
        boolean resultado = false;
        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setCompra(compra);
        itemCompra.setProduto(item.getProduto());
        itemCompra.setQuantidade(item.getQuantidade());
        itemCompra.setPreco(item.getSubTotal());

        String sql = "insert into itemcompra (compra_idcompra,produto_idproduto,quantidade,preco) values (?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, compra.getId());
            stmt.setLong(2, itemCompra.getProduto().getId());
            stmt.setInt(3, itemCompra.getQuantidade());
            stmt.setDouble(4, itemCompra.getPreco());
            stmt.execute();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public Long getMaxCompra() {
        Long id = new Long(0);
        String sql = "select MAX(idcompra) as idcompra from compra c";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getLong("idcompra");
            }
            return id;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
