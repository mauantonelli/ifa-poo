package domain.entity;

public class Manutencao {
    private int id;
    private String data;
    private double custo;
    private Veiculo veiculo;
    private Mecanico mecanico;

    public Manutencao(int id, String data, double custo, Veiculo veiculo, Mecanico mecanico) {
        this.id = id;
        this.data = data;
        this.custo = custo;
        this.veiculo = veiculo;
        this.mecanico = mecanico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", custo=" + custo +
                ", veiculo=" + veiculo +
                ", mecanico=" + mecanico +
                '}';
    }
}
