/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.ScheduledDonation;
import backenddmm20232.models.daos.DaoScheduledDonation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matheus Morais
 */
public class ControllerScheduledDonation {

      DaoScheduledDonation daoSd;

    public ScheduledDonation inserir(ScheduledDonation sdEnt) throws SQLException, ClassNotFoundException {
        daoSd = new DaoScheduledDonation();
        return daoSd.inserir(sdEnt);
    }

    public ScheduledDonation alterar(ScheduledDonation sdEnt) throws SQLException, ClassNotFoundException {
        daoSd = new DaoScheduledDonation();
        return daoSd.alterar(sdEnt);
    }

    public ScheduledDonation buscar(ScheduledDonation sdEnt) throws SQLException, ClassNotFoundException {
        daoSd = new DaoScheduledDonation();
        return daoSd.buscar(sdEnt);
    }

    public ScheduledDonation excluir(ScheduledDonation sdEnt) throws SQLException, ClassNotFoundException {
        daoSd = new DaoScheduledDonation();
        return daoSd.excluir(sdEnt);
    }

    public List<ScheduledDonation> listar(ScheduledDonation sdEnt) throws SQLException, ClassNotFoundException {
        daoSd = new DaoScheduledDonation();
        return daoSd.listar(sdEnt);
    }
    
}
