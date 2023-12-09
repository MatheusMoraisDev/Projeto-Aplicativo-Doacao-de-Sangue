/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.controllers.ControllerEstoqueSangue;
import backenddmm20232.controllers.ControllerPessoaJuridica;
import backenddmm20232.models.beans.EstoqueSangue;
import backenddmm20232.models.beans.PessoaJuridica;
import backenddmm20232.models.beans.EstoqueJuridica;
import backenddmm20232.models.daos.DaoEstoqueJuridica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class ControllerEstoqueJuridica {
    
     DaoEstoqueJuridica daoesPj;

    public EstoqueJuridica inserir(EstoqueJuridica esPj) throws SQLException, ClassNotFoundException {
        daoesPj = new DaoEstoqueJuridica();
        return daoesPj.inserir(esPj);
    }
    
    public EstoqueJuridica alterar(EstoqueJuridica esPj) throws SQLException, ClassNotFoundException {
        daoesPj = new DaoEstoqueJuridica();
        return daoesPj.alterar(esPj);
    }
     
    public EstoqueJuridica excluir(EstoqueJuridica esPj) throws SQLException, ClassNotFoundException {
        daoesPj = new DaoEstoqueJuridica();
        return daoesPj.excluir(esPj);
    }

    
  public EstoqueJuridica buscar(EstoqueJuridica esPj) throws SQLException, ClassNotFoundException {
        daoesPj = new DaoEstoqueJuridica();
        EstoqueJuridica esPjSaida = daoesPj.buscar(esPj);
        
        ControllerEstoqueSangue contes = new ControllerEstoqueSangue();
        EstoqueSangue esEnt = new EstoqueSangue(esPjSaida.getIdes());
        esPjSaida.setEs(contes.buscar(esEnt));
        
        ControllerPessoaJuridica contPj = new ControllerPessoaJuridica();
        PessoaJuridica PjEnt = new PessoaJuridica(esPjSaida.getIdpj());
        esPjSaida.setPj(contPj.buscar(PjEnt));
        
        return esPjSaida;
    }
   

    public List<EstoqueJuridica> listar(EstoqueJuridica esPj) throws SQLException, ClassNotFoundException {
        daoesPj = new DaoEstoqueJuridica();
        List<EstoqueJuridica> listaEstoqueJuridicaAux = daoesPj.listar(esPj);
        List<EstoqueJuridica> listaEstoqueJuridicaSaida = new ArrayList<>();
        
        for (EstoqueJuridica esPjSaida : listaEstoqueJuridicaAux) {
            listaEstoqueJuridicaSaida.add(buscar(esPjSaida));
        }
        
        return listaEstoqueJuridicaSaida;
    }

    
}
