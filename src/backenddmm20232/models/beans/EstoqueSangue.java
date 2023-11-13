/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Mauricio Calassara
 */
public class EstoqueSangue {
    private int id, idBanco, qtd;
    private String ts, dv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public EstoqueSangue(int id) {
        this.id = id;
    }

    public EstoqueSangue(int id, int idBanco, int qtd, String ts, String dv) {
        this.id = id;
        this.idBanco = idBanco;
        this.qtd = qtd;
        this.ts = ts;
        this.dv = dv;
    }

    public EstoqueSangue(int idBanco, int qtd, String ts, String dv) {
        this.idBanco = idBanco;
        this.qtd = qtd;
        this.ts = ts;
        this.dv = dv;
    }

    public EstoqueSangue(String ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "EstoqueSangue{" + "ID=" + id + ", ID Banco=" + idBanco + ", Quantidade Disponível=" + qtd + ", Tipo Sanguineo=" + ts + ", Data de Validade=" + dv + '}';
    }

}
