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

    private static int contadorCliente = 1;
    private static int contadorVeiculo = 1;
    private static int contadorProfissional = 1;
    private static int contadorServico = 1;
    private static int contadorFluxo = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        profissionais.add(new Profissional(contadorProfissional++, "Carlos", "Lavador", "9999-1111"));
        servicos.add(new LimpezaSimples(contadorServico++, "Lavação Simples", 50.0, 10.0));
        servicos.add(new EsteticaAvancada(contadorServico++, "Polimento Técnico", 200.0, 1.5));

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DE LIMPEZA AUTOMOTIVA ---");
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
                    Cliente novoCliente = new Cliente(contadorCliente++, nomeCli, cpf, telCli);
                    clientes.add(novoCliente);

                    System.out.print("Placa do Veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    Veiculo novoVeiculo = new Veiculo(contadorVeiculo++, placa, modelo, marca, novoCliente);
                    veiculos.add(novoVeiculo);
                    System.out.println("Cliente e Veículo cadastrados com sucesso!");
                    break;

                case 2:
                    System.out.println("\n[1] Cadastrar [2] Editar [3] Excluir [4] Listar");
                    int subOpcao = scanner.nextInt();
                    scanner.nextLine();
                    if (subOpcao == 1) {
                        System.out.print("Nome do Profissional: ");
                        String nomeProf = scanner.nextLine();
                        System.out.print("Cargo: ");
                        String cargo = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telProf = scanner.nextLine();
                        profissionais.add(new Profissional(contadorProfissional++, nomeProf, cargo, telProf));
                        System.out.println("Profissional cadastrado!");
                    } else if (subOpcao == 2) {
                        System.out.print("ID do Profissional para editar: ");
                        int idEdit = scanner.nextInt();
                        scanner.nextLine();
                        for (Profissional p : profissionais) {
                            if (p.getId() == idEdit) {
                                System.out.print("Novo Nome: ");
                                p.setNome(scanner.nextLine());
                                System.out.print("Novo Cargo: ");
                                p.setCargo(scanner.nextLine());
                                System.out.println("Dados alterados!");
                            }
                        }
                    } else if (subOpcao == 3) {
                        System.out.print("ID do Profissional para excluir: ");
                        int idExcluir = scanner.nextInt();
                        profissionais.removeIf(p -> p.getId() == idExcluir);
                        System.out.println("Profissional removido!");
                    } else if (subOpcao == 4) {
                        for (Profissional p : profissionais) p.exibirDados();
                    }
                    break;

                case 3:
                    System.out.println("--- Lista de Veículos ---");
                    for (Veiculo v : veiculos) v.exibirDados();
                    System.out.print("Selecione o ID do Veículo: ");
                    int idV = scanner.nextInt();

                    System.out.println("--- Lista de Profissionais ---");
                    for (Profissional p : profissionais) p.exibirDados();
                    System.out.print("Selecione o ID do Profissional: ");
                    int idP = scanner.nextInt();

                    System.out.println("--- Lista de Serviços Disponíveis ---");
                    for (Servico s : servicos) s.exibirDados();
                    System.out.print("Selecione o ID do Serviço: ");
                    int idS = scanner.nextInt();

                    Veiculo vSel = null;
                    for (Veiculo v : veiculos) if (v.getId() == idV) vSel = v;

                    Profissional pSel = null;
                    for (Profissional p : profissionais) if (p.getId() == idP) pSel = p;

                    Servico sSel = null;
                    for (Servico s : servicos) if (s.getId() == idS) sSel = s;

                    if (vSel != null && pSel != null && sSel != null) {
                        fluxos.add(new FluxoServico(contadorFluxo++, vSel, pSel, sSel));
                        System.out.println("Fluxo de trabalho iniciado e registrado!");
                    } else {
                        System.out.println("Dados inválidos. Não foi possível iniciar.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Histórico de Fluxo de Serviços ---");
                    for (FluxoServico f : fluxos) f.exibirDados();
                    break;

                case 5:
                    System.out.println("--- Serviços Pendentes ---");
                    for (FluxoServico f : fluxos) {
                        if (f.getStatusPagamento().equals("PENDENTE")) f.exibirDados();
                    }
                    System.out.print("ID do Fluxo para finalizar e pagar: ");
                    int idF = scanner.nextInt();
                    scanner.nextLine();

                    FluxoServico fSel = null;
                    for (FluxoServico f : fluxos) if (f.getId() == idF) fSel = f;

                    if (fSel != null && fSel.getStatusPagamento().equals("PENDENTE")) {
                        System.out.print("Forma de Pagamento (PIX ou DINHEIRO): ");
                        String forma = scanner.nextLine();
                        fSel.registrarPagamento(forma);
                        faturamentoTotal += fSel.getValorCobrado();
                        System.out.println("Pagamento registrado! Serviço Concluído.");
                    } else {
                        System.out.println("Fluxo não encontrado ou já finalizado.");
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