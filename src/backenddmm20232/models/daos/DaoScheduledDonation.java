/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.ScheduledDonation;
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
 * @author Matheus Morais
 */
public class DaoScheduledDonation {

    private final Connection c;
    
    public DaoScheduledDonation() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public ScheduledDonation excluir(ScheduledDonation sdEnt) throws SQLException{
        String sql = "delete from scheduled_donations WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sdEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return sdEnt;
    }
    
    public ScheduledDonation buscar(ScheduledDonation sdEnt) throws SQLException{
        String sql = "select * from scheduled_donations WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sdEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            ScheduledDonation sdSaida = null;
            while (rs.next()) {      
            // criando o objeto ScheduledDonation
                sdSaida = new ScheduledDonation(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de scheduled_donations
            }
            stmt.close();
        return sdSaida;
   }

    public ScheduledDonation inserir(ScheduledDonation sdEnt) throws SQLException{
        String sql = "insert into scheduled_donations" + " (id_doador, data, status)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,sdEnt.getIdDoador());
        stmt.setString(2,sdEnt.getData());
        stmt.setString(3,sdEnt.getStatus());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            sdEnt.setId(id);
        }
        stmt.close();
        return sdEnt;
    }

    public ScheduledDonation alterar(ScheduledDonation sdEnt) throws SQLException{
        String sql = "UPDATE scheduled_donations SET id_doador = ?, data = ?, status = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sdEnt.getIdDoador());
        stmt.setString(2,sdEnt.getData());
        stmt.setString(3,sdEnt.getStatus());
        stmt.setInt(4,sdEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return sdEnt;
    }

   public List<ScheduledDonation> listar(ScheduledDonation sdEnt) throws SQLException{
        // scheduled_donations: array armazena a lista de registros

        List<ScheduledDonation> scheduled_donations = new ArrayList<>();
        
        String sql = "select * from scheduled_donations where data like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + sdEnt.getData() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto ScheduledDonation
            ScheduledDonation ScheduledDonation = new ScheduledDonation(
                rs.getInt(1),
                rs.getInt(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o ScheduledDonation à lista de scheduled_donations
            scheduled_donations.add(ScheduledDonation);
        }
        
        rs.close();
        stmt.close();
        return scheduled_donations;
   
   }
}
