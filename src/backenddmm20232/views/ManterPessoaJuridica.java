/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;
import backenddmm20232.controllers.ControllerPessoaJuridica;
import backenddmm20232.models.beans.PessoaJuridica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus Morais
 */
public class ManterPessoaJuridica {
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

        String razaoSocial = JOptionPane.showInputDialog("Razão Social");
        String nomeFantasia = JOptionPane.showInputDialog("Nome fantasia");
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        String ie = JOptionPane.showInputDialog("Inscrição estadual");
        String endereco = JOptionPane.showInputDialog("Endereço");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String email = JOptionPane.showInputDialog("E-mail");
        PessoaJuridica PjEnt = new PessoaJuridica(razaoSocial, nomeFantasia, cnpj, ie, endereco, telefone, email);
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica PjSaida = contPj.inserir(PjEnt);
        JOptionPane.showMessageDialog(null,PjSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String razaoSocial = JOptionPane.showInputDialog("Razão Social");
        String nomeFantasia = JOptionPane.showInputDialog("Nome fantasia");
        String cnpj = JOptionPane.showInputDialog("CNPJ");
        String ie = JOptionPane.showInputDialog("Inscrição estadual");
        String endereco = JOptionPane.showInputDialog("Endereço");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String email = JOptionPane.showInputDialog("E-mail");
        PessoaJuridica PjEnt = new PessoaJuridica(id, razaoSocial, nomeFantasia, cnpj, ie, endereco, telefone, email);
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica PjSaida = contPj.alterar(PjEnt);
        JOptionPane.showMessageDialog(null,PjSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaJuridica PjEnt = new PessoaJuridica(id);
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica PjSaida = contPj.buscar(PjEnt);
        JOptionPane.showMessageDialog(null,PjSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        PessoaJuridica PjEnt = new PessoaJuridica(id);
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica PjSaida = contPj.excluir(PjEnt);
        JOptionPane.showMessageDialog(null,PjSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nomeFantasia = JOptionPane.showInputDialog("Nome Fantasia");
        PessoaJuridica PjEnt = new PessoaJuridica(nomeFantasia);
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        List<PessoaJuridica> ListaEstoque = contPj.listar(PjEnt);
        for (PessoaJuridica PjSaida : ListaEstoque) {
            JOptionPane.showMessageDialog(null,PjSaida.toString());
        }
    }



    
}

