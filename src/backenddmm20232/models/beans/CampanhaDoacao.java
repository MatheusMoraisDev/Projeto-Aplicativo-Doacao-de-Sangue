package backenddmm20232.models.beans;

/**
 * Author: Livia Caroline
 */
public class CampanhaDoacao {

    private int id, idHospital;
    private String nomeCampanha, dataInicio, dataFim, descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(int idHospital) {
        this.idHospital = idHospital;
    }

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CampanhaDoacao(int id) {
        this.id = id;
    }

    public CampanhaDoacao(int idHospital, String nomeCampanha, String dataInicio, String dataFim, String descricao) {
        this.idHospital = idHospital;
        this.nomeCampanha = nomeCampanha;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }

    public CampanhaDoacao(int id, int idHospital, String nomeCampanha, String dataInicio, String dataFim, String descricao) {
        this.id = id;
        this.idHospital = idHospital;
        this.nomeCampanha = nomeCampanha;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.descricao = descricao;
    }

    public CampanhaDoacao(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    @Override
    public String toString() {
        return "CampanhaDoacao{" +
                "id=" + id +
                ", ID Hospital=" + idHospital +
                ", nomeCampanha=" + nomeCampanha +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", descricao=" + descricao +
                '}';
    }
}