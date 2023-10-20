/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backenddmm20232;

import backenddmm20232.views.ManterPessoaFisica;
import backenddmm20232.views.ManterScheduledDonation;
import backenddmm20232.views.ManterSistema;
import backenddmm20232.views.ManterTransactionDonation;
import backenddmm20232.views.ManterUsuario;
import backenddmm20232.views.ManterEstoqueSangue;
import backenddmm20232.views.ManterPessoaJuridica;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 

/**
 *
 * @author Aluno
 */
public class BackEndDmm20232 {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        if(ManterUsuario.validar()) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n 1 - Usuario \n 2 - Sistema \n 3 - Pessoa Física\n 4 - Agendamento de Doações \n 5 - Transações \n 6 - Estoque Sangue \n 7 - Pessoa Jurídica \n 8 - ControleAcesso";

        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair");
                if (sair > 0) menu();
                break;
            case 1:
                ManterUsuario.menu();
                break;
            case 2:
                ManterSistema.menu();
                break;
            case 3:
                ManterPessoaFisica.menu();
                break;
            case 4:
                ManterScheduledDonation.menu();
                break;
            case 5:
                ManterTransactionDonation.menu();
                break;
            case 6:
                ManterEstoqueSangue.menu();
                break;
            case 7:
                ManterPessoaJuridica.menu();
                break;
            case 8:
                break;
            default:
                System.out.println("Opção inválido");
        }
    }
    
}

