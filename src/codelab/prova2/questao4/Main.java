package codelab.prova2.questao4;

import java.util.ArrayList;
import java.util.List;

import arvore.avl.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> arvore = new AVLTree<Integer>();

        for (Integer numero : gerarNumeros()) {
            arvore.inserir(numero);
        }

        arvore.remover(arvore.getRaiz().getDado());
        arvore.remover(arvore.getRaiz().getDado());
        arvore.remover(arvore.getRaiz().getDado());

        System.out.println("Pré ordem: " + arvore.toStringPreOrdem());
    }

    private static List<Integer> gerarNumeros() {
        List<Integer> output = new ArrayList<Integer>();

        int meuRA = 203491;

        String input = "761" + (meuRA) + "385";

        for (String digitoString : input.split("")) {
            output.add(Integer.parseInt(digitoString));
        }

        return output;
    }

}