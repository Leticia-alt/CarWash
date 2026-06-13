public class Profissional {
    private int id;
    private String nome;
    private String cargo;
    private String telefone;

    public Profissional(int id, String nome, String cargo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void exibirDados() {
        System.out.println("ID: " + id + " | Nome: " + nome + " | Cargo: " + cargo);
    }
}