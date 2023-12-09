/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.controllers.ControllerCampanhaDoacao;
import backenddmm20232.controllers.ControllerPessoaJuridica;
import backenddmm20232.models.beans.CampanhaDoacao;
import backenddmm20232.models.beans.PessoaJuridica;
import backenddmm20232.models.beans.CampanhaJuridica;
import backenddmm20232.models.daos.DaoCampanhaJuridica;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class ControllerCampanhaJuridica {
    
     DaoCampanhaJuridica daoCdpj;

    public CampanhaJuridica inserir(CampanhaJuridica Cdpj) throws SQLException, ClassNotFoundException {
        daoCdpj = new DaoCampanhaJuridica();
        return daoCdpj.inserir(Cdpj);
    }
    
    public CampanhaJuridica alterar(CampanhaJuridica Cdpj) throws SQLException, ClassNotFoundException {
        daoCdpj = new DaoCampanhaJuridica();
        return daoCdpj.alterar(Cdpj);
    }
    
    public CampanhaJuridica excluir(CampanhaJuridica Cdpj) throws SQLException, ClassNotFoundException {
        daoCdpj = new DaoCampanhaJuridica();
        return daoCdpj.excluir(Cdpj);
    }

    
  public CampanhaJuridica buscar(CampanhaJuridica Cdpj) throws SQLException, ClassNotFoundException {
        daoCdpj = new DaoCampanhaJuridica();
        CampanhaJuridica CdpjSaida = daoCdpj.buscar(Cdpj);
        
        ControllerCampanhaDoacao contCd = new ControllerCampanhaDoacao();
        CampanhaDoacao CdEnt = new CampanhaDoacao(CdpjSaida.getIdcd());
        CdpjSaida.setCd(contCd.buscar(CdEnt));
        
        ControllerPessoaJuridica contpj = new ControllerPessoaJuridica();
        PessoaJuridica pjEnt = new PessoaJuridica(CdpjSaida.getIdpj());
        CdpjSaida.setPj(contpj.buscar(pjEnt));
        
        return CdpjSaida;
    }
   

    public List<CampanhaJuridica> listar(CampanhaJuridica Cdpj) throws SQLException, ClassNotFoundException {
        daoCdpj = new DaoCampanhaJuridica();
        List<CampanhaJuridica> listaCampanhaJuridicaAux = daoCdpj.listar(Cdpj);
        List<CampanhaJuridica> listaCampanhaJuridicaSaida = new ArrayList<>();
        
        for (CampanhaJuridica CdpjSaida : listaCampanhaJuridicaAux) {
            listaCampanhaJuridicaSaida.add(buscar(CdpjSaida));
        }
        
        return listaCampanhaJuridicaSaida;
    }

    
}
