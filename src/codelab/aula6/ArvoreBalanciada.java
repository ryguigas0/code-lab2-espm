package codelab.aula6;

import arvore.avl.AVLTree;

public class ArvoreBalanciada {
    public static void main(String[] args) {
        AVLTree<Integer> arvore = new AVLTree<Integer>();

        arvore.inserir(30);
        arvore.inserir(40);
        arvore.inserir(58);
        arvore.inserir(48);
        arvore.inserir(24);
        arvore.inserir(11);
        arvore.inserir(13);
        arvore.inserir(26);

        System.out.println("Pré ordem: " + arvore.toStringPreOrdem());
        System.out.println("Em ordem: " + arvore.toStringEmOrdem());
        System.out.println("Pós ordem: " + arvore.toStringPosOrdem());

        // arvore.remover(30);
        // arvore.remover(40);

        // System.out.println("Pré ordem: " + arvore.toStringPreOrdem());
        // System.out.println("Em ordem: " + arvore.toStringEmOrdem());
        // System.out.println("Pós ordem: " + arvore.toStringPosOrdem());
    }
}