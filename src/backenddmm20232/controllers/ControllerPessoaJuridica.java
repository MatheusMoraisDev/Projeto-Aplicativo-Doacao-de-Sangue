/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.models.beans.PessoaJuridica;
import backenddmm20232.models.daos.DaoPessoaJuridica;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mauricio Calassara
 */
public class ControllerPessoaJuridica {

      DaoPessoaJuridica daoPj;

    public PessoaJuridica inserir(PessoaJuridica PjEnt) throws SQLException, ClassNotFoundException {
        daoPj = new DaoPessoaJuridica();
        return daoPj.inserir(PjEnt);
    }

    public PessoaJuridica alterar(PessoaJuridica PjEnt) throws SQLException, ClassNotFoundException {
        daoPj = new DaoPessoaJuridica();
        return daoPj.alterar(PjEnt);
    }

    public PessoaJuridica buscar(PessoaJuridica PjEnt) throws SQLException, ClassNotFoundException {
        daoPj = new DaoPessoaJuridica();
        return daoPj.buscar(PjEnt);
    }

    public PessoaJuridica excluir(PessoaJuridica PjEnt) throws SQLException, ClassNotFoundException {
        daoPj = new DaoPessoaJuridica();
        return daoPj.excluir(PjEnt);
    }

    public List<PessoaJuridica> listar(PessoaJuridica PjEnt) throws SQLException, ClassNotFoundException {
        daoPj = new DaoPessoaJuridica();
        return daoPj.listar(PjEnt);
    }
    
}
