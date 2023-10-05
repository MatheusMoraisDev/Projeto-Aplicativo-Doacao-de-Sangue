/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.TransactionDonation;
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
public class DaoTransactionDonation {

    private final Connection c;
    
    public DaoTransactionDonation() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public TransactionDonation excluir(TransactionDonation tdEnt) throws SQLException{
        String sql = "delete from transaction_donations WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,tdEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return tdEnt;
    }
    
    public TransactionDonation buscar(TransactionDonation tdEnt) throws SQLException{
        String sql = "select * from transaction_donations WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,tdEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            TransactionDonation tdSaida = null;
            while (rs.next()) {      
            // criando o objeto TransactionDonation
                tdSaida = new TransactionDonation(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o usu à lista de transaction_donations
            }
            stmt.close();
        return tdSaida;
   }

    public TransactionDonation inserir(TransactionDonation tdEnt) throws SQLException{
        String sql = "insert into transaction_donations" + " (id_doador, id_hospital, qtd, data, teste)" + " values (?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,tdEnt.getId_doador());
        stmt.setInt(2,tdEnt.getId_hospital());
        stmt.setInt(3,tdEnt.getQtd());
        stmt.setString(4,tdEnt.getData());
        stmt.setString(5,tdEnt.getTeste());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            tdEnt.setId(id);
        }
        stmt.close();
        return tdEnt;
    }

    public TransactionDonation alterar(TransactionDonation tdEnt) throws SQLException{
        String sql = "UPDATE transaction_donations SET id_doador = ?, id_hospital = ?, qtd = ?, data = ?, teste = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,tdEnt.getId_doador());
        stmt.setInt(2,tdEnt.getId_hospital());
        stmt.setInt(3,tdEnt.getQtd());
        stmt.setString(4,tdEnt.getData());
        stmt.setString(5,tdEnt.getTeste());
        stmt.setInt(6,tdEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return tdEnt;
    }

   public List<TransactionDonation> listar(TransactionDonation tdEnt) throws SQLException{
        // transaction_donations: array armazena a lista de registros

        List<TransactionDonation> transaction_donations = new ArrayList<>();
        
        String sql = "select * from transaction_donations where data like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + tdEnt.getData() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto TransactionDonation
            TransactionDonation TransactionDonation = new TransactionDonation(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6));
            // adiciona o TransactionDonation à lista de transaction_donations
            transaction_donations.add(TransactionDonation);
        }
        
        rs.close();
        stmt.close();
        return transaction_donations;
   
   }
}
