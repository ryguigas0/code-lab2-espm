package codelab.aula8;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        g.adicionarAresta(1, 2, 6);
        g.adicionarAresta(1, 3, 2);
        g.adicionarAresta(2, 3, 1);
        g.adicionarAresta(3, 4, 2);
        g.adicionarAresta(3, 6, 3);
        g.adicionarAresta(6, 4, 2);
        g.adicionarAresta(6, 5, 4);
        g.adicionarAresta(4, 5, 2);
        g.adicionarAresta(2, 4, 4);

        int origem = 3;
        Map<Integer, Double> caminhoMinimo = g.calcularCaminhoMinimo(origem);

        for (int vertice : caminhoMinimo.keySet()) {
            double distancia = caminhoMinimo.get(vertice);
            System.out.println(origem + " até " + vertice  + " -> " + distancia);
        }
    }
}
