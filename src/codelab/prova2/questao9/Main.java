package codelab.prova2.questao9;

import arvore.btree.BTree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> arvore = new BTree<>();

        int[] numeros = {42, 57, 48, 16, 35, 8, 5, 11};

        for (int i : numeros) {
            arvore.inserir(i);  
        }

        System.out.println("Quantidade de folhas: " + arvore.contarFolhas());
    }
}
