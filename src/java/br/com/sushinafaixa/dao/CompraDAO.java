/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.model.Carrinho;
import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Compra;
import br.com.sushinafaixa.model.ItemCarrinho;
import br.com.sushinafaixa.bean.ItemCompra;
import br.com.sushinafaixa.bean.Produto;
import br.com.sushinafaixa.model.Status;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
            stmt.setString(2, compra.getStatus().name());
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

    public List<Compra> lista() {
        List<Compra> compras = new ArrayList<>();
        String sql = "select c.idcompra,c.cliente_idcliente,c.status,c.data,c.preco_total,c.endereco,c.pagamento"
                + " ,cl.nome"
                + " from compra c"
                + " inner join cliente cl on c.cliente_idcliente=cl.idcliente"
                + " order by data";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("idcompra"));
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_idcliente"));
                cliente.setNome(rs.getString("nome"));
                compra.setCliente(cliente);
                compra.setStatus(Enum.valueOf(Status.class, rs.getString("status")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                compra.setData(data);
                compra.setPrecoTotal(rs.getDouble("preco_total"));
                compra.setEndereco(rs.getString("endereco"));
                compra.setPagamento(rs.getString("pagamento"));
                compra.setItens(this.getItens(compra));
                compras.add(compra);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compras;
    }

    public List<Compra> lista(Status status) {
        List<Compra> compras = new ArrayList<>();
        String sql = "select c.idcompra,c.cliente_idcliente,c.status,c.data,c.preco_total,c.endereco,c.pagamento"
                + " ,cl.nome"
                + " from compra c"
                + " inner join cliente cl on c.cliente_idcliente=cl.idcliente"
                + " where c.status = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, status.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("idcompra"));
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_idcliente"));
                cliente.setNome(rs.getString("nome"));
                compra.setCliente(cliente);
                compra.setStatus(Enum.valueOf(Status.class, rs.getString("status")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                compra.setData(data);
                compra.setPrecoTotal(rs.getDouble("preco_total"));
                compra.setEndereco(rs.getString("endereco"));
                compra.setPagamento(rs.getString("pagamento"));
                compra.setItens(this.getItens(compra));
                compras.add(compra);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compras;
    }

    public List<Compra> lista(Cliente cliente) {
        List<Compra> compras = new ArrayList<>();
        String sql = "select c.idcompra,c.cliente_idcliente,c.status,c.data,c.preco_total,c.endereco,c.pagamento"
                + " from compra c"
                + " order by data";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("idcompra"));
                compra.setCliente(cliente);
                compra.setStatus(Enum.valueOf(Status.class, rs.getString("status")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                compra.setData(data);
                compra.setPrecoTotal(rs.getDouble("preco_total"));
                compra.setEndereco(rs.getString("endereco"));
                compra.setPagamento(rs.getString("pagamento"));
                compra.setItens(this.getItens(compra));
                compras.add(compra);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compras;
    }

    public Compra buscarCompraById(Long id) {
        String sql = "select c.idcompra,c.cliente_idcliente,c.status,c.data,c.preco_total,c.endereco,c.pagamento"
                + " ,cl.nome"
                + " from compra c"
                + " inner join cliente cl on c.cliente_idcliente=cl.idcliente"
                + " where c.idcompra = ? ";
        Compra compra = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            compra = new Compra();
            if (rs.next()) {
                compra.setId(rs.getLong("idcompra"));
                Cliente cliente = new Cliente();
                cliente.setId(rs.getLong("cliente_idcliente"));
                cliente.setNome(rs.getString("nome"));
                compra.setCliente(cliente);
                compra.setStatus(Enum.valueOf(Status.class, rs.getString("status")));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                compra.setData(data);
                compra.setPrecoTotal(rs.getDouble("preco_total"));
                compra.setEndereco(rs.getString("endereco"));
                compra.setPagamento(rs.getString("pagamento"));
                compra.setItens(this.getItens(compra));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return compra;
    }
    
    public List<ItemCompra> getItens(Compra compra) {
        List<ItemCompra> items = new ArrayList<>();
        String sql = "select ic.iditemcompra,ic.compra_idcompra,ic.produto_idproduto"
                + " ,ic.quantidade,ic.preco"
                + " ,p.descricao,p.preco as precoProduto,p.imagem"
                + " from itemcompra ic"
                + " inner join produto p on ic.produto_idproduto=p.idproduto"
                + " where ic.compra_idcompra = ?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setLong(1, compra.getId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ItemCompra item = new ItemCompra();
                item.setId(rs.getLong("iditemcompra"));
                item.setCompra(compra);
                Produto produto = new Produto();
                produto.setId(rs.getLong("produto_idproduto"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("precoProduto"));
                produto.setImagemPath(rs.getString("imagem"));
                item.setProduto(produto);
                item.setQuantidade(rs.getInt("quantidade"));
                item.setPreco(rs.getDouble("preco"));
                items.add(item);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public boolean entregaCompra(Long id) {
        String sql = "update compra set status = ? where idcompra = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, Status.ENTREGUE.name());
            stmt.setLong(2, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
