public abstract class Servico {
    private int id;
    private String nome;
    private double precoBase;

    public Servico(int id, String nome, double precoBase) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
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

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public abstract double calcularPrecoFinal();

    public void exibirDados() {
        System.out.println("ID: " + id + " | Serviço: " + nome + " | Preço Base: R$ " + precoBase);
    }
}