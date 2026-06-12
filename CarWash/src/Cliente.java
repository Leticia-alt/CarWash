/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pc0w0
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Cliente {

    Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Profissional> profissionais = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();
        ArrayList<Pagamento> pagamentos = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n===== LAVA JATO =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Editar Cliente");
            System.out.println("4 - Excluir Cliente");

            System.out.println("5 - Cadastrar Veículo");
            System.out.println("6 - Listar Veículos");
            System.out.println("7 - Editar Veículo");
            System.out.println("8 - Excluir Veículo");

            System.out.println("9 - Cadastrar Profissional");
            System.out.println("10 - Listar Profissionais");
            System.out.println("11 - Editar Profissional");
            System.out.println("12 - Excluir Profissional");

            System.out.println("13 - Cadastrar Serviço");
            System.out.println("14 - Listar Serviços");
            System.out.println("15 - Editar Serviço");
            System.out.println("16 - Excluir Serviço");

            System.out.println("17 - Registrar Pagamento");
            System.out.println("18 - Listar Pagamentos");

            System.out.println("0 - Sair");

            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    clientes.add(
                            new Cliente(
                                    idCliente,
                                    nome,
                                    telefone,
                                    email));

                    System.out.println("Cliente cadastrado.");
                    break;

                case 2:

                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {

                        for (Cliente c : clientes) {
                            c.exibirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 3:

                    System.out.print("ID do cliente: ");
                    int idEditarCliente = sc.nextInt();
                    sc.nextLine();

                    for (Cliente c : clientes) {

                        if (c.getId() == idEditarCliente) {

                            System.out.print("Novo nome: ");
                            c.setNome(sc.nextLine());

                            System.out.print("Novo telefone: ");
                            c.setTelefone(sc.nextLine());

                            System.out.print("Novo email: ");
                            c.setEmail(sc.nextLine());

                            System.out.println("Cliente atualizado.");
                            break;
                        }
                    }

                    break;

                case 4:

                    System.out.print("ID do cliente: ");
                    int idExcluirCliente = sc.nextInt();

                    for (int i = 0; i < clientes.size(); i++) {

                        if (clientes.get(i).getId() == idExcluirCliente) {

                            clientes.remove(i);
                            System.out.println("Cliente removido.");
                            break;
                        }
                    }

                    break;
                                    case 5:

                    if (clientes.isEmpty()) {
                        System.out.println("Cadastre um cliente primeiro.");
                        break;
                    }

                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Cor: ");
                    String cor = sc.nextLine();

                    System.out.println("Clientes cadastrados:");

                    for (Cliente c : clientes) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }

                    System.out.print("ID do proprietário: ");
                    int idProprietario = sc.nextInt();
                    sc.nextLine();

                    Cliente proprietario = null;

                    for (Cliente c : clientes) {
                        if (c.getId() == idProprietario) {
                            proprietario = c;
                            break;
                        }
                    }

                    if (proprietario != null) {

                        veiculos.add(
                                new Veiculo(
                                        placa,
                                        modelo,
                                        marca,
                                        cor,
                                        proprietario));

                        System.out.println("Veículo cadastrado.");
                    }

                    break;

                case 6:

                    if (veiculos.isEmpty()) {
                        System.out.println("Nenhum veículo cadastrado.");
                    } else {

                        for (Veiculo v : veiculos) {
                            v.exibirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 7:

                    System.out.print("Digite a placa do veículo: ");
                    String placaEditar = sc.nextLine();

                    for (Veiculo v : veiculos) {

                        if (v.getPlaca().equalsIgnoreCase(placaEditar)) {

                            System.out.print("Novo modelo: ");
                            v.setModelo(sc.nextLine());

                            System.out.print("Nova marca: ");
                            v.setMarca(sc.nextLine());

                            System.out.print("Nova cor: ");
                            v.setCor(sc.nextLine());

                            System.out.println("Veículo atualizado.");
                            break;
                        }
                    }

                    break;

                case 8:

                    System.out.print("Digite a placa do veículo: ");
                    String placaExcluir = sc.nextLine();

                    for (int i = 0; i < veiculos.size(); i++) {

                        if (veiculos.get(i).getPlaca().equalsIgnoreCase(placaExcluir)) {

                            veiculos.remove(i);
                            System.out.println("Veículo removido.");
                            break;
                        }
                    }

                    break;
                                    case 9:

                    System.out.print("ID: ");
                    int idProfissional = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nomeProfissional = sc.nextLine();

                    System.out.print("Função: ");
                    String funcao = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();

                    profissionais.add(
                            new Profissional(
                                    idProfissional,
                                    nomeProfissional,
                                    funcao,
                                    salario));

                    System.out.println("Profissional cadastrado.");
                    break;

                case 10:

                    if (profissionais.isEmpty()) {
                        System.out.println("Nenhum profissional cadastrado.");
                    } else {

                        for (Profissional p : profissionais) {
                            p.exibirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 11:

                    System.out.print("ID do profissional: ");
                    int idEditarProfissional = sc.nextInt();
                    sc.nextLine();

                    for (Profissional p : profissionais) {

                        if (p.getId() == idEditarProfissional) {

                            System.out.print("Novo nome: ");
                            p.setNome(sc.nextLine());

                            System.out.print("Nova função: ");
                            p.setFuncao(sc.nextLine());

                            System.out.print("Novo salário: ");
                            p.setSalario(sc.nextDouble());
                            sc.nextLine();

                            System.out.println("Profissional atualizado.");
                            break;
                        }
                    }

                    break;

                case 12:

                    System.out.print("ID do profissional: ");
                    int idExcluirProfissional = sc.nextInt();

                    for (int i = 0; i < profissionais.size(); i++) {

                        if (profissionais.get(i).getId() == idExcluirProfissional) {

                            profissionais.remove(i);
                            System.out.println("Profissional removido.");
                            break;
                        }
                    }

                    break;
                                    case 13:

                    if (clientes.isEmpty() || veiculos.isEmpty() || profissionais.isEmpty()) {
                        System.out.println("É necessário ter clientes, veículos e profissionais cadastrados.");
                        break;
                    }

                    System.out.print("ID do serviço: ");
                    int idServico = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Clientes:");

                    for (Cliente c : clientes) {
                        System.out.println(c.getId() + " - " + c.getNome());
                    }

                    System.out.print("ID do cliente: ");
                    int idClienteServico = sc.nextInt();
                    sc.nextLine();

                    Cliente clienteServico = null;

                    for (Cliente c : clientes) {
                        if (c.getId() == idClienteServico) {
                            clienteServico = c;
                            break;
                        }
                    }

                    System.out.println("Veículos:");

                    for (Veiculo v : veiculos) {
                        System.out.println(v.getPlaca() + " - " + v.getModelo());
                    }

                    System.out.print("Placa do veículo: ");
                    String placaServico = sc.nextLine();

                    Veiculo veiculoServico = null;

                    for (Veiculo v : veiculos) {
                        if (v.getPlaca().equalsIgnoreCase(placaServico)) {
                            veiculoServico = v;
                            break;
                        }
                    }

                    System.out.println("Profissionais:");

                    for (Profissional p : profissionais) {
                        System.out.println(p.getId() + " - " + p.getNome());
                    }

                    System.out.print("ID do profissional: ");
                    int idProfServico = sc.nextInt();
                    sc.nextLine();

                    Profissional profissionalServico = null;

                    for (Profissional p : profissionais) {
                        if (p.getId() == idProfServico) {
                            profissionalServico = p;
                            break;
                        }
                    }

                    System.out.print("Descrição do serviço: ");
                    String descricao = sc.nextLine();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Data: ");
                    String data = sc.nextLine();

                    servicos.add(
                            new Servico(
                                    idServico,
                                    clienteServico,
                                    veiculoServico,
                                    profissionalServico,
                                    descricao,
                                    valor,
                                    data));

                    System.out.println("Serviço cadastrado.");
                    break;

                case 14:

                    if (servicos.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado.");
                    } else {

                        for (Servico s : servicos) {
                            s.exibirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 15:

                    System.out.print("ID do serviço: ");
                    int idEditarServico = sc.nextInt();
                    sc.nextLine();

                    for (Servico s : servicos) {

                        if (s.getId() == idEditarServico) {

                            System.out.print("Nova descrição: ");
                            s.setDescricao(sc.nextLine());

                            System.out.print("Novo valor: ");
                            s.setValor(sc.nextDouble());
                            sc.nextLine();

                            System.out.print("Nova data: ");
                            s.setData(sc.nextLine());

                            System.out.println("Serviço atualizado.");
                            break;
                        }
                    }

                    break;

                case 16:

                    System.out.print("ID do serviço: ");
                    int idExcluirServico = sc.nextInt();

                    for (int i = 0; i < servicos.size(); i++) {

                        if (servicos.get(i).getId() == idExcluirServico) {

                            servicos.remove(i);
                            System.out.println("Serviço removido.");
                            break;
                        }
                    }

                    break;
                                    case 17:

                    if (servicos.isEmpty()) {
                        System.out.println("Nenhum serviço cadastrado.");
                        break;
                    }

                    System.out.print("ID do pagamento: ");
                    int idPagamento = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Serviços cadastrados:");

                    for (Servico s : servicos) {
                        System.out.println(s.getId() + " - " + s.getDescricao());
                    }

                    System.out.print("ID do serviço: ");
                    int idServicoPagamento = sc.nextInt();
                    sc.nextLine();

                    Servico servicoPagamento = null;

                    for (Servico s : servicos) {

                        if (s.getId() == idServicoPagamento) {
                            servicoPagamento = s;
                            break;
                        }
                    }

                    if (servicoPagamento == null) {
                        System.out.println("Serviço não encontrado.");
                        break;
                    }

                    System.out.print("Forma de pagamento: ");
                    String formaPagamento = sc.nextLine();

                    System.out.print("Pagamento realizado? (true/false): ");
                    boolean pago = sc.nextBoolean();

                    pagamentos.add(
                            new Pagamento(
                                    idPagamento,
                                    servicoPagamento,
                                    servicoPagamento.getValor(),
                                    formaPagamento,
                                    pago));

                    System.out.println("Pagamento registrado.");
                    break;

                case 18:

                    if (pagamentos.isEmpty()) {
                        System.out.println("Nenhum pagamento registrado.");
                    } else {

                        for (Pagamento p : pagamentos) {
                            p.exibirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

}
