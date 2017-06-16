/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Cliente;
import br.com.sushinafaixa.bean.Role;
import br.com.sushinafaixa.bean.Usuario;
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
    private UsuarioDAO usuarioDAO;

    @Autowired
    public ClienteDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Cliente cliente) {
        boolean result = false;
        String sql = "insert into cliente (nome,cpf,endereco,usuario_idusuario) values (?,?,?,?)";
        try {
            cliente.setUsuario(usuarioDAO.adicionaUsuario(cliente.getUsuario(), Role.CLIENT));
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEndereco());
            stmt.setLong(4, cliente.getUsuario().getId());
            stmt.execute();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<Cliente> lista() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select c.idcliente,c.nome,c.cpf,c.endereco,c.usuario_idusuario"
                + " ,u.login"
                + " from cliente c"
                + " inner join usuario u on c.usuario_idusuario=u.idusuario"
                + " order by c.nome";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getLong("idcliente"));
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEndereco(rs.getString("endereco"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                cli.setUsuario(usuario);
                clientes.add(cli);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }

    public Cliente buscarClientePorId(Long id) {
        String sql = "select c.idcliente,c.nome,c.cpf,c.endereco,c.usuario_idusuario"
                + " ,u.login"
                + " from cliente c"
                + " inner join usuario u on c.usuario_idusuario=u.idusuario"
                + " where c.idcliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Cliente cliente = new Cliente();
            if (rs.next()) {
                cliente.setId(rs.getLong("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                cliente.setUsuario(usuario);
            }
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente buscarClienteByUsuario(Long idUsuario) {
        String sql = "select c.idcliente,c.nome,c.cpf,c.endereco,c.usuario_idusuario"
                + " ,u.login"
                + " from cliente c"
                + " inner join usuario u on c.usuario_idusuario=u.idusuario"
                + " where c.usuario_idusuario = ?";
        Cliente cliente = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getLong("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                cliente.setUsuario(usuario);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }

    public boolean removerCliente(Long id) {
        String sql = "delete from cliente where idcliente = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarCliente(Cliente cliente) {
        String sql = "update cliente set nome = ?,cpf = ?,endereco = ? where idcliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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
