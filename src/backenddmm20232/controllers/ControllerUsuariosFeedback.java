/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.controllers;

import backenddmm20232.controllers.ControllerFeedback;
import backenddmm20232.controllers.ControllerUsuario;
import backenddmm20232.models.beans.Feedback;
import backenddmm20232.models.beans.Usuario;
import backenddmm20232.models.beans.UsuariosFeedback;
import backenddmm20232.models.daos.DaoUsuariosFeedback;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Professor
 */
public class ControllerUsuariosFeedback {
    
     DaoUsuariosFeedback daoUs;

    public UsuariosFeedback inserir(UsuariosFeedback usuFd) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosFeedback();
        return daoUs.inserir(usuFd);
    }

    public UsuariosFeedback alterar(UsuariosFeedback usuFd) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosFeedback();
        return daoUs.inserir(usuFd);
    }
    public UsuariosFeedback excluir(UsuariosFeedback usuFd) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosFeedback();
        return daoUs.inserir(usuFd);
    }

    public UsuariosFeedback buscar(UsuariosFeedback usuFd) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosFeedback();
        UsuariosFeedback usSaida = daoUs.buscar(usuFd);
        
        ControllerUsuario contUsu = new ControllerUsuario();
        Usuario usuEnt = new Usuario(usSaida.getIdUsu());
        usSaida.setUsu(contUsu.buscar(usuEnt));
        
        ControllerFeedback contFd = new ControllerFeedback();
        Feedback fdEnt = new Feedback(usSaida.getIdFd());
        usSaida.setFd(contFd.buscar(fdEnt));
        
        return usSaida;
    }

    public List<UsuariosFeedback> listar(UsuariosFeedback usuFd) throws SQLException, ClassNotFoundException {
        daoUs = new DaoUsuariosFeedback();
        List<UsuariosFeedback> listaUsuFeedbackAux = daoUs.listar(usuFd);
        List<UsuariosFeedback> listaUsuFeedbackSaida = new ArrayList<>();
        
        for (UsuariosFeedback usuFdSaida : listaUsuFeedbackAux) {
            listaUsuFeedbackSaida.add(buscar(usuFdSaida));
        }
        
        return listaUsuFeedbackSaida;
    }

    
}
