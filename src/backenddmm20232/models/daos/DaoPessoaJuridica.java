/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.daos;

import backenddmm20232.models.beans.PessoaJuridica;
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
public class DaoPessoaJuridica {

    private final Connection c;
    
    public DaoPessoaJuridica() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public PessoaJuridica excluir(PessoaJuridica PjEnt) throws SQLException{
        String sql = "delete from pessoa_juridica WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,PjEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return PjEnt;
    }
    
    public PessoaJuridica buscar(PessoaJuridica PjEnt) throws SQLException{
        String sql = "select * from pessoa_juridica WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,PjEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            PessoaJuridica PjSaida = null;
            while (rs.next()) {      
            // criando o objeto PessoaJuridica
                PjSaida = new PessoaJuridica(
                    rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7));
            // adiciona o usu à lista de PessoaJuridica
            }
            stmt.close();
        return PjSaida;
   }

    public PessoaJuridica inserir(PessoaJuridica PjEnt) throws SQLException{
        String sql = "insert into pessoa_juridica" + " (razao_social, nome_fantasia, cnpj, ie, endereco, telefone, email)" + " values (?,?,?,?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,PjEnt.getRazaoSocial());
        stmt.setString(2,PjEnt.getNomeFantasia());
        stmt.setString(3,PjEnt.getCnpj());
        stmt.setString(4,PjEnt.getIe());
        stmt.setString(5,PjEnt.getEndereco());
        stmt.setString(6,PjEnt.getTelefone());
        stmt.setString(7,PjEnt.getEmail());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            PjEnt.setId(id);
        }
        stmt.close();
        return PjEnt;
    }

    public PessoaJuridica alterar(PessoaJuridica PjEnt) throws SQLException{
        String sql = "UPDATE pessoa_juridica SET razao_social = ?, nome_fantasia = ?, cnpj = ?, ie = ?, endereco = ?, telefone =  ?, email = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,PjEnt.getRazaoSocial());
        stmt.setString(2,PjEnt.getNomeFantasia());
        stmt.setString(3,PjEnt.getCnpj());
        stmt.setString(4,PjEnt.getIe());
        stmt.setString(5,PjEnt.getEndereco());
        stmt.setString(6,PjEnt.getTelefone());
        stmt.setString(7, PjEnt.getEmail());
        stmt.setInt(8,PjEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return PjEnt;
    }

   public List<PessoaJuridica> listar(PessoaJuridica PjEnt) throws SQLException{
        // pessoa_juridica: array armazena a lista de registros

        List<PessoaJuridica> pessoa_juridica = new ArrayList<>();
        
        String sql = "select * from pessoa_juridica where nome_fantasia like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + PjEnt.getNomeFantasia() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto PessoaJuridica
            PessoaJuridica PessoaJuridica = new PessoaJuridica(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8)
            );
            // adiciona o PessoaJuridica à lista de pessoa_juridica
            pessoa_juridica.add(PessoaJuridica);
        }
        
        rs.close();
        stmt.close();
        return pessoa_juridica;
   
   }
}