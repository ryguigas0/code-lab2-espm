package codelab.aula3.exemplo2;

import java.util.Random;

public class Conta {
    private String nome;
    private double saldo = 0;

    public Conta(String nome) {
        this.nome = nome;
        this.saldo = (new Random()).nextDouble() * 10000;
    }

    public void depositar(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor >= 0) {
            this.saldo -= valor;
        }
    }

    @Override
    public String toString() {
        return String.format("{ nome: \"%s\", saldo: \"R$%.2f\" }", nome, saldo);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Conta) &&
                ((Conta) obj).nome.equalsIgnoreCase(this.nome);
    }

}
