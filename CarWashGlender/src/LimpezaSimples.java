public class LimpezaSimples extends Servico {
    private double taxaProdutos;

    public LimpezaSimples(int id, String nome, double precoBase, double taxaProdutos) {
        super(id, nome, precoBase);
        this.taxaProdutos = taxaProdutos;
    }

    public double getTaxaProdutos() {
        return taxaProdutos;
    }

    public void setTaxaProdutos(double taxaProdutos) {
        this.taxaProdutos = taxaProdutos;
    }

    public double calcularPrecoFinal() {
        return getPrecoBase() + taxaProdutos;
    }
}