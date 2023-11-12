/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.models.beans;

/**
 * Author: Livia Caroline
 */

public class Feedback {
    private int id;
    private int idUsuario;
    private String classificacao;
    private String comentario;
    private String data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Feedback(String classificacao) {
        this.classificacao = classificacao;
    }
    
    public Feedback(int id) {
        this.id = id;
    }

    public Feedback(int idUsuario, String classificacao, String comentario, String data) {
        this.idUsuario = idUsuario;
        this.classificacao = classificacao;
        this.comentario = comentario;
        this.data = data;
    }

    public Feedback(int id, int idUsuario, String classificacao, String comentario, String data) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.classificacao = classificacao;
        this.comentario = comentario;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Feedback{" + "id=" + id + ", idUsuario=" + idUsuario + ", classificacao=" + classificacao + ", comentario=" + comentario + ", data=" + data + '}';
    }
}
