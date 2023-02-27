package codelab.aula1;

import lista.simples.Lista;

public class Main {
    public static void main(String[] args) {
        Lista l = new Lista();
        System.out.println(l);

        l.inserirComeco("A");
        l.inserirComeco("B");
        l.inserirComeco("C");
        l.inserirComeco("D");

        l.inserirFim("E");
        l.inserirFim("F");
        l.inserirFim("G");
        l.inserirFim("H");

        System.out.println(l);
        System.out.println("Começo: " + l.primeiroNodo().nomeNodo());
        System.out.println("Final: " + l.ultimoNodo().nomeNodo());
    }
}
