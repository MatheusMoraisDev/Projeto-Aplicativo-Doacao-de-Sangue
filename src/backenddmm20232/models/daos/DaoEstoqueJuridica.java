/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;
import backenddmm20232.models.beans.EstoqueJuridica;
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
public class DaoEstoqueJuridica {
   private final Connection c;
    
    public DaoEstoqueJuridica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public EstoqueJuridica inserir(EstoqueJuridica esPj) throws SQLException{
        String sql = "insert into estoque_juridica " + " ( ides, idpj, razao_social, tipo_sanguineo)" + " values (?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        // seta os valores
        stmt.setInt(1,esPj.getIdes());
        stmt.setInt(2,esPj.getIdpj());
        stmt.setString(3,esPj.getRazaoSocial());
        stmt.setString(4,esPj.getTipoSanguineo());
        
        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            esPj.setId(id);
        }
        stmt.close();
        return esPj;
    }

    public EstoqueJuridica alterar(EstoqueJuridica esPj) throws SQLException{
        String sql = "UPDATE estoque_juridica SET ides = ?, idpj = ?, razao_social = ?, tipo_sanguineo = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,esPj.getIdpj());
        stmt.setInt(2,esPj.getIdes());
        stmt.setString(3,esPj.getRazaoSocial());
        stmt.setString(4,esPj.getTipoSanguineo());
        stmt.setInt(5, esPj.getId());

        // executa
        stmt.execute();
        stmt.close();
        return esPj;
    }

    public EstoqueJuridica buscar(EstoqueJuridica esPj) throws SQLException{
        String sql = "select * from estoque_juridica WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,esPj.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            EstoqueJuridica esPjSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                esPjSaida = new EstoqueJuridica(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return esPjSaida;

    }

    public EstoqueJuridica excluir(EstoqueJuridica esPj) throws SQLException{
        String sql = "delete from estoque_juridica WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,esPj.getId());
        // executa
        stmt.execute();
        stmt.close();
        return esPj;

    }

    public List<EstoqueJuridica> listar(EstoqueJuridica esPj) throws SQLException{
        // usus: array armazena a lista de registros

        List<EstoqueJuridica> espj = new ArrayList<>();
        
        String sql = "select * from estoque_juridica where razao_social like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + esPj.getRazaoSocial()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            EstoqueJuridica Ej = new EstoqueJuridica(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getString(5));
            espj.add(Ej);
        }
        
        rs.close();
        stmt.close();
        return espj;

    }
    
}
 

