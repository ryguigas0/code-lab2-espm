package codelab.aula5.pilha.exercicio1;

import java.util.Scanner;
import java.util.Stack;

public class ConversaoBinario {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.print("Digite um número inteiro e positivo: ");
        Long input = kb.nextLong();

        kb.close();

        if (input < 0) {
            throw new RuntimeException("Número não inteiro ou não positivo");
        }

        System.out.println(String.format("%d em binario é %s", input, converter(input)));
    }

    private static String converter(Long input) {
        Stack<Long> binario = new Stack<>();

        long dividendo = input;

        do {
            binario.push(dividendo % 2);
            dividendo = dividendo / 2;
        } while (dividendo != 0);

        String output = "";

        while (!binario.empty()) {
            output += binario.pop();
        }

        return output;
    }
}
