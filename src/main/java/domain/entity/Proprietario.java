package domain.entity;

public class Proprietario extends Pessoa {
    private String telefone;

    public Proprietario(int id, String nome, String telefone) {
        super(id, nome);
        this.telefone = telefone;
    }

    // Por o ID no banco ter AI, fiquei com a duvida de passar ele pelo construtor ou não!

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
