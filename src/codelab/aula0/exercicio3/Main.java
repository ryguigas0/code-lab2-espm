package codelab.aula0.exercicio3;

import java.util.Scanner;

public class Main {

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        Professor p1 = inputarProfessor();
        Professor p2 = inputarProfessor();
        Professor p3 = inputarProfessor();

        p1.printarProfessor();
        p2.printarProfessor();
        p3.printarProfessor();

    }

    public static Professor inputarProfessor() {

        System.out.print("Escreva o nome do professor: ");
        String nome = s.nextLine();

        System.out.print("Escreva o valor da aula do professor " + nome + ": ");
        double valorAula = s.nextDouble();

        System.out.print("Escreva quantidade de aulas semanais do professor " + nome + ": ");
        int quantidadeAulasSemanais = s.nextInt();

        s.nextLine();

        return Professor.criarProfessor(nome, valorAula, quantidadeAulasSemanais);
    }
}