/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Matheus Morais
 */
public class ScheduledDonation {
    private int id, idDoador;
    private String data, status;

    public ScheduledDonation(int id) {
        this.id = id;
    }
    
    public ScheduledDonation(String data) {
        this.data = data;
    }
    
    public ScheduledDonation(int id, int idDoador, String data, String status) {
        this.id = id;
        this.idDoador = idDoador;
        this.data = data;
        this.status = status;
    }

    public ScheduledDonation(int idDoador, String data, String status) {
        this.idDoador = idDoador;
        this.data = data;
        this.status = status;
    }
    
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "scheduled_donation{" + "id=" + id + ", ID Doador=" + idDoador + ", data=" + data + ", status=" + status + '}';
    }
    
}
