package domain.entity;

public class Proprietario extends Pessoa {
    private String telefone;

    public Proprietario(int id, String nome, String telefone) {
        super(id, nome);
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
