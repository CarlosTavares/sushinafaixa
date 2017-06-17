/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Administrador;
import br.com.sushinafaixa.model.Role;
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
public class AdministradorDAO {

    private final Connection connection;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    public AdministradorDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Administrador adm) {
        boolean resultado = false;
        String sql = "insert into administrador (nome,usuario_idusuario) values (?,?)";
        try {
            adm.setUsuario(usuarioDAO.adicionaUsuario(adm.getUsuario(), Role.ADMIN));
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, adm.getNome());
            stmt.setLong(2, adm.getUsuario().getId());
            stmt.execute();
            resultado = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

    public List<Administrador> lista() {
        List<Administrador> admins = new ArrayList<>();
        String sql = "select a.idadministrador,a.nome,a.usuario_idusuario"
                + " ,u.login"
                + " from administrador a"
                + " inner join usuario u on a.usuario_idusuario=u.idusuario"
                + " order by a.nome";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Administrador adm = new Administrador();
                adm.setId(rs.getLong("idadministrador"));
                adm.setNome(rs.getString("nome"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                adm.setUsuario(usuario);
                admins.add(adm);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }

    public Administrador buscarAdministradorPorId(Long id) {
        String sql = "select a.idadministrador,a.nome,a.usuario_idusuario"
                + " ,u.login"
                + " from administrador a"
                + " inner join usuario u on a.usuario_idusuario=u.idusuario"
                + " where a.idadministrador = ?";
        Administrador administrador = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                administrador = new Administrador();
                administrador.setId(rs.getLong("idadministrador"));
                administrador.setNome(rs.getString("nome"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                administrador.setUsuario(usuario);
            }
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Administrador buscarAdministradorByUsuario(Long idUsuario) {
        String sql = "select a.idadministrador,a.nome,a.usuario_idusuario"
                + " ,u.login"
                + " from administrador a"
                + " inner join usuario u on a.usuario_idusuario=u.idusuario"
                + " where a.usuario_idusuario = ?";
        Administrador administrador = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                administrador = new Administrador();
                administrador.setId(rs.getLong("idadministrador"));
                administrador.setNome(rs.getString("nome"));
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("usuario_idusuario"));
                usuario.setLogin(rs.getString("login"));
                administrador.setUsuario(usuario);
            }
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerAdministrador(Long id) {
        String sql = "delete from administrador where idadministrador = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarAdministrador(Administrador administrador) {
        String sql = "update administrador set nome = ? where idadministrador = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, administrador.getNome());
            stmt.setLong(3, administrador.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
