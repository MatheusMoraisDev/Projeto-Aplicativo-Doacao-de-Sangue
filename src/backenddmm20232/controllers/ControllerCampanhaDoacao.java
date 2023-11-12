/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.controllers;

import backenddmm20232.models.beans.CampanhaDoacao;
import backenddmm20232.models.daos.DaoCampanhaDoacao;

import java.sql.SQLException;
import java.util.List;

/**
 * Author: Livia Caroline
 */
public class ControllerCampanhaDoacao {

    DaoCampanhaDoacao daoCd;

    public CampanhaDoacao inserir(CampanhaDoacao CdEnt) throws SQLException, ClassNotFoundException {
        daoCd = new DaoCampanhaDoacao();
        return daoCd.inserir(CdEnt);
    }

    public CampanhaDoacao alterar(CampanhaDoacao CdEnt) throws SQLException, ClassNotFoundException {
        daoCd = new DaoCampanhaDoacao();
        return daoCd.alterar(CdEnt);
    }

    public CampanhaDoacao buscar(CampanhaDoacao CdEnt) throws SQLException, ClassNotFoundException {
        daoCd = new DaoCampanhaDoacao();
        return daoCd.buscar(CdEnt);
    }

    public CampanhaDoacao excluir(CampanhaDoacao CdEnt) throws SQLException, ClassNotFoundException {
        daoCd = new DaoCampanhaDoacao();
        return daoCd.excluir(CdEnt);
    }

    public List<CampanhaDoacao> listar(CampanhaDoacao CdEnt) throws SQLException, ClassNotFoundException {
        daoCd = new DaoCampanhaDoacao();
        return daoCd.listar(CdEnt);
    }
}
