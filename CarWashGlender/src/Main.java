import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Profissional> profissionais = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();
    private static List<FluxoServico> fluxos = new ArrayList<>();
    private static double faturamentoTotal = 0.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        profissionais.add(new Profissional("Carlos", "Lavador", "9999-1111"));
        servicos.add(new LimpezaSimples("Lavação Simples", 50.0, 10.0));
        servicos.add(new EsteticaAvancada("Polimento Técnico", 200.0, 1.5));

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n SISTEMA DE LIMPEZA AUTOMOTIVA");
            System.out.println("1. Cadastrar Cliente e Veículo");
            System.out.println("2. Gerenciar Profissionais (CRUD)");
            System.out.println("3. Iniciar Novo Fluxo de Serviço");
            System.out.println("4. Consultar Serviços/Fluxos");
            System.out.println("5. Finalizar Serviço e Registrar Pagamento");
            System.out.println("6. Ver Faturamento Geral");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Cliente: ");
                    String nomeCli = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telCli = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nomeCli, cpf, telCli);
                    clientes.add(novoCliente);

                    System.out.print("Placa do Veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    Veiculo novoVeiculo = new Veiculo(placa, modelo, marca, novoCliente);
                    veiculos.add(novoVeiculo);
                    System.out.println("Cliente e Veículo cadastrados com sucesso!");
                    break;

                case 2:
                    System.out.println("\n1 Cadastrar 2 Editar 3 Excluir 4 Listar");
                    int subOpcao = scanner.nextInt();
                    scanner.nextLine();

                    if (subOpcao == 1) {
                        System.out.print("Nome do Profissional: ");
                        String nomeProf = scanner.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telProf = scanner.nextLine();
                        profissionais.add(new Profissional(nomeProf, cargo, telProf));
                        System.out.println("Profissional cadastrado!");

                    } else if (subOpcao == 2) {
                        System.out.println("Lista de Profissionais");
                        for (int i = 0; i < profissionais.size(); i++) {
                            System.out.print("[" + i + "] ");
                            profissionais.get(i).exibirDados();
                        }
                        System.out.print("Digite o número do Profissional para editar ");
                        int posicaoEdit = scanner.nextInt();
                        scanner.nextLine();

                        if (posicaoEdit >= 0 && posicaoEdit < profissionais.size()) {
                            Profissional p = profissionais.get(posicaoEdit);
                            System.out.print("Novo Nome: ");
                            p.setNome(scanner.nextLine());
                            System.out.print("Novo Cargo: ");
                            p.setCargo(scanner.nextLine());
                            System.out.println("Dados alterados!");
                        }

                    } else if (subOpcao == 3) {
                        System.out.println("Lista de Profissionais");
                        for (int i = 0; i < profissionais.size(); i++) {
                            System.out.print("[" + i + "] ");
                            profissionais.get(i).exibirDados();
                        }
                        System.out.print("Digite o número do Profissional para excluir: ");
                        int posicaoExcluir = scanner.nextInt();

                        if (posicaoExcluir >= 0 && posicaoExcluir < profissionais.size()) {
                            profissionais.remove(posicaoExcluir);
                            System.out.println("Profissional removido!");
                        }

                    } else if (subOpcao == 4) {
                        for (int i = 0; i < profissionais.size(); i++) {
                            profissionais.get(i).exibirDados();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Lista de Veículos");
                    for (int i = 0; i < veiculos.size(); i++) {
                        System.out.print("[" + i + "] ");
                        veiculos.get(i).exibirDados();
                    }
                    System.out.print("Selecione o número do Veículo: ");
                    int posV = scanner.nextInt();

                    System.out.println("Lista de Profissionais");
                    for (int i = 0; i < profissionais.size(); i++) {
                        System.out.print("[" + i + "] ");
                        profissionais.get(i).exibirDados();
                    }
                    System.out.print("Selecione o número do Profissional: ");
                    int posP = scanner.nextInt();

                    System.out.println("Lista de Serviços Disponíveis");
                    for (int i = 0; i < servicos.size(); i++) {
                        System.out.print("[" + i + "] ");
                        servicos.get(i).exibirDados();
                    }
                    System.out.print("Selecione o número do Serviço: ");
                    int posS = scanner.nextInt();

                    if (posV >= 0 && posV < veiculos.size() && posP >= 0 && posP < profissionais.size() && posS >= 0 && posS < servicos.size()) {
                        Veiculo vSel = veiculos.get(posV);
                        Profissional pSel = profissionais.get(posP);
                        Servico sSel = servicos.get(posS);

                        fluxos.add(new FluxoServico(vSel, pSel, sSel));
                        System.out.println("Fluxo de trabalho iniciado e registrado!");
                    } else {
                        System.out.println("Opções inválidas!");
                    }
                    break;

                case 4:
                    System.out.println("Histórico de Fluxo de Serviços");
                    for (int i = 0; i < fluxos.size(); i++) {
                        System.out.print("[" + i + "] ");
                        fluxos.get(i).exibirDados();
                    }
                    break;

                case 5:
                    System.out.println("--- Serviços Pendentes ---");
                    for (int i = 0; i < fluxos.size(); i++) {
                        if (fluxos.get(i).getStatusPagamento().equals("PENDENTE")) {
                            System.out.print("[" + i + "] ");
                            fluxos.get(i).exibirDados();
                        }
                    }
                    System.out.print("Digite o número do Fluxo para finalizar e pagar: ");
                    int posF = scanner.nextInt();
                    scanner.nextLine();

                    if (posF >= 0 && posF < fluxos.size()) {
                        FluxoServico fSel = fluxos.get(posF);
                        if (fSel.getStatusPagamento().equals("PENDENTE")) {
                            System.out.print("Forma de Pagamento (PIX ou DINHEIRO): ");
                            String forma = scanner.nextLine();
                            fSel.registrarPagamento(forma);
                            faturamentoTotal += fSel.getValorCobrado();
                            System.out.println("Pagamento registrado! Serviço Concluído.");
                        }
                    } else {
                        System.out.println("Serviço não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\n==================================");
                    System.out.println("Faturamento Total do Caixa: R$ " + faturamentoTotal);
                    System.out.println("==================================");
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}