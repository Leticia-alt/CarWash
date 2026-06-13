public class EsteticaAvancada extends Servico {
    private double multiplicadorDificuldade;

    public EsteticaAvancada(int id, String nome, double precoBase, double multiplicadorDificuldade) {
        super(id, nome, precoBase);
        this.multiplicadorDificuldade = multiplicadorDificuldade;
    }

    public double getMultiplicadorDificuldade() {
        return multiplicadorDificuldade;
    }

    public void setMultiplicadorDificuldade(double multiplicadorDificuldade) {
        this.multiplicadorDificuldade = multiplicadorDificuldade;
    }

    public double calcularPrecoFinal() {
        return getPrecoBase() * multiplicadorDificuldade;
    }
}