/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos.Tavares
 */
@Repository
public class ClienteDAO {

    private final Connection connection;

    @Autowired
    public ClienteDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Cliente cliente) {
        String sql = "insert into cliente (nome, cpf, endereco) values (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Cliente> lista() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        String sql = "select * from cliente order by nome";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente msg = new Cliente();
                msg.setId(rs.getLong("idcliente"));
                msg.setNome(rs.getString("nome"));
                msg.setCpf(rs.getString("cpf"));
                msg.setEndereco(rs.getString("endereco"));
                clientes.add(msg);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        String sql = "select * from cliente where idcliente = ? ";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = new Cliente();
            if (rs.next()) {
                cliente.setId(rs.getLong("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));

            }
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerCliente(Long id) {
        String sql = "delete from cliente where idcliente = ? ";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarCliente(Cliente cliente) {
        String sql = "update cliente set nome = ?, cpf = ?, endereco = ? where idcliente = ?";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setLong(4, cliente.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
