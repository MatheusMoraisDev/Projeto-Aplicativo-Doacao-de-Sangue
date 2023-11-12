/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.views;
import backenddmm20232.controllers.ControllerFeedback;
import backenddmm20232.models.beans.Feedback;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Author: Livia Caroline
 */
public class ManterFeedback {

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
                System.out.println("Opção inválida");
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {

        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário"));
        String classificacao = JOptionPane.showInputDialog("Classificação");
        String comentario = JOptionPane.showInputDialog("Comentários");
        String data = JOptionPane.showInputDialog("Data de envio");

        Feedback FdEnt = new Feedback(idUsuario, classificacao, comentario, data);
        ControllerFeedback contFd = new ControllerFeedback();
        Feedback FdSaida = contFd.inserir(FdEnt);

        JOptionPane.showMessageDialog(null, FdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idUsuario = Integer.parseInt(JOptionPane.showInputDialog("ID do Usuário"));
        String classificacao = JOptionPane.showInputDialog("Classificação");
        String comentario = JOptionPane.showInputDialog("Comentários");
        String data = JOptionPane.showInputDialog("Data de envio");

        Feedback FdEnt = new Feedback(idUsuario, classificacao, comentario, data);
        ControllerFeedback contFd = new ControllerFeedback();
        Feedback FdSaida = contFd.alterar(FdEnt);

        JOptionPane.showMessageDialog(null, FdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Feedback FdEnt = new Feedback(id);
        ControllerFeedback contFd = new ControllerFeedback();
        Feedback FdSaida = contFd.buscar(FdEnt);

        JOptionPane.showMessageDialog(null, FdSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {

        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Feedback FdEnt = new Feedback(id);
        ControllerFeedback contFd = new ControllerFeedback();
        Feedback FdSaida = contFd.excluir(FdEnt);

        JOptionPane.showMessageDialog(null, FdSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {

        String classificacao = JOptionPane.showInputDialog("Classificação");
        Feedback FdEnt = new Feedback(classificacao);
        ControllerFeedback contFd = new ControllerFeedback();
        List<Feedback> ListaFeedback = contFd.listar(FdEnt);

        for (Feedback FdSaida : ListaFeedback) {
            JOptionPane.showMessageDialog(null, FdSaida.toString());
        }
    }
}
