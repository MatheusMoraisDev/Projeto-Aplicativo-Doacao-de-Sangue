/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;
import backenddmm20232.controllers.ControllerEstoqueSangue;
import backenddmm20232.models.beans.EstoqueSangue;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus Morais
 */
public class ManterEstoqueSangue {
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

        int id_banco = Integer.parseInt(JOptionPane.showInputDialog("ID Banco"));
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade Disponível"));
        String ts = JOptionPane.showInputDialog("Tipo Sanguineo");
        String dv = JOptionPane.showInputDialog("Data Validade");
        EstoqueSangue EsEnt = new EstoqueSangue(id_banco ,qtd, ts, dv);
        ControllerEstoqueSangue contEs = new ControllerEstoqueSangue();
        EstoqueSangue EsSaida = contEs.inserir(EsEnt);
        JOptionPane.showMessageDialog(null,EsSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int id_banco = Integer.parseInt(JOptionPane.showInputDialog("ID Banco"));
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade Disponível"));
        String ts = JOptionPane.showInputDialog("Tipo Sanguineo");
        String dv = JOptionPane.showInputDialog("Data Validade");
        EstoqueSangue EsEnt = new EstoqueSangue(id, id_banco ,qtd, ts, dv);
        ControllerEstoqueSangue contEs = new ControllerEstoqueSangue();
        EstoqueSangue EsSaida = contEs.alterar(EsEnt);
        JOptionPane.showMessageDialog(null,EsSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstoqueSangue EsEnt = new EstoqueSangue(id);
        ControllerEstoqueSangue contEs = new ControllerEstoqueSangue();
        EstoqueSangue EsSaida = contEs.buscar(EsEnt);
        JOptionPane.showMessageDialog(null,EsSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstoqueSangue EsEnt = new EstoqueSangue(id);
        ControllerEstoqueSangue contEs = new ControllerEstoqueSangue();
        EstoqueSangue EsSaida = contEs.excluir(EsEnt);
        JOptionPane.showMessageDialog(null,EsSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String ts = JOptionPane.showInputDialog("Tipo Sanguineo");
        EstoqueSangue EsEnt = new EstoqueSangue(ts);
        ControllerEstoqueSangue contEs = new ControllerEstoqueSangue();
        List<EstoqueSangue> ListaEstoque = contEs.listar(EsEnt);
        for (EstoqueSangue EsSaida : ListaEstoque) {
            JOptionPane.showMessageDialog(null,EsSaida.toString());
        }
    }



    
}

