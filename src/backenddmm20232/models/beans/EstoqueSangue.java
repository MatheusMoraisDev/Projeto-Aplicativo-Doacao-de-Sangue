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
    private int id, id_banco, qtd;
    private String ts, dv;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
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

    public EstoqueSangue(int id, int id_banco, int qtd, String ts, String dv) {
        this.id = id;
        this.id_banco = id_banco;
        this.qtd = qtd;
        this.ts = ts;
        this.dv = dv;
    }

    public EstoqueSangue(int id_banco, int qtd, String ts, String dv) {
        this.id_banco = id_banco;
        this.qtd = qtd;
        this.ts = ts;
        this.dv = dv;
    }

    public EstoqueSangue(String ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "EstoqueSangue{" + "ID=" + id + ", ID Banco=" + id_banco + ", Quantidade disponível=" + qtd + ", Tipo sanguineo=" + ts + ", Data de validade=" + dv + '}';
    }
    
}
