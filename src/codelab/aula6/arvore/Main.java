package codelab.aula6.arvore;

import arvore.BTree;

public class Main {
    public static void main(String[] args) {
        BTree<Integer> arvore = new BTree<Integer>();

        arvore.inserir(50);
        arvore.inserir(24);
        arvore.inserir(60);
        arvore.inserir(19);
        arvore.inserir(39);
        arvore.inserir(59);
        arvore.inserir(63);

        System.out.println("Pré ordem: " + arvore.toStringPreOrdem());
        System.out.println("Em ordem: " + arvore.toStringEmOrdem());
        System.out.println("Pós ordem: " + arvore.toStringPosOrdem());

        System.out.println("Tem 19? " + arvore.presente(19));
        System.out.println("Tem 22? " + arvore.presente(22));
    }
}