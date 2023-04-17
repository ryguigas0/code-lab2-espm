package codelab.prova1.questao1;

import java.util.Stack;

import lista.dupla.ListaDuplaGenerica;
import lista.dupla.NodoGenerico;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> pilhaA = new Stack<Integer>();
        pilhaA.push(12);
        pilhaA.push(29);
        pilhaA.push(36);

        Stack<Integer> pilhaB = new Stack<Integer>();
        pilhaB.push(12);
        pilhaB.push(36);
        pilhaB.push(29);

        Stack<Integer> pilhaC = new Stack<Integer>();
        pilhaC.push(14);
        pilhaC.push(29);
        pilhaC.push(3);
        pilhaC.push(5);

        System.out.println("pilhaA == pilhaB? " + compararPilhas(pilhaA, pilhaB));
        System.out.println("pilhaA == pilhaC? " + compararPilhas(pilhaA, pilhaC));
    }

    private static boolean compararPilhas(Stack<Integer> pilhaX, Stack<Integer> pilhaY) {
        if (pilhaX.size() != pilhaY.size()) {
            return false;
        }

        ListaDuplaGenerica<Integer> elemsX = new ListaDuplaGenerica<Integer>();

        while (pilhaX.size() > 0) {
            int x = pilhaX.pop();
            elemsX.inserirFim(x);
        }

        while (pilhaY.size() > 0) {
            int y = pilhaY.pop();

            NodoGenerico<Integer> resultadoBusca = elemsX.pesquisar(y);

            if (resultadoBusca == null) {
                return false;
            }
        }

        return true;
    }

}
