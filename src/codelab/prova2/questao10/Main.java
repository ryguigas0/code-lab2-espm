package codelab.prova2.questao10;

import java.util.ArrayList;
import java.util.List;

import arvore.btree.BTree;

public class Main {
    public static void main(String[] args) {
        int[] numeros = {42, 57, 48, 16, 35, 8, 5, 11};
        BTree<Integer> arvoreA = new BTree<>();
        BTree<Integer> arvoreB = new BTree<>();
        BTree<Integer> arvoreC = new BTree<>();

        for (int i : numeros) {
            arvoreA.inserir(i);  
            arvoreB.inserir(i);  
        }

        for (int i : gerarNumeros()) {
            arvoreC.inserir(i);
        }

        System.out.println("A == B " + arvoreA.verificar(arvoreB));
        System.out.println("A != C " + arvoreA.verificar(arvoreC));
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
