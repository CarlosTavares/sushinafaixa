/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Usuario;
import br.com.sushinafaixa.model.Role;
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
public class LoginDAO {

    private final Connection connection;

    @Autowired

    public LoginDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validaUsuario(Usuario usuario) {
        String sql = "select u.idusuario,u.login,u.senha "//
                + " from usuario u where u.login = ? ";

        boolean resultado = false;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, usuario.getLogin());
            ResultSet rs = stmt.executeQuery();
            resultado = rs.next();
            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario buscaUsuarioByLogin(String login, String senha) {
        String sql = "select u.idusuario,u.login,u.senha,u.role "//
                + " from usuario u where u.login = ? and u.senha = ?";
        Usuario user = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = new Usuario();
                user.setId(rs.getLong("idusuario"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setRole(Enum.valueOf(Role.class, rs.getString("role")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
