/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.UsuariosFeedback;
import backenddmm20232.util.ConexaoDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class DaoUsuariosFeedback {
    
    private final Connection c;
    
    public DaoUsuariosFeedback() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public UsuariosFeedback inserir(UsuariosFeedback usuFd) throws SQLException{
        String sql = "insert into usuariosfeedback" + " (idUsu, idFd, tipo, status, classificacao, comentario)" + " values (?,?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // seta os valores
        stmt.setInt(1,usuFd.getIdUsu());
        stmt.setInt(2,usuFd.getIdFd());
        stmt.setString(3,usuFd.getTipo());
        stmt.setString(4,usuFd.getStatus());
        stmt.setString(5,usuFd.getClassificacao());
        stmt.setString(6,usuFd.getComentario());
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuFd.setId(id);
        }
        stmt.close();
        return usuFd;
    }

    public UsuariosFeedback alterar(UsuariosFeedback usuFd) throws SQLException{
        String sql = "UPDATE usuariosfeedback SET idUsu = ?, idFd = ?, tipo = ?, status = ?, classificacao = ?, comentario = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuFd.getIdUsu());
        stmt.setInt(2,usuFd.getIdFd());
        stmt.setString(3,usuFd.getTipo());
        stmt.setString(4,usuFd.getStatus());
        stmt.setString(5,usuFd.getClassificacao());
        stmt.setString(6,usuFd.getComentario());
        stmt.setInt(7,usuFd.getId());
        // executa
        stmt.execute();
        stmt.close();
        return usuFd;
    }

    public UsuariosFeedback buscar(UsuariosFeedback usuFd) throws SQLException{
        String sql = "select * from usuariosfeedback WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuFd.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuariosFeedback usuFdSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuFdSaida = new UsuariosFeedback(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                rs.getString(7));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuFdSaida;

    }

    public UsuariosFeedback excluir(UsuariosFeedback usuFd) throws SQLException{
        String sql = "delete from usuariosfeedback WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuFd.getId());
        // executa
        stmt.execute();
        stmt.close();
        return usuFd;

    }

    public List<UsuariosFeedback> listar(UsuariosFeedback usuFd) throws SQLException{
        // usus: array armazena a lista de registros

        List<UsuariosFeedback> usufd = new ArrayList<>();
        
        String sql = "select * from usuariosfeedback where classificacao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuFd.getClassificacao()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuariosFeedback us = new UsuariosFeedback(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7)
            );
            // adiciona o usu à lista de usus
            usufd.add(us);
        }
        
        rs.close();
        stmt.close();
        return usufd;

    }
    
}
