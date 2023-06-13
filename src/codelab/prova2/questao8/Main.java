package codelab.prova2.questao8;

import codelab.aula7.buscaProfundidade.GrafoNDirecionado;

public class Main {
    public static void main(String[] args) {
        GrafoNDirecionado grafo = new GrafoNDirecionado(6);

        grafo.adicionarAresta(1 - 1, 2 - 1);
        grafo.adicionarAresta(1 - 1, 3 - 1);
        grafo.adicionarAresta(1 - 1, 4 - 1);
        grafo.adicionarAresta(1 - 1, 5 - 1);
        grafo.adicionarAresta(1 - 1, 6 - 1);
        grafo.adicionarAresta(2 - 1, 3 - 1);
        grafo.adicionarAresta(2 - 1, 4 - 1);
        grafo.adicionarAresta(3 - 1, 5 - 1);
        grafo.adicionarAresta(4 - 1, 5 - 1);
        grafo.adicionarAresta(4 - 1, 6 - 1);
        grafo.adicionarAresta(5 - 1, 6 - 1);

        grafo.percorrerBuscaLargura(1 - 1);

    }
}
