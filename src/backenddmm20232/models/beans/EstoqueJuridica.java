/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package backenddmm20232.models.beans;

/**
 *
 * @author Mauricio Calassara
 */
public class EstoqueJuridica {
    
   private int id;
   private int idpj;
   private int ides;
   private String razaoSocial; 
   private String tipoSanguineo;
   private EstoqueSangue Es;
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

    public void setIdpj(int idpj) {
        this.idpj = idpj;
    }

    public int getIdes() {
        return ides;
    }

    public void setIdes(int ides) {
        this.ides = ides;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public EstoqueSangue getEs() {
        return Es;
    }

    public void setEs(EstoqueSangue Es) {
        this.Es = Es;
    }

    public PessoaJuridica getPj() {
        return pj;
    }

    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }
    
    

    public EstoqueJuridica(int idpj, int ides, String razaoSocial, String tipoSanguineo) {
        this.idpj = idpj;
        this.ides = ides;
        this.razaoSocial = razaoSocial;
        this.tipoSanguineo = tipoSanguineo;
        
    }
    
    public EstoqueJuridica(int id, int idpj, int ides, String razaoSocial, String tipoSanguineo) {
        this.id = id;
        this.idpj = idpj;
        this.ides = ides;
        this.razaoSocial = razaoSocial;
        this.tipoSanguineo = tipoSanguineo;
    }

    public EstoqueJuridica(int id) {
        this.id = id;
    }

    public EstoqueJuridica(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    @Override
    public String toString() {
        return "EstoqueJuridica{" + "id=" + id + ", idpj=" + idpj + ", ides=" + ides + ", razaoSocial=" + razaoSocial + ", tipoSanguineo=" + tipoSanguineo;
    }
   
}
