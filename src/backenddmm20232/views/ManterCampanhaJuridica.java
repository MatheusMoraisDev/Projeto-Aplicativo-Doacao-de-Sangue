/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerCampanhaJuridica;
import backenddmm20232.models.beans.CampanhaJuridica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class ManterCampanhaJuridica {
    
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
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
        int idpj = Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA JURÍDICA"));
        int idcd= Integer.parseInt(JOptionPane.showInputDialog("ID CAMPANHA DOAÇÃO"));
        String endereco = JOptionPane.showInputDialog("ENDEREÇO");
        String data = JOptionPane.showInputDialog("DATAS");
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");
        CampanhaJuridica CdpjEnt = new CampanhaJuridica(idpj, idcd,endereco,data, descricao);
        ControllerCampanhaJuridica contCdpj = new ControllerCampanhaJuridica();
        CampanhaJuridica CdpjSaida = contCdpj.inserir(CdpjEnt);
        JOptionPane.showMessageDialog(null,CdpjSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idpj = Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA JURÍDICA"));
        int idcd= Integer.parseInt(JOptionPane.showInputDialog("ID CAMPANHA DOAÇÃO"));
        String endereco = JOptionPane.showInputDialog("ENDEREÇO");
        String data = JOptionPane.showInputDialog("DATAS");
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");
        CampanhaJuridica CdpjEnt = new CampanhaJuridica(id,idpj, idcd, endereco, data, descricao);
        ControllerCampanhaJuridica contCdpj = new ControllerCampanhaJuridica();
        CampanhaJuridica CdpjSaida = contCdpj.alterar(CdpjEnt);
        JOptionPane.showMessageDialog(null,CdpjSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        CampanhaJuridica CdpjEnt = new CampanhaJuridica(id);
        ControllerCampanhaJuridica contCdpj = new ControllerCampanhaJuridica();
        CampanhaJuridica CdpjSaida = contCdpj.buscar(CdpjEnt);
        JOptionPane.showMessageDialog(null,CdpjSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        CampanhaJuridica CdpjEnt = new CampanhaJuridica(id);
        ControllerCampanhaJuridica contCdpj = new ControllerCampanhaJuridica();
        CampanhaJuridica CdpjSaida = contCdpj.excluir(CdpjEnt);
        JOptionPane.showMessageDialog(null,CdpjSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String descricao = JOptionPane.showInputDialog("DESCRIÇÃO");
        CampanhaJuridica CdpjEnt = new CampanhaJuridica(descricao);
        ControllerCampanhaJuridica contCdpj = new ControllerCampanhaJuridica();
        List<CampanhaJuridica> listaCampanhaJuridica = contCdpj.listar(CdpjEnt);
        for (CampanhaJuridica CdpjSaida : listaCampanhaJuridica) {
            JOptionPane.showMessageDialog(null,CdpjSaida.toString());
            JOptionPane.showMessageDialog(null,CdpjSaida.getCd().toString());
            JOptionPane.showMessageDialog(null,CdpjSaida.getPj().toString());
        }
    }
}
