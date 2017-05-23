/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Categoria;
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
public class CategoriaDAO {

    private final Connection connection;

    @Autowired
    public CategoriaDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Categoria categoria) {
        String sql = "insert into categoria (descricao) values (?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getDescricao());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Categoria> lista() {
        List<Categoria> categorias = new ArrayList<Categoria>();
        String sql = "select * from categoria order by descricao";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getLong("idcategoria"));
                cat.setDescricao(rs.getString("descricao"));
                categorias.add(cat);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }

    public Categoria buscarCategoriaPorId(Long id) {
        String sql = "select * from categoria where idcategoria = ? ";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Categoria categoria = new Categoria();
            if (rs.next()) {
                categoria.setId(rs.getLong("idcategoria"));
                categoria.setDescricao(rs.getString("descricao"));

            }
            return categoria;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerCategoria(Long id) {
        String sql = "delete from categoria where idcategoria = ? ";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarCategoria(Categoria categoria) {
        String sql = "update categoria set descricao = ? where idcategoria = ?";
        try (
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getDescricao());
            stmt.setLong(2, categoria.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}
