/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sushinafaixa.dao;

import br.com.sushinafaixa.bean.Administrador;
import br.com.sushinafaixa.bean.Categoria;
import br.com.sushinafaixa.bean.Produto;
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
public class ProdutoDAO {

    private final Connection connection;

    @Autowired
    public ProdutoDAO(DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adiciona(Produto produto) {
        String sql = "insert into produto (descricao,preco,imagem,categoria_idcategoria,administrador_idadministrador) values (?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getImagemPath());
            stmt.setLong(4, produto.getCategoria().getId());
            stmt.setLong(5, produto.getAdministrador().getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public List<Produto> lista() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select idproduto,prd.descricao as descricao,preco,imagem"
                + ",categoria_idcategoria,cat.descricao as catdescricao"
                + ",administrador_idadministrador,nome"
                + " from produto prd "
                + " left join categoria cat on prd.categoria_idcategoria=cat.idcategoria"
                + " left join administrador adm on prd.administrador_idadministrador=adm.idadministrador"
                + " order by descricao";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getLong("idProduto"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setImagemPath(rs.getString("imagem"));
                Categoria cat = new Categoria();
                prod.setCategoria(cat);
                prod.getCategoria().setId(rs.getLong("categoria_idcategoria"));
                prod.getCategoria().setDescricao(rs.getString("catdescricao"));
                Administrador adm = new Administrador();
                prod.setAdministrador(adm);
                prod.getAdministrador().setId(rs.getLong("administrador_idadministrador"));
                prod.getAdministrador().setNome(rs.getString("nome"));
                produtos.add(prod);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public List<Produto> lista(Long idCategoria) {
        List<Produto> produtos = new ArrayList<>();
        String sql = "select idproduto,prd.descricao as descricao,preco,imagem"
                + ",prd.categoria_idcategoria,cat.descricao as catdescricao"
                + ",prd.administrador_idadministrador,adm.nome"
                + " from produto prd"
                + " left join categoria cat on prd.categoria_idcategoria=cat.idcategoria"
                + " left join administrador adm on prd.administrador_idadministrador=adm.idadministrador"
                + " where prd.categoria_idcategoria = ?"
                + " order by prd.descricao";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getLong("idProduto"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setImagemPath(rs.getString("imagem"));
                Categoria cat = new Categoria();
                prod.setCategoria(cat);
                prod.getCategoria().setId(rs.getLong("categoria_idcategoria"));
                prod.getCategoria().setDescricao(rs.getString("catdescricao"));
                Administrador adm = new Administrador();
                prod.setAdministrador(adm);
                prod.getAdministrador().setId(rs.getLong("administrador_idadministrador"));
                prod.getAdministrador().setNome(rs.getString("nome"));
                produtos.add(prod);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public Produto buscarProdutoPorId(Long id) {
        String sql = "select idproduto,prd.descricao as descricao,preco,imagem"
                + ",categoria_idcategoria,cat.descricao as catdescricao"
                + ",administrador_idadministrador,nome"
                + " from produto prd "
                + " left join categoria cat on prd.categoria_idcategoria=cat.idcategoria "
                + " left join administrador adm on prd.administrador_idadministrador=adm.idadministrador "
                + " where idproduto = ? "
                + " order by descricao";
        Produto prod = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                prod = new Produto();
                prod.setId(rs.getLong("idProduto"));
                prod.setDescricao(rs.getString("descricao"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setImagemPath(rs.getString("imagem"));
                Categoria cat = new Categoria();
                prod.setCategoria(cat);
                prod.getCategoria().setId(rs.getLong("categoria_idcategoria"));
                prod.getCategoria().setDescricao(rs.getString("catdescricao"));
                Administrador adm = new Administrador();
                prod.setAdministrador(adm);
                prod.getAdministrador().setId(rs.getLong("administrador_idadministrador"));
                prod.getAdministrador().setNome(rs.getString("nome"));
            }
            return prod;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerProduto(Long id) {
        String sql = "delete from produto where idproduto = ? ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean alterarProduto(Produto produto) {
        String sql = "update produto set descricao = ?, preco = ?, imagem = ?"
                + ", categoria_idcategoria = ?, administrador_idadministrador = ? where idproduto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getImagemPath());
            stmt.setLong(4, produto.getCategoria().getId());
            stmt.setLong(5, produto.getAdministrador().getId());
            stmt.setLong(6, produto.getId());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
