/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Matheus Morais
 */
public class TransactionDonation {
    private int id, id_doador, id_hospital, qtd;
    private String data, teste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_doador() {
        return id_doador;
    }

    public void setId_doador(int id_doador) {
        this.id_doador = id_doador;
    }

    public int getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public TransactionDonation(int id) {
        this.id = id;
    }

    public TransactionDonation(int id_doador, int id_hospital, int qtd, String data, String teste) {
        this.id_doador = id_doador;
        this.id_hospital = id_hospital;
        this.qtd = qtd;
        this.data = data;
        this.teste = teste;
    }

    public TransactionDonation(String data) {
        this.data = data;
    }

    public TransactionDonation(int id, int id_doador, int id_hospital, int qtd, String data, String teste) {
        this.id = id;
        this.id_doador = id_doador;
        this.id_hospital = id_hospital;
        this.qtd = qtd;
        this.data = data;
        this.teste = teste;
    }

    @Override
    public String toString() {
        return "TransactionDonation{" + "id=" + id + ", id_doador=" + id_doador + ", id_hospital=" + id_hospital + ", qtd=" + qtd + ", data=" + data + ", teste=" + teste + '}';
    }
    
    
}
