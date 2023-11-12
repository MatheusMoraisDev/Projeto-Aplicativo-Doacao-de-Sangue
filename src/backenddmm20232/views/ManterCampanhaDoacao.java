/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.views;

import backenddmm20232.controllers.ControllerCampanhaDoacao;
import backenddmm20232.models.beans.CampanhaDoacao;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: Livia Caroline
 */
public class ManterCampanhaDoacao{

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));

        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                System.out.println("Opcao inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        int idHospital = Integer.parseInt(JOptionPane.showInputDialog("ID Hospital"));
        String nomeCampanha = JOptionPane.showInputDialog("Nome da Campanha");
        String dataInicio = JOptionPane.showInputDialog("Data de início");
        String dataFim = JOptionPane.showInputDialog("Data de conclusão");
        String descricao = JOptionPane.showInputDialog("Descrição");

        CampanhaDoacao CdEnt = new CampanhaDoacao(idHospital, nomeCampanha, dataInicio, dataFim, descricao);
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        CampanhaDoacao CdSaida = contCd.inserir(CdEnt);

        JOptionPane.showMessageDialog(null, CdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idHospital = Integer.parseInt(JOptionPane.showInputDialog("ID Hospital"));
        String nomeCampanha = JOptionPane.showInputDialog("Nome da Campanha");
        String dataInicio = JOptionPane.showInputDialog("Data de início");
        String dataFim = JOptionPane.showInputDialog("Data de conclusão");
        String descricao = JOptionPane.showInputDialog("Descrição");

        CampanhaDoacao CdEnt = new CampanhaDoacao(id, idHospital, nomeCampanha, dataInicio, dataFim, descricao);
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        CampanhaDoacao CdSaida = contCd.alterar(CdEnt);

        JOptionPane.showMessageDialog(null, CdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        CampanhaDoacao CdEnt = new CampanhaDoacao(id);
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        CampanhaDoacao CdSaida = contCd.buscar(CdEnt);

        JOptionPane.showMessageDialog(null, CdSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        CampanhaDoacao CdEnt = new CampanhaDoacao(id);
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        CampanhaDoacao CdSaida = contCd.excluir(CdEnt);

        JOptionPane.showMessageDialog(null, CdSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nomeCampanha = JOptionPane.showInputDialog("Nome da Campanha");
        CampanhaDoacao CdEnt = new CampanhaDoacao(nomeCampanha);
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        List<CampanhaDoacao> ListaCampanha = contCd.listar(CdEnt);

        for (CampanhaDoacao CdSaida : ListaCampanha) {
            JOptionPane.showMessageDialog(null, CdSaida.toString());
        }
    }
}
