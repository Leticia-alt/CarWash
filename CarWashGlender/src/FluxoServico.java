public class FluxoServico {
    private Veiculo veiculo;
    private Profissional profissional;
    private Servico servico;
    private String statusPagamento;
    private double valorCobrado;

    public FluxoServico(Veiculo veiculo, Profissional profissional, Servico servico) {
        this.veiculo = veiculo;
        this.profissional = profissional;
        this.servico = servico;
        this.statusPagamento = "PENDENTE";
        this.valorCobrado = servico.calcularPrecoFinal();
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public double getValorCobrado() {
        return valorCobrado;
    }

    public void registrarPagamento(String formaPagamento) {
        if (formaPagamento.equalsIgnoreCase("PIX")) {
            this.valorCobrado = this.valorCobrado * 0.90;
        }
        this.statusPagamento = "PAGO";
    }

    public void exibirDados() {
        System.out.println("Veículo " + veiculo.getPlaca() + "Profissional: " + profissional.getNome() + "Valor " + valorCobrado + "Status " + statusPagamento);
    }
}
