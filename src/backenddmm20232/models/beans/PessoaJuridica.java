/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backenddmm20232.models.beans;

/**
 *
 * @author Mauricio Calassara
 */
public class PessoaJuridica {
    private int id;
    private String razaoSocial, nomeFantasia, cnpj, ie, endereco, telefone, email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PessoaJuridica(int id, String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String telefone, String email) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.ie = ie;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaJuridica(String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String telefone, String email) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.ie = ie;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaJuridica(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    

    public PessoaJuridica(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "ID=" + id + ", Razão social=" + razaoSocial + ", Nome fantasia=" + nomeFantasia + ", CNPJ=" + cnpj + ", Inscrição Estadual=" + ie + ", Endereço=" + endereco + ", Telefone=" + telefone + ", E-mail=" + email + '}';
    }
    
    
}
