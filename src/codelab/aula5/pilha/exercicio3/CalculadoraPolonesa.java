package codelab.aula5.pilha.exercicio3;

import java.util.HashMap;
import java.util.Stack;

public class CalculadoraPolonesa {
    public static void main(String[] args) {
        String inputExpressao = "ABC+*D*";

        HashMap<String, Integer> variaveis = new HashMap<String, Integer>();
        variaveis.put("A", 1);
        variaveis.put("B", 2);
        variaveis.put("C", 3);
        variaveis.put("D", 1);

        int resultado = calcularNotacaoPolonesa(inputExpressao, variaveis);

        System.out.println("Expressão -> " + inputExpressao);
        System.out.println("Valores -> " + variaveis);
        System.out.println("Resultado -> " + resultado);
    }

    private static int calcularNotacaoPolonesa(String expressao, HashMap<String, Integer> variaveis) {
        Stack<Integer> numeros = new Stack<Integer>();

        for (int i = 0; i < expressao.length(); i++) {
            char simbolo = expressao.charAt(i);

            if (simbolo != '+' && simbolo != '-' && simbolo != '*' && simbolo != '/' && simbolo != '%') {
                // Coloca os numeros que vão ser usados para operações
                // na ordem do mais recente para o mais velho
                numeros.push(variaveis.get(expressao.charAt(i) + ""));
            } else {
                // Quando for uma operação, calcular a operação e colocar na 
                // stack para ser usado em operações dependentes
                numeros.push(calcular(simbolo, numeros.pop(), numeros.pop()));
            }
        }

        // Vai sobrar na stack a soma de tudo
        return numeros.peek();
    }

    private static int calcular(char charOperador, int elem1, int elem2) {
        if (charOperador == '+') {
            return elem1 + elem2;
        } else if (charOperador == '-') {
            return elem1 - elem2;
        } else if (charOperador == '*') {
            return elem1 * elem2;
        } else if (charOperador == '/') {
            return elem1 / elem2;
        } else {
            throw new RuntimeException("Operador inválido!");
        }
    }
}
