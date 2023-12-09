/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;
import backenddmm20232.models.beans.CampanhaJuridica;
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
 * @author Livia
 */
public class DaoCampanhaJuridica {
   private final Connection c;
    
    public DaoCampanhaJuridica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public CampanhaJuridica inserir(CampanhaJuridica Cdpj) throws SQLException{
        String sql = "insert into campanhajuridica" + " (idpj, idcd, endereco, data, descricao)" + " values (?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // seta os valores
        stmt.setInt(1,Cdpj.getIdpj());
        stmt.setInt(2,Cdpj.getIdcd());
        stmt.setString(3,Cdpj.getEndereco());
        stmt.setString(4,Cdpj.getData());
        stmt.setString(5,Cdpj.getDescricao());
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            Cdpj.setId(id);
        }
        stmt.close();
        return Cdpj;
    }

    public CampanhaJuridica alterar(CampanhaJuridica Cdpj) throws SQLException{
        String sql = "UPDATE campanhajuridica SET idpj = ?, idcd = ?, endereco = ?, data = ?, descricao = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,Cdpj.getIdpj());
        stmt.setInt(2,Cdpj.getIdcd());
        stmt.setString(3,Cdpj.getEndereco());
        stmt.setString(4,Cdpj.getData());
        stmt.setString(5,Cdpj.getDescricao());
        stmt.setInt(6, Cdpj.getId());

        // executa
        stmt.execute();
        stmt.close();
        return Cdpj;
    }

    public CampanhaJuridica buscar(CampanhaJuridica Cdpj) throws SQLException{
        String sql = "select * from campanhajuridica WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,Cdpj.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            CampanhaJuridica CdpjSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                CdpjSaida = new CampanhaJuridica(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
           // adiciona o usu à lista de usus
            }
            stmt.close();
        return CdpjSaida;

    }

    public CampanhaJuridica excluir(CampanhaJuridica Cdpj) throws SQLException{
        String sql = "delete from campanhajuridica WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,Cdpj.getId());
        // executa
        stmt.execute();
        stmt.close();
        return Cdpj;

    }

    public List<CampanhaJuridica> listar(CampanhaJuridica Cdpj) throws SQLException{
        // usus: array armazena a lista de registros

        List<CampanhaJuridica> cdpj = new ArrayList<>();
        
        String sql = "select * from campanhajuridica where descricao like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + Cdpj.getDescricao()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            CampanhaJuridica Cd = new CampanhaJuridica(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6));
            // adiciona o usu à lista de usus
            cdpj.add(Cd);
        }
        
        rs.close();
        stmt.close();
        return cdpj;

    }
    
}
 

