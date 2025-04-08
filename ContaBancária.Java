import java.util.Scanner;
import java.util.Random;

public class ContaBancária {
    private String nome;
    private double saldo;
    private int conta;

    public ContaBancária(String nome, int conta, double inicial) {
        this.nome = nome;
        this.conta = conta;
        this.saldo = inicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Deposito de R$" + valor + " realizado com sucesso.");
    }

    public void consultarSaldo() {
        System.out.println("Nome do cliente: " + nome);
        System.out.println("Numero da conta: " + conta);
        System.out.println("Saldo atual: R$" + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastrando novo cliente.");

        System.out.print("Entre com seu nome: ");
        String nome = scanner.nextLine();

        Random numero = new Random();
        int conta = 1 + numero.nextInt(9999);

        System.out.print("Insira o valor inicial depositado na conta: ");
        double inicial = scanner.nextDouble();

        ContaBancária minhaConta = new ContaBancária(nome, conta, inicial);

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Depositar");
            System.out.println("2. Consultar Saldo");
            System.out.println("0. Sair");
            System.out.print("Opçao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Informe o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    minhaConta.depositar(valorDeposito);
                }
                case 2 -> minhaConta.consultarSaldo();
                case 0 -> System.out.println("Saindo do programa. Obrigado!");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
