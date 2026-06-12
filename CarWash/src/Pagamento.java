/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc0w0
 */
public class Pagamento {

    private int id;
    private Servico servico;
    private double valor;
    private String formaPagamento;
    private boolean pago;

    public Pagamento(int id, Servico servico, double valor,
                     String formaPagamento, boolean pago) {

        this.id = id;
        this.servico = servico;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.pago = pago;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void exibirDados() {
        System.out.println("ID Pagamento: " + id);
        System.out.println("Cliente: " + servico.getCliente().getNome());
        System.out.println("Serviço: " + servico.getDescricao());
        System.out.println("Valor: R$ " + valor);
        System.out.println("Forma de Pagamento: " + formaPagamento);
        System.out.println("Pago: " + (pago ? "Sim" : "Não"));
    }
}