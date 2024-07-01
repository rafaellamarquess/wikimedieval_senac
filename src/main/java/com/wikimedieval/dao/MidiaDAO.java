package com.wikimedieval.dao;

import com.wikimedieval.model.Midia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MidiaDAO {
    public List<Midia> buscarMidiasPorTipo(String tipo) {
        List<Midia> midias = new ArrayList<>();
        String query = "SELECT * FROM midias WHERE tipo=?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                final var midia = new Midia(
                        rs.getString("titulo"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getString("autor_diretor"),
                        rs.getInt("ano_lancamento"));
                midia.setId(rs.getInt("id"));
                midias.add(midia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return midias;
    }

    public void adicionarMidia(Midia midia) {
        String query = "INSERT INTO midias (titulo, tipo, descricao, autor_diretor, ano_lancamento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, midia.getTitulo());
            stmt.setString(2, midia.getTipo());
            stmt.setString(3, midia.getDescricao());
            stmt.setString(4, midia.getAutor_diretor());
            stmt.setInt(5, midia.getAno_lancamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarMidia ( int id) {
        String query = "DELETE FROM midias WHERE id=?;";
        try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
           stmt.setInt(1, id);
           stmt.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}