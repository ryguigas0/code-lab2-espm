package codelab.prova2.questao3;

import java.util.ArrayList;
import java.util.List;

import arvore.btree.BTree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> arvore = new BTree<>();

        for (Integer numero : gerarNumeros()) {
            arvore.inserir(numero);
        }

        arvore.remover(arvore.getRaiz().getDado());
        arvore.remover(arvore.getRaiz().getDado());
        arvore.remover(arvore.getRaiz().getDado());

        System.out.println("Pós ordem: " + arvore.toStringPosOrdem());
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
