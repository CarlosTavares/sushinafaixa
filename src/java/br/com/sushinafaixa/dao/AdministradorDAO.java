/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Administrador;
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
    public AdministradorDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Administrador adm) {
        String sql = "insert into administrador (nome, login) values (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, adm.getNome());
            stmt.setString(2, adm.getLogin());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Administrador> lista() {
        List<Administrador> admins = new ArrayList<Administrador>();
        String sql = "select * from administrador order by nome";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Administrador adm = new Administrador();
                adm.setId(rs.getLong("idadministrador"));
                adm.setNome(rs.getString("nome"));
                adm.setLogin(rs.getString("login"));
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
        String sql = "select * from administrador where idadministrador = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Administrador administrador = new Administrador();
            if (rs.next()) {
                administrador.setId(rs.getLong("idadministrador"));
                administrador.setNome(rs.getString("nome"));
                administrador.setLogin(rs.getString("login"));
            }
            return administrador;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerAdministrador(Long id) {
        String sql = "delete from administrador where idadministrador = ? ";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarAdministrador(Administrador administrador) {
        String sql = "update administrador set nome = ?, login = ? where idadministrador = ?";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, administrador.getNome());
            stmt.setString(2, administrador.getLogin());
            stmt.setLong(3, administrador.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
