/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Curriculo;
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
public class CurriculoDAO {

    private final Connection connection;

    @Autowired
    public CurriculoDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Curriculo curriculo) {
        String sql = "insert into curriculo (nome,email,arquivo) values (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, curriculo.getNome());
            stmt.setString(2, curriculo.getEmail());
            stmt.setString(3, curriculo.getArquivoPath());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Curriculo> lista() {
        List<Curriculo> curriculos = new ArrayList<Curriculo>();
        String sql = "select * from curriculo order by nome";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Curriculo cur = new Curriculo();
                cur.setId(rs.getLong("idcurriculo"));
                cur.setNome(rs.getString("nome"));
                cur.setEmail(rs.getString("email"));
                cur.setArquivoPath(rs.getString("arquivo"));
                curriculos.add(cur);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curriculos;
    }

    public Curriculo buscarCurriculoPorId(Long id) {
        String sql = "select * from curriculo where idcurriculo = ? ";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            Curriculo curriculo = new Curriculo();
            if (rs.next()) {
                curriculo.setId(rs.getLong("idcurriculo"));
                curriculo.setNome(rs.getString("nome"));
                curriculo.setEmail(rs.getString("email"));
                curriculo.setArquivoPath(rs.getString("arquivo"));
            }
            return curriculo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerCurriculo(Long id) {
        String sql = "delete from curriculo where idcurriculo = ? ";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarCurriculo(Curriculo curriculo) {
        String sql = "update curriculo set nome = ?, email = ?, arquivo = ? where idcurriculo = ?";
        try (
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, curriculo.getNome());
            stmt.setString(2, curriculo.getEmail());
            stmt.setString(3, curriculo.getArquivoPath());
            stmt.setLong(4, curriculo.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
