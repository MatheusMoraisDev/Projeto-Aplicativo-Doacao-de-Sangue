/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;
import backenddmm20232.models.beans.TransactionDonation;
import backenddmm20232.models.daos.DaoTransactionDonation;
import java.sql.SQLException;
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
        return daoTd.buscar(tdEnt);
    }

    public TransactionDonation excluir(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        return daoTd.excluir(tdEnt);
    }

    public List<TransactionDonation> listar(TransactionDonation tdEnt) throws SQLException, ClassNotFoundException {
        daoTd = new DaoTransactionDonation();
        return daoTd.listar(tdEnt);
    }
}
