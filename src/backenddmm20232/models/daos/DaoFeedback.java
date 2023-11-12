/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.models.daos;

import backenddmm20232.models.beans.Feedback;
import backenddmm20232.util.ConexaoDb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Livia Caroline
 */
public class DaoFeedback {

    private final Connection c;

    public DaoFeedback() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Feedback excluir(Feedback FdEnt) throws SQLException {
        String sql = "delete from feedback WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, FdEnt.getId());
        stmt.execute();
        stmt.close();
        c.close();
        return FdEnt;
    }

    public Feedback buscar(Feedback FdEnt) throws SQLException {
        String sql = "select * from feedback WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, FdEnt.getId());
        ResultSet rs = stmt.executeQuery();
        Feedback FdSaida = null;
        while (rs.next()) {
            FdSaida = new Feedback(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
        }
        stmt.close();
        return FdSaida;
    }

    public Feedback inserir(Feedback FdEnt) throws SQLException {
        String sql = "insert into feedback" + " (id_usuario, classificacao, comentario, data)" + " values (?,?,?,?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, FdEnt.getIdUsuario());
        stmt.setString(2, FdEnt.getClassificacao());
        stmt.setString(3, FdEnt.getComentario());
        stmt.setString(4, FdEnt.getData());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            FdEnt.setId(id);
        }
        stmt.close();
        return FdEnt;
    }

    public Feedback alterar(Feedback FdEnt) throws SQLException {
        String sql = "UPDATE feedback SET id_usuario = ?, classificacao = ?, comentario = ?, data = ? WHERE id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, FdEnt.getIdUsuario());
        stmt.setString(2, FdEnt.getClassificacao());
        stmt.setString(3, FdEnt.getComentario());
        stmt.setString(4, FdEnt.getData());
        stmt.setInt(5, FdEnt.getId());
        stmt.execute();
        stmt.close();
        return FdEnt;
    }

    public List<Feedback> listar(Feedback FdEnt) throws SQLException {
        List<Feedback> feedback = new ArrayList<>();
        String sql = "select * from feedback where classificacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + FdEnt.getClassificacao() + "%");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Feedback Feedback = new Feedback(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            feedback.add(Feedback);
        }
        rs.close();
        stmt.close();
        return feedback;
    }
}
