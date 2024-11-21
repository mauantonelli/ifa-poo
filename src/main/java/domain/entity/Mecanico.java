package domain.entity;

public class Mecanico extends Pessoa {

    private double salario;

    public Mecanico(int id, String nome, double salario) {
        super(id, nome);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
