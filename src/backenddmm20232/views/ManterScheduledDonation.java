/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;
import backenddmm20232.controllers.ControllerScheduledDonation;
import backenddmm20232.models.beans.ScheduledDonation;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus Morais
 */
public class ManterScheduledDonation {
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

        int id_doador = Integer.parseInt(JOptionPane.showInputDialog("ID Doador"));
        String data = JOptionPane.showInputDialog("Data");
        String status = JOptionPane.showInputDialog("Status");
        ScheduledDonation sdEnt = new ScheduledDonation(id_doador, data, status);
        ControllerScheduledDonation contSd = new ControllerScheduledDonation();
        ScheduledDonation sdSaida = contSd.inserir(sdEnt);
        JOptionPane.showMessageDialog(null,sdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int id_doador = Integer.parseInt(JOptionPane.showInputDialog("ID Doador"));
        String data = JOptionPane.showInputDialog("Data");
        String status = JOptionPane.showInputDialog("Status");
        ScheduledDonation sdEnt = new ScheduledDonation(id, id_doador, data, status);
        ControllerScheduledDonation contSd = new ControllerScheduledDonation();
        ScheduledDonation sdSaida = contSd.alterar(sdEnt);
        JOptionPane.showMessageDialog(null,sdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ScheduledDonation sdEnt = new ScheduledDonation(id);
        ControllerScheduledDonation contSd = new ControllerScheduledDonation();
        ScheduledDonation sdSaida = contSd.buscar(sdEnt);
        JOptionPane.showMessageDialog(null,sdSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ScheduledDonation sdEnt = new ScheduledDonation(id);
        ControllerScheduledDonation contSd = new ControllerScheduledDonation();
        ScheduledDonation sdSaida = contSd.excluir(sdEnt);
        JOptionPane.showMessageDialog(null,sdSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String data = JOptionPane.showInputDialog("Data");
        ScheduledDonation sdEnt = new ScheduledDonation(data);
        ControllerScheduledDonation contSd = new ControllerScheduledDonation();
        List<ScheduledDonation> ListaScheduled = contSd.listar(sdEnt);
        for (ScheduledDonation sdSaida : ListaScheduled) {
            JOptionPane.showMessageDialog(null,sdSaida.toString());
        }
    }



    
}

