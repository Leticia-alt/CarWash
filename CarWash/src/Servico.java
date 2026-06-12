/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc0w0
 */
public class Servico {

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private Profissional profissional;
    private String descricao;
    private double valor;
    private String data;

    public Servico(int id, Cliente cliente, Veiculo veiculo,
                   Profissional profissional, String descricao,
                   double valor, String data) {

        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.profissional = profissional;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void exibirDados() {
        System.out.println("ID: " + id);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getModelo());
        System.out.println("Profissional: " + profissional.getNome());
        System.out.println("Serviço: " + descricao);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data: " + data);
    }
}