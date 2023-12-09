/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;
import backenddmm20232.models.beans.PessoaJuridica;
import backenddmm20232.models.beans.CampanhaDoacao;

/**
 *
 * @author Livia
 */
public class CampanhaJuridica {
   private int id;
   private int idpj;
   private int idcd;
   private String endereco; 
   private String data;
   private String descricao;
   private CampanhaDoacao Cd;
   private PessoaJuridica pj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpj() {
        return idpj;  
   }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIdpj(int idpj) {
        this.idpj = idpj;
    }

    public int getIdcd() {
        return idcd;
    }

    public void setIdcd(int idcd) {
        this.idcd = idcd;
    }

      public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public CampanhaDoacao getCd() {
        return Cd;
    }

    public void setCd(CampanhaDoacao Cd) {
        this.Cd = Cd;
    }

    public PessoaJuridica getPj() {
        return pj;
    }

    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }

    public CampanhaJuridica(String descricao) {
        this.descricao = descricao;
    }

    public CampanhaJuridica(int id) {
        this.id = id;
    }

    public CampanhaJuridica(CampanhaDoacao Cd) {
        this.Cd = Cd;
    }

    public CampanhaJuridica(int idpj, int idcd, String endereco, String data, String descricao) {
        this.idpj = idpj;
        this.idcd = idcd;
        this.endereco = endereco;
        this.descricao = descricao;
        this.data = data;
    }

    public CampanhaJuridica(int id, int idpj, int idcd, String endereco, String data, String descricao) {
        this.id = id;
        this.idpj = idpj;
        this.idcd = idcd;
        this.endereco = endereco;
        this.data = data;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CampanhaJuridica{" + "id=" + id + ", idpj=" + idpj + ", idcd=" + idcd + ", endereco=" + endereco  + ", data=" + data + ", descricao=" + descricao +'}';
    }

   
    
    
   
  
    
    
}
