
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.models.daos;
import backenddmm20232.models.beans.PessoaFisica;
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
public class DaoPessoaFisica {
    
    private final Connection c;
    
    public DaoPessoaFisica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoaFisica excluir(PessoaFisica pfEnt) throws SQLException{
        String sql = "delete from pessoa_fisica WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,pfEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return pfEnt;
    }
    
    public PessoaFisica buscar(PessoaFisica pfEnt) throws SQLException{
        String sql = "select * from pessoa_fisica WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,pfEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaFisica pfSaida = null;
            while (rs.next()) {      
            // criando o objeto PessoaFisica
                pfSaida = new PessoaFisica(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
            // adiciona o usu à lista de PessoaFisicas
            }
            stmt.close();
        return pfSaida;
   }

    public PessoaFisica inserir(PessoaFisica pfEnt) throws SQLException{
        String sql = "insert into pessoa_fisica" + " (nome, cpf, rg)" + " values (?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,pfEnt.getNome());
        stmt.setString(2,pfEnt.getCpf());
        stmt.setString(3,pfEnt.getRg());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pfEnt.setId(id);
        }
        stmt.close();
        return pfEnt;
    }

    public PessoaFisica alterar(PessoaFisica pfEnt) throws SQLException{
        String sql = "UPDATE pessoa_fisica SET nome = ?, servidor = ?, status = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
         // seta os valores
        stmt.setString(1,pfEnt.getNome());
        stmt.setString(2,pfEnt.getCpf());
        stmt.setString(3,pfEnt.getRg());
        stmt.setInt(4,pfEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return pfEnt;
    }

   public List<PessoaFisica> listar(PessoaFisica pfEnt) throws SQLException{
        // PessoaFisicas: array armazena a lista de registros

        List<PessoaFisica> PessoasFisicas = new ArrayList<>();
        
        String sql = "select * from pessoa_fisica where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + pfEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto PessoaFisica
            PessoaFisica pessoafisica = new PessoaFisica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
            );
            // adiciona o PessoaFisica à lista de PessoaFisicas
            PessoasFisicas.add(pessoafisica);
        }
        
        rs.close();
        stmt.close();
        return PessoasFisicas;
   
   }
    
}
