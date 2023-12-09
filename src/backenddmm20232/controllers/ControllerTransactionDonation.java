/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;
import backenddmm20232.models.beans.PessoaFisica;
import backenddmm20232.models.beans.PessoaJuridica;
import backenddmm20232.models.beans.TransactionDonation;
import backenddmm20232.models.daos.DaoTransactionDonation;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Morais
 */
public class ControllerTransactionDonation {

    DaoTransactionDonation daoTd;

    public TransactionDonation inserir(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        return daoTd.inserir(tdEnt);
    }

    public TransactionDonation alterar(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        return daoTd.alterar(tdEnt);
    }

    public TransactionDonation buscar(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        TransactionDonation tdSaida = daoTd.buscar(tdEnt);
        
        ControllerPessoaFisica contPf = new ControllerPessoaFisica();
        PessoaFisica pfEnt = new PessoaFisica(tdSaida.getIdDoador());
        tdSaida.setPf(contPf.buscar(pfEnt));
        
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica pjEnt = new PessoaJuridica(tdSaida.getIdHospital());
        tdSaida.setPj(contPj.buscar(pjEnt));
        
        return tdSaida;
    }

    public TransactionDonation excluir(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        return daoTd.excluir(tdEnt);
    }

    public List<TransactionDonation> listar(TransactionDonation tdSist) throws SQLException, ClassNotFoundException {
       daoTd = new DaoTransactionDonation();
       List<TransactionDonation> listaTdAux = daoTd.listar(tdSist);
       List<TransactionDonation> listaTdSaida = new ArrayList<>();

       for (TransactionDonation tdSaida : listaTdAux) {
           listaTdSaida.add(buscar(tdSaida));
       }

       return listaTdSaida;
   }
}
