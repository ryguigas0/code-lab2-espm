package codelab.aula0.exercicio1;

import java.util.Scanner;

public class Paciente {
    String nome;
    int idade;

    public static Paciente inputarPaciente() {
        Scanner s = new Scanner(System.in);

        System.out.print("Escreva o nome do paciente: ");
        String nome = s.nextLine();
        System.out.print("Escreva a idade do paciente " + nome + ": ");
        int idade = s.nextInt();

        s.close();

        return criarPaciente(nome, idade);
    }

    public static Paciente criarPaciente(String nome, int idade) {
        Paciente p = new Paciente();

        p.nome = nome;
        p.idade = idade;

        return p;
    }

    public int freqMaxima() {
        return 220 - idade;
    }

    public double[] freqAlvo() {
        double[] freqs = new double[2];

        freqs[0] = freqMaxima() * 0.50;

        freqs[1] = freqMaxima() * 0.85;

        return freqs;
    }

    public void printar() {
        System.out.println("-------------PACIENTE-----------");
        System.out.println("NOME: " + nome);
        System.out.println("IDADE: " + idade);
        System.out.println("FREQ MÁXIMA: " + freqMaxima());
        System.out.println("FREQ ALVO MIN: " + freqAlvo()[0]);
        System.out.println("FREQ ALVO MAX: " + freqAlvo()[1]);
        System.out.println("--------------------------------");
    }
}
