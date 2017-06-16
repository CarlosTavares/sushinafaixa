/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Role;
import br.com.sushinafaixa.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos.Tavares
 */
@Repository
public class UsuarioDAO {

    private final Connection connection;

    @Autowired
    public UsuarioDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario adicionaUsuario(Usuario usuario, Role role) throws SQLException {
        String sql = "insert into usuario (login,senha,role) values (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, usuario.getLogin());
        stmt.setString(2, usuario.getSenha());
        stmt.setString(3, role.toString());
        stmt.execute();
        usuario.setId(this.getMaxUsuario());
        return usuario;
    }

    public boolean removerUsuario(Long id) throws SQLException {
        String sql = "delete from usuario where idusuario = ? ";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        return true;
    }

    public Long getMaxUsuario() throws SQLException {
        Long id = new Long(0);
        String sql = "select MAX(u.idUsuario) as idUsuario from usuario u";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            id = rs.getLong("idUsuario");
        }
        return id;
    }
}
