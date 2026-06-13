public class FluxoServico {
    private int id;
    private Veiculo veiculo;
    private Profissional profissional;
    private Servico servico;
    private String statusPagamento;
    private double valorCobrado;

    public FluxoServico(int id, Veiculo veiculo, Profissional profissional, Servico servico) {
        this.id = id;
        this.veiculo = veiculo;
        this.profissional = profissional;
        this.servico = servico;
        this.statusPagamento = "PENDENTE";
        this.valorCobrado = servico.calcularPrecoFinal();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        System.out.println("Fluxo ID: " + id + " | Veículo: " + veiculo.getPlaca() + " | Profissional: " + profissional.getNome() + " | Valor: R$ " + valorCobrado + " | Status: " + statusPagamento);
    }
}