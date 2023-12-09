/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.views;

import backenddmm20232.controllers.ControllerEstoqueJuridica;
import backenddmm20232.models.beans.EstoqueJuridica;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Calassara
 */
public class ManterEstoqueJuridica {
    
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
        int ides = Integer.parseInt(JOptionPane.showInputDialog("ID ESTOQUE SANGUE"));
        int idpj= Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA JURIDICA"));
        String razaoSocial = JOptionPane.showInputDialog("RAZÃO SOCIAL");
        String tipoSanguineo = JOptionPane.showInputDialog("TIPO SANGUINEO");
        EstoqueJuridica esPjEnt = new EstoqueJuridica(idpj, ides,  razaoSocial, tipoSanguineo);
        ControllerEstoqueJuridica contesPj = new ControllerEstoqueJuridica();
        EstoqueJuridica esPjSaida = contesPj.inserir(esPjEnt);
        JOptionPane.showMessageDialog(null,esPjSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID")); 
        int ides = Integer.parseInt(JOptionPane.showInputDialog("ID ESTOQUE SANGUE"));
        int idpj= Integer.parseInt(JOptionPane.showInputDialog("ID PESSOA JURIDICA"));
        String razaoSocial = JOptionPane.showInputDialog("RAZÃO SOCIAL");
        String tipoSanguineo = JOptionPane.showInputDialog("TIPO SANGUINEO");
        EstoqueJuridica esPjEnt = new EstoqueJuridica(id, ides, idpj,  razaoSocial, tipoSanguineo);
        ControllerEstoqueJuridica contesPj = new ControllerEstoqueJuridica();
        EstoqueJuridica esPjSaida = contesPj.alterar(esPjEnt);
        JOptionPane.showMessageDialog(null,esPjSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstoqueJuridica esPjEnt = new EstoqueJuridica(id);
        ControllerEstoqueJuridica contesPj = new ControllerEstoqueJuridica();
        EstoqueJuridica esPjSaida = contesPj.buscar(esPjEnt);
        JOptionPane.showMessageDialog(null,esPjSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        EstoqueJuridica esPjEnt = new EstoqueJuridica(id);
        ControllerEstoqueJuridica contesPj = new ControllerEstoqueJuridica();
        EstoqueJuridica esPjSaida = contesPj.excluir(esPjEnt);
        JOptionPane.showMessageDialog(null,esPjSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String razaoSocial = JOptionPane.showInputDialog("RAZÃO SOCIAL");
        EstoqueJuridica esPjEnt = new EstoqueJuridica(razaoSocial);
        ControllerEstoqueJuridica contesPj = new ControllerEstoqueJuridica();
        List<EstoqueJuridica> listaEstoqueJuridica = contesPj.listar(esPjEnt);
        for (EstoqueJuridica esPjSaida : listaEstoqueJuridica) {
            JOptionPane.showMessageDialog(null,esPjSaida.toString());
            JOptionPane.showMessageDialog(null,esPjSaida.getPj().toString());
            JOptionPane.showMessageDialog(null,esPjSaida.getEs().toString());
        }
    }
}
