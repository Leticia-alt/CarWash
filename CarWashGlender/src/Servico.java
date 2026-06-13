public abstract class Servico {
    private String nome;
    private double precoBase;

    public Servico(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
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
        System.out.println("Serviço: " + nome + " | Preço Base: R$ " + precoBase);
    }
}