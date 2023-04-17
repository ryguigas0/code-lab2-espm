package codelab.prova1.questao2;

import java.util.Stack;

import lista.dupla.ListaDuplaGenerica;
import lista.dupla.NodoGenerico;

public class Main {
    public static void main(String[] args) {
        ListaDuplaGenerica<Integer> listaInput = new ListaDuplaGenerica<Integer>();

        for (int i = 0; i < 10; i++) {
            listaInput.inserirFim(i);
        }

        ListaDuplaGenerica<Integer> listaEsperada = new ListaDuplaGenerica<Integer>();

        for (int i = 9; i >= 0; i--) {
            listaEsperada.inserirFim(i);
        }

        System.out.println("listaEsperada -> " + listaInput);
        System.out.println("listaOutput   -> " + inverterLista(listaInput));
        System.out.println("listaEsperada -> " + listaEsperada);
    }

    private static ListaDuplaGenerica<Integer> inverterLista(ListaDuplaGenerica<Integer> listaInput) {
        ListaDuplaGenerica<Integer> listaInvertida = new ListaDuplaGenerica<Integer>();
        Stack<Integer> numeros = new Stack<Integer>();
        NodoGenerico<Integer> currNodo = listaInput.getFim();

        while (currNodo != null) {
            numeros.push(currNodo.getDado());

            currNodo = currNodo.getEsquerda();
        }
        
        while (numeros.size() > 0) {
            listaInvertida.inserirInicio(numeros.pop());
        }

        return listaInvertida;
    }
}
