/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;
import backenddmm20232.controllers.ControllerTransactionDonation;
import backenddmm20232.models.beans.TransactionDonation;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus Morais
 */
public class ManterTransactionDonation {
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
        int idDoador = Integer.parseInt(JOptionPane.showInputDialog("ID Doador"));
        int idHospital = Integer.parseInt(JOptionPane.showInputDialog("ID Hospital"));
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade Doada"));
        String data = JOptionPane.showInputDialog("Data");
        String teste = JOptionPane.showInputDialog("Teste");
        TransactionDonation tdEnt = new TransactionDonation(idDoador, idHospital, qtd, data, teste);
        ControllerTransactionDonation contTd = new ControllerTransactionDonation();
        TransactionDonation tdSaida = contTd.inserir(tdEnt);
        JOptionPane.showMessageDialog(null,tdSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idDoador = Integer.parseInt(JOptionPane.showInputDialog("ID Doador"));
        int idHospital = Integer.parseInt(JOptionPane.showInputDialog("ID Hospital"));
        int qtd = Integer.parseInt(JOptionPane.showInputDialog("Quantidade Doada"));
        String data = JOptionPane.showInputDialog("Data");
        String teste = JOptionPane.showInputDialog("Teste");
        TransactionDonation tdEnt = new TransactionDonation(id, idDoador, idHospital, qtd, data, teste);
        ControllerTransactionDonation contTd = new ControllerTransactionDonation();
        TransactionDonation tdSaida = contTd.alterar(tdEnt);
        JOptionPane.showMessageDialog(null,tdSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        TransactionDonation tdEnt = new TransactionDonation(id);
        ControllerTransactionDonation contTd = new ControllerTransactionDonation();
        TransactionDonation tdSaida = contTd.buscar(tdEnt);
        JOptionPane.showMessageDialog(null,tdSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        TransactionDonation tdEnt = new TransactionDonation(id);
        ControllerTransactionDonation contTd = new ControllerTransactionDonation();
        TransactionDonation tdSaida = contTd.excluir(tdEnt);
        JOptionPane.showMessageDialog(null,tdSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String data = JOptionPane.showInputDialog("Data");
        TransactionDonation tdEnt = new TransactionDonation(data);
        ControllerTransactionDonation contTd = new ControllerTransactionDonation();
        List<TransactionDonation> ListaTransactions = contTd.listar(tdEnt);
        for (TransactionDonation tdSaida : ListaTransactions) {
            JOptionPane.showMessageDialog(null,tdSaida.toString());
            JOptionPane.showMessageDialog(null,tdSaida.getPf().toString());
            JOptionPane.showMessageDialog(null,tdSaida.getPj().toString());
        }
    }



    
}

