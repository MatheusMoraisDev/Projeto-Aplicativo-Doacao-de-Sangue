/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.EstoqueSangue;
import backenddmm20232.models.daos.DaoEstoqueSangue;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mauricio Calassara
 */
public class ControllerEstoqueSangue {

      DaoEstoqueSangue daoEs;

    public EstoqueSangue inserir(EstoqueSangue EsEnt) throws SQLException, ClassNotFoundException {
        daoEs = new DaoEstoqueSangue();
        return daoEs.inserir(EsEnt);
    }

    public EstoqueSangue alterar(EstoqueSangue EsEnt) throws SQLException, ClassNotFoundException {
        daoEs = new DaoEstoqueSangue();
        return daoEs.alterar(EsEnt);
    }

    public EstoqueSangue buscar(EstoqueSangue EsEnt) throws SQLException, ClassNotFoundException {
        daoEs = new DaoEstoqueSangue();
        return daoEs.buscar(EsEnt);
    }

    public EstoqueSangue excluir(EstoqueSangue EsEnt) throws SQLException, ClassNotFoundException {
        daoEs = new DaoEstoqueSangue();
        return daoEs.excluir(EsEnt);
    }

    public List<EstoqueSangue> listar(EstoqueSangue EsEnt) throws SQLException, ClassNotFoundException {
        daoEs = new DaoEstoqueSangue();
        return daoEs.listar(EsEnt);
    }
    
}