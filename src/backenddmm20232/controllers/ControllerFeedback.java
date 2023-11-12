/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.controllers;

import backenddmm20232.models.beans.Feedback;
import backenddmm20232.models.daos.DaoFeedback;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Livia Caroline
 */
public class ControllerFeedback {

    DaoFeedback daoFd;

    public Feedback inserir(Feedback FdEnt) throws SQLException, ClassNotFoundException {
        daoFd = new DaoFeedback();
        return daoFd.inserir(FdEnt);
    }

    public Feedback alterar(Feedback FdEnt) throws SQLException, ClassNotFoundException {
        daoFd = new DaoFeedback();
        return daoFd.alterar(FdEnt);
    }

    public Feedback buscar(Feedback FdEnt) throws SQLException, ClassNotFoundException {
        daoFd = new DaoFeedback();
        return daoFd.buscar(FdEnt);
    }

    public Feedback excluir(Feedback FdEnt) throws SQLException, ClassNotFoundException {
        daoFd = new DaoFeedback();
        return daoFd.excluir(FdEnt);
    }

    public List<Feedback> listar(Feedback FdEnt) throws SQLException, ClassNotFoundException {
        daoFd = new DaoFeedback();
        return daoFd.listar(FdEnt);
    }
}
