package codelab.aula5.pilha.exercicio3;

import java.util.Stack;

public class NotacaoPolonesa {

    public static void main(String[] args) {
        String input = "A+B+C";
        String output = converterInfixo2Posfixo(input);

        System.out.println("Entrada -> " + input);
        System.out.println("Saída   -> " + output);
    }

    private static String converterInfixo2Posfixo(String input) {
        Stack<Character> operacoes = new Stack<Character>();
        String posfixo = "";

        for (int i = 0; i < input.length(); i++) {
            char simbolo = input.charAt(i);

            switch (simbolo) {
                case ')':
                    while (operacoes.peek() != '(') {
                        posfixo += operacoes.pop();
                    }
                    operacoes.pop();
                    break;
                case '(':
                case '*':
                case '/':
                case '%':
                    operacoes.push(simbolo);
                    break;
                case '+':
                case '-':
                    while (!operacoes.empty() && (prioridadeSimbolo(operacoes.peek()) >= prioridadeSimbolo(simbolo))) {
                        posfixo += operacoes.pop();
                    }
                    operacoes.push(simbolo);
                    break;

                default:
                    posfixo += simbolo;
                    break;
            }

        }

        while (!operacoes.empty()) {
            posfixo += operacoes.pop();
        }

        return posfixo;
    }

    private static int prioridadeSimbolo(char simbolo) {
        int prioridade = 0;
        switch (simbolo) {
            case '*':
            case '/':
            case '%':
                prioridade = 2;
                break;
            case '+':
            case '-':
                prioridade = 1;
                break;
        }

        return prioridade;
    }
}