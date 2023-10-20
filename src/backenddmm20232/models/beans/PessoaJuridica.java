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
    private String razao_social, nome_fantasia, cnpj, ie, endereco, telefone, email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
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

    public PessoaJuridica(int id, String razao_social, String nome_fantasia, String cnpj, String ie, String endereco, String telefone, String email) {
        this.id = id;
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.ie = ie;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaJuridica(String razao_social, String nome_fantasia, String cnpj, String ie, String endereco, String telefone, String email) {
        this.razao_social = razao_social;
        this.nome_fantasia = nome_fantasia;
        this.cnpj = cnpj;
        this.ie = ie;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public PessoaJuridica(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }
    

    public PessoaJuridica(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + "Id=" + id + ", Razão social=" + razao_social + ", Nome fantasia=" + nome_fantasia + ", CNPJ=" + cnpj + ", Inscrição Estadual=" + ie + ", Endereço=" + endereco + ", Telefone=" + telefone + ", E-mail=" + email + '}';
    }
    
    
}
