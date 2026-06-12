/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carwash;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pc0w0
 */
public class CarWash {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        ArrayList<Profissional> profissionais = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n=== SISTEMA LAVA JATO ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Veículo");
            System.out.println("4 - Listar Veículos");
            System.out.println("5 - Cadastrar Profissional");
            System.out.println("6 - Listar Profissionais");
            System.out.println("7 - Cadastrar Serviço");
            System.out.println("8 - Listar Serviços");
            System.out.println("0 - Sair");

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

                    clientes.add(new Cliente(idCliente, nome, telefone, email));

                    System.out.println("Cliente cadastrado!");
                    break;

                case 2:

                    for (Cliente c : clientes) {
                        c.exibirDados();
                        System.out.println();
                    }

                    break;

                case 3:

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

                    Cliente proprietario = clientes.get(0);

                    veiculos.add(new Veiculo(
                            placa,
                            modelo,
                            marca,
                            cor,
                            proprietario));

                    System.out.println("Veículo cadastrado!");
                    break;

                case 4:

                    for (Veiculo v : veiculos) {
                        v.exibirDados();
                        System.out.println();
                    }

                    break;

                case 5:

                    System.out.print("ID: ");
                    int idProf = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nomeProf = sc.nextLine();

                    System.out.print("Função: ");
                    String funcao = sc.nextLine();

                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();

                    profissionais.add(
                            new Profissional(
                                    idProf,
                                    nomeProf,
                                    funcao,
                                    salario));

                    System.out.println("Profissional cadastrado!");
                    break;

                case 6:

                    for (Profissional p : profissionais) {
                        p.exibirDados();
                        System.out.println();
                    }

                    break;

                case 7:

                    System.out.println("Cadastro de serviço será implementado depois.");
                    break;

                case 8:

                    for (Servico s : servicos) {
                        s.exibirDados();
                        System.out.println();
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
    
}
