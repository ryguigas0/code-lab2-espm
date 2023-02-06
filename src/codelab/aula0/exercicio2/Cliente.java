package codelab.aula0.exercicio2;

import java.util.Random;

public class Cliente {
    int numeroConta;
    String nomeDono;
    double saldo = 0.0;

    public static Cliente criarCliente(String nomeDono) {
        Cliente c = new Cliente();

        c.numeroConta = gerarNumeroConta();
        c.nomeDono = nomeDono;

        return c;
    }

    private static int gerarNumeroConta() {
        Random r = new Random();

        return r.nextInt();
    }

    public void saque(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("SAQUE DE " + String.format("R$%.2f", valor) + "CONCLUIDO");
        } else {
            System.out.println("SALDO INSUFICIENTE PARA SAQUE DE " + String.format("R$%.2f", valor));
        }
    }

    public void deposito(double valor) {
        saldo += valor;

        System.out.println("DEPÓSITO DE " + String.format("R$%.2f", valor) + " CONCLUÍDO");
    }

    public void consultarSaldo() {
        System.out.println("--------- CONTA " + numeroConta + " ------------");
        System.out.println("DONO: " + nomeDono);
        System.out.println("SALDO: " + String.format("R$%.2f", saldo));
        System.out.println("----------------------------------------------");
    }
}
