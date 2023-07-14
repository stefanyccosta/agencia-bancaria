package programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;


    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("------------------------------------------------");
        System.out.println("----------Bem vindos a nossa Agência------------");
        System.out.println("------------------------------------------------");
        System.out.println("###Selecione uma operação que deseja realizar###");
        System.out.println("------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta  |");
        System.out.println("|   Opção 2 - Depositar    |");
        System.out.println("|   Opção 3 - Sacar        |");
        System.out.println("|   Opção 4 - Transferir   |");
        System.out.println("|   Opção 1 - Listar       |");
        System.out.println("|   Opção 1 - Sair         |");


        int operacao = teclado.nextInt();
        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                tranferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("Muito obrigado, volte sempre!");
                System.exit(0);
            default:
                System.out.println("Operação inválida! =(");
                operacoes();
                break;

        }

    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = teclado.next();

        System.out.println("\nCPF: ");
        String cpf = teclado.next();

        System.out.println("\nEmail: ");
        String email = teclado.next();
        Cliente usuario = new Cliente(nome, cpf, email);

        Conta conta = new Conta(usuario);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso! =)");
        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            Double valorDeposito = teclado.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = teclado.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja sacar?");
            Double valorSaque = teclado.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    public static void tranferir() {
        System.out.println("Número da conta do remetente: ");
        int numeroRemetente = teclado.nextInt();
        Conta contaRemetente = encontrarConta(numeroRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta destinatário: ");
            int numeroContaDestinatario = teclado.nextInt();
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferênicia: ");
                Double valor = teclado.nextDouble();
                contaRemetente.transferir(contaDestinatario, valor);
            }
        } else {
            System.out.println("Conta não encotrada!");
        }
        operacoes();
    }

    public static void listar() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }


    }


}