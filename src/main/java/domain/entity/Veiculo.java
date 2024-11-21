package domain.entity;

public class Veiculo {
    private int id;
    private String placa;
    private String marca;
    private Proprietario proprietario;

    public Veiculo(int id, String placa, String marca, Proprietario proprietario) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.proprietario = proprietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", proprietario=" + proprietario +
                '}';
    }
}
