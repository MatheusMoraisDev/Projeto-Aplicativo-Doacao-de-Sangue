/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.Sistema;
import backenddmm20232.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class DaoSistema {

    private final Connection c;
    
    public DaoSistema() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Sistema excluir(Sistema sisEnt) throws SQLException{
        String sql = "delete from sistemas WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sisEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return sisEnt;
    }
    
    public Sistema buscar(Sistema sisEnt) throws SQLException{
        String sql = "select * from sistemas WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sisEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Sistema sisSaida = null;
            while (rs.next()) {      
            // criando o objeto Sistema
                sisSaida = new Sistema(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de sistemas
            }
            stmt.close();
        return sisSaida;
   }

    public Sistema inserir(Sistema sisEnt) throws SQLException{
        String sql = "insert into sistemas" + " (nome, servidor, status)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,sisEnt.getNome());
        stmt.setString(2,sisEnt.getServidor());
        stmt.setString(3,sisEnt.getStatus());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            sisEnt.setId(id);
        }
        stmt.close();
        return sisEnt;
    }

    public Sistema alterar(Sistema sisEnt) throws SQLException{
        String sql = "UPDATE sistemas SET nome = ?, servidor = ?, status = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
         // seta os valores
        stmt.setString(1,sisEnt.getNome());
        stmt.setString(2,sisEnt.getServidor());
        stmt.setString(3,sisEnt.getStatus());
        stmt.setInt(4,sisEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return sisEnt;
    }

   public List<Sistema> listar(Sistema sisEnt) throws SQLException{
        // sistemas: array armazena a lista de registros

        List<Sistema> sistemas = new ArrayList<>();
        
        String sql = "select * from sistemas where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + sisEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Sistema
            Sistema sistema = new Sistema(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o sistema à lista de sistemas
            sistemas.add(sistema);
        }
        
        rs.close();
        stmt.close();
        return sistemas;
   
   }
    
}