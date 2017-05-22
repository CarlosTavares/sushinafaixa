/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Mensagem;
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
public class MensagemDAO {

    private final Connection connection;

    @Autowired
    public MensagemDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Mensagem mensagem) {
        String sql = "insert into mensagem (motivo, conteudo) values (?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, mensagem.getMotivo());
            stmt.setString(2, mensagem.getConteudo());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Mensagem> lista() {
        List<Mensagem> mensagens = new ArrayList<Mensagem>();
        String sql = "select * from mensagem order by motivo";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Mensagem msg = new Mensagem();
                msg.setId(rs.getLong("idmensagem"));
                msg.setMotivo(rs.getString("motivo"));
                msg.setConteudo(rs.getString("conteudo"));
                mensagens.add(msg);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mensagens;
    }
}
