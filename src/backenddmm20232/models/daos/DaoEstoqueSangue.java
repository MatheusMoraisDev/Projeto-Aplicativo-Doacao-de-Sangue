/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.EstoqueSangue;
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
 * @author Mauricio Calassara
 */
public class DaoEstoqueSangue {

    private final Connection c;
    
    public DaoEstoqueSangue() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public EstoqueSangue excluir(EstoqueSangue EsEnt) throws SQLException{
        String sql = "delete from estoque_sangue WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,EsEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return EsEnt;
    }
    
    public EstoqueSangue buscar(EstoqueSangue EsEnt) throws SQLException{
        String sql = "select * from estoque_sangue WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,EsEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            EstoqueSangue EsSaida = null;
            while (rs.next()) {      
            // criando o objeto EstoqueSangue
                EsSaida = new EstoqueSangue(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de EstoqueSangue
            }
            stmt.close();
        return EsSaida;
   }

    public EstoqueSangue inserir(EstoqueSangue EsEnt) throws SQLException{
        String sql = "insert into estoque_sangue" + " (id_banco, tipo_sanguineo, quantidade_disponivel, data_validade)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,EsEnt.getIdBanco());
        stmt.setString(2,EsEnt.getTs());
        stmt.setInt(3,EsEnt.getQtd());
        stmt.setString(4,EsEnt.getDv());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            EsEnt.setId(id);
        }
        stmt.close();
        return EsEnt;
    }

    public EstoqueSangue alterar(EstoqueSangue EsEnt) throws SQLException{
        String sql = "UPDATE estoque_sangue SET id_banco = ?, tipo_sanguineo = ?, quantidade_disponivel = ?, data_validade = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,EsEnt.getIdBanco());
        stmt.setString(2,EsEnt.getTs());
        stmt.setInt(3,EsEnt.getQtd());
        stmt.setString(4,EsEnt.getDv());
        stmt.setInt(5,EsEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return EsEnt;
    }

   public List<EstoqueSangue> listar(EstoqueSangue EsEnt) throws SQLException{
        // estoque_sangue: array armazena a lista de registros

        List<EstoqueSangue> estoque_sangue = new ArrayList<>();
        
        String sql = "select * from estoque_sangue where tipo_sanguineo like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + EsEnt.getTs() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto EstoqueSangue
            EstoqueSangue EstoqueSangue = new EstoqueSangue(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o EstoqueSangue à lista de estoque_sangue
            estoque_sangue.add(EstoqueSangue);
        }
        
        rs.close();
        stmt.close();
        return estoque_sangue;
   
   }
}