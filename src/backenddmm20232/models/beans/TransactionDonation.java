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
    private int id, idDoador, idHospital, qtd;
    private String data, teste;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDoador() {
        return idDoador;
    }

    public void setIdDoador(int idDoador) {
        this.idDoador = idDoador;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
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

    public TransactionDonation(int idDoador, int idHospital, int qtd, String data, String teste) {
        this.idDoador = idDoador;
        this.idHospital = idHospital;
        this.qtd = qtd;
        this.data = data;
        this.teste = teste;
    }

    public TransactionDonation(String data) {
        this.data = data;
    }

    public TransactionDonation(int id, int idDoador, int idHospital, int qtd, String data, String teste) {
        this.id = id;
        this.idDoador = idDoador;
        this.idHospital = idHospital;
        this.qtd = qtd;
        this.data = data;
        this.teste = teste;
    }

    @Override
    public String toString() {
        return "TransactionDonation{" + "id=" + id + ", ID Doador=" + idDoador + ", ID Hospital=" + idHospital + ", qtd=" + qtd + ", data=" + data + ", teste=" + teste + '}';
    }
    
    
}
