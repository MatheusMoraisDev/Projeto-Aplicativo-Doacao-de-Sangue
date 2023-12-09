/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;


import backenddmm20232.models.beans.Feedback;
import backenddmm20232.models.beans.Usuario;

/**
 *
 * @author user
 */
public class UsuariosFeedback {
     private int id;
    private int idUsu;
    private int idFd;
    private String tipo;
    private String status;
    private String classificacao;
    private String comentario;
    private Usuario usu;
    private Feedback fd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public int getIdFd() {
        return idFd;
    }

    public void setIdFd(int idFd) {
        this.idFd = idFd;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Feedback getFd() {
        return fd;
    }

    public void setFd(Feedback fd) {
        this.fd = fd;
    }

    public UsuariosFeedback(int id) {
        this.id = id;
    }

    public UsuariosFeedback(String classificacao) {
        this.classificacao = classificacao;
    }

    public UsuariosFeedback(int idUsu, int idFd, String tipo, String status, String classificacao, String comentario) {
        this.idUsu = idUsu;
        this.idFd = idFd;
        this.tipo = tipo;
        this.status = status;
        this.classificacao = classificacao;
        this.comentario = comentario;
    }

   
        public UsuariosFeedback(int id, int idUsu, int idFd, String tipo, String status, String classificacao, String comentario) {
        this.id = id;
        this.idUsu = idUsu;
        this.idFd = idFd;
        this.tipo = tipo;
        this.status = status;
        this.classificacao = classificacao;
        this.comentario = comentario;
    }
    
     @Override
    public String toString() {
        return "UsuariosFeedback{" + "id=" + id + ", idUsu=" + idUsu + ", idFd=" + idFd + ", tipo=" + tipo + ", status=" + status + ", classificacao=" + classificacao + ", comentario=" + comentario + '}';
    }
    
}
