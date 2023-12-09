/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerUsuariosFeedback;
import backenddmm20232.models.beans.UsuariosFeedback;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Professor
 */
public class ManterUsuariosFeedback{
    
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
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ID_USUARIO"));
        int idFd = Integer.parseInt(JOptionPane.showInputDialog("ID_FEEDBACK"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String classificacao = JOptionPane.showInputDialog("CLASSIFICAÇÃO");
        String comentario = JOptionPane.showInputDialog("COMENTÁRIOS");
        UsuariosFeedback usuFdEnt = new UsuariosFeedback(idUsu, idFd, tipo, status, classificacao, comentario);
        ControllerUsuariosFeedback contFdPes = new ControllerUsuariosFeedback();
        UsuariosFeedback usuFdSaida = contFdPes.inserir(usuFdEnt);
        JOptionPane.showMessageDialog(null,usuFdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ID_USUARIO"));
        int idFd = Integer.parseInt(JOptionPane.showInputDialog("ID_FEEDBACK"));
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String classificacao = JOptionPane.showInputDialog("CLASSIFICAÇÃO");
        String comentario = JOptionPane.showInputDialog("COMENTÁRIOS");
        UsuariosFeedback usuFdEnt = new UsuariosFeedback(idUsu, idFd, tipo, status, classificacao, comentario);
        ControllerUsuariosFeedback contFdPes = new ControllerUsuariosFeedback();
        UsuariosFeedback usuFdSaida = contFdPes.inserir(usuFdEnt);
        JOptionPane.showMessageDialog(null,usuFdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosFeedback usuFdEnt = new UsuariosFeedback(id);
       ControllerUsuariosFeedback contFdPes = new ControllerUsuariosFeedback();
        UsuariosFeedback usuFdSaida = contFdPes.inserir(usuFdEnt);
        JOptionPane.showMessageDialog(null,usuFdSaida.toString());;
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuariosFeedback usuFdEnt = new UsuariosFeedback(id);
       ControllerUsuariosFeedback contFdPes = new ControllerUsuariosFeedback();
        UsuariosFeedback usuFdSaida = contFdPes.inserir(usuFdEnt);
        JOptionPane.showMessageDialog(null,usuFdSaida.toString());;
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String classificacao = JOptionPane.showInputDialog("CLASSIFICAÇÃO");
        UsuariosFeedback usuFdEnt = new UsuariosFeedback(classificacao);
        ControllerUsuariosFeedback contFdPes = new ControllerUsuariosFeedback();
        List<UsuariosFeedback> listaUsuariosFeedback = contFdPes.listar(usuFdEnt);
        for (UsuariosFeedback usuFdSaida : listaUsuariosFeedback) {
            JOptionPane.showMessageDialog(null,usuFdSaida.toString());
            JOptionPane.showMessageDialog(null,usuFdSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null,usuFdSaida.getFd().toString());
        }
    }
}
