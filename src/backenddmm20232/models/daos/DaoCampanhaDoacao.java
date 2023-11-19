/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.models.daos;
import backenddmm20232.models.beans.CampanhaDoacao;
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
public class DaoCampanhaDoacao {

    private final Connection c;

    public DaoCampanhaDoacao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public CampanhaDoacao excluir(CampanhaDoacao CdEnt) throws SQLException {
        String sql = "delete from campanha_doacao WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, CdEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return CdEnt;
    }

    public CampanhaDoacao buscar(CampanhaDoacao CdEnt) throws SQLException {
        String sql = "select * from campanha_doacao WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, CdEnt.getId());
        // executa
        ResultSet rs = stmt.executeQuery();
        CampanhaDoacao CdSaida = null;
        while (rs.next()) {
            // criando o objeto CampanhaDoacao
            CdSaida = new CampanhaDoacao(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));

            // adiciona o usu à lista de CampanhaDoacao
        }
        stmt.close();
        return CdSaida;
    }

    public CampanhaDoacao inserir(CampanhaDoacao CdEnt) throws SQLException {
        String sql = "insert into campanha_doacao" + " (id_hospital, nome_campanha, data_inicio, data_fim, descricao)" + " values (?,?,?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1, CdEnt.getIdHospital());
        stmt.setString(2, CdEnt.getNomeCampanha());
        stmt.setString(3, CdEnt.getDataInicio());
        stmt.setString(4, CdEnt.getDataFim());
        stmt.setString(5, CdEnt.getDescricao());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            CdEnt.setId(id);
        }
        stmt.close();
        return CdEnt;
    }

    public CampanhaDoacao alterar(CampanhaDoacao CdEnt) throws SQLException {
        String sql = "UPDATE campanha_doacao SET id_hospital = ?, nome_campanha = ?, descricao = ?, data_inicio = ?, data_fim = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1, CdEnt.getIdHospital());
        stmt.setString(2, CdEnt.getNomeCampanha());
        stmt.setString(3, CdEnt.getDataInicio());
        stmt.setString(4, CdEnt.getDataFim());
        stmt.setString(5, CdEnt.getDescricao());
        stmt.setInt(6, CdEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return CdEnt;
    }

    public List<CampanhaDoacao> listar(CampanhaDoacao CdEnt) throws SQLException {
        // estoque_sangue: array armazena a lista de registros

        List<CampanhaDoacao> campanha_doacao = new ArrayList<>();

        String sql = "select * from campanha_doacao where nome_campanha like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%" + CdEnt.getNomeCampanha() + "%");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // criando o objeto EstoqueSangue
            CampanhaDoacao CampanhaDoacao = new CampanhaDoacao(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6));
            // adiciona o EstoqueSangue à lista de estoque_sangue
            campanha_doacao.add(CampanhaDoacao);
        }

        rs.close();
        stmt.close();
        return campanha_doacao;
    }
}
