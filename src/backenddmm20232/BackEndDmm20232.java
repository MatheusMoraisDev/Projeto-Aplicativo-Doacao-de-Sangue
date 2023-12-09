/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package backenddmm20232;

import backenddmm20232.views.ManterCampanhaDoacao;
import backenddmm20232.views.ManterCampanhaJuridica;
import backenddmm20232.views.ManterEstoqueJuridica;
import backenddmm20232.views.ManterPessoaFisica;
import backenddmm20232.views.ManterScheduledDonation;
import backenddmm20232.views.ManterTransactionDonation;
import backenddmm20232.views.ManterUsuario;
import backenddmm20232.views.ManterEstoqueSangue;
import backenddmm20232.views.ManterFeedback;
import backenddmm20232.views.ManterPessoaJuridica;
import backenddmm20232.views.ManterUsuariosFeedback;
import backenddmm20232.views.ManterUsuariosSistemas;
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
            while(true){
                menu();
            }
        } else {
            JOptionPane.showMessageDialog(null,"Usuario Inválido");            
        }
      
    }

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 0 - Sair \n" +
              " 1 - Usuario \n" +
              " 2 - Doador \n" +
              " 3 - Hospital \n" +
              " 4 - Transações de Sangue \n" +
              " 5 - Estoque Sangue \n" +
              " 6 - Campanhas de Doação \n" +
              " 7 - Feedbacks \n" +
              " 8 - Agendamentos \n" +
              " 9 - Estoque de Sangue Hospital \n" +
              " 10 - Campanha Doação Hospital";
        
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
                ManterPessoaFisica.menu();
                break;
            case 3:
                ManterPessoaJuridica.menu();
                break;
            case 4:
                ManterTransactionDonation.menu();
                break;
            case 5:
                ManterEstoqueSangue.menu();
                break;
            case 6:
                ManterCampanhaDoacao.menu();
                break;
            case 7:
                ManterFeedback.menu();
                break;
            case 8:
                ManterScheduledDonation.menu();
                break;
            case 9:
                ManterEstoqueJuridica.menu();
                break;
            case 10:
                ManterCampanhaJuridica.menu();
                break;
            case 11:
                ManterUsuariosSistemas.menu();
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
}

