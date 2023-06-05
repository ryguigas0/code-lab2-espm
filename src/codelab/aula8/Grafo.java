package codelab.aula8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
    private List<Aresta> arestas;

    public Grafo() {
        this.arestas = new ArrayList<>();
    }

    public void adicionarAresta(int verticeInicio, int verticeFim, double peso) {
        if (verticeInicio <= 0 || verticeFim <= 0) {
            // Para o algoritimo Dijkstra não importa a identificação dos vertices
            throw new RuntimeException("Vertices não pode ser negativos");
        }

        if (peso < 0) {
            throw new RuntimeException("Pesos não pode ser negativo");
        }

        if (verticeFim == verticeInicio) {
            throw new RuntimeException("O vertice de fim e início devem ser diferentes");
        }

        this.arestas.add(new Aresta(verticeInicio, verticeFim, peso));
        this.arestas.add(new Aresta(verticeFim, verticeInicio, peso));
    }

    public Map<Integer, Double> calcularCaminhoMinimo(int verticeOrigem) {
        HashMap<Integer, Double> distancias = new HashMap<>();
        HashMap<Integer, Integer> caminhosAnteriores = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();

        for (Aresta aresta : arestas) {
            // Colocar todos com valor máximo
            distancias.put(aresta.getOrigem(), Double.MAX_VALUE);
            distancias.put(aresta.getDestino(), Double.MAX_VALUE);

            // Colocar todos como sem conexão de caminho
            caminhosAnteriores.put(aresta.getOrigem(), null);
            caminhosAnteriores.put(aresta.getDestino(), null);
        }

        // Colocar para iniciar com o verticeOrigem
        distancias.put(verticeOrigem, 0.0);

        // Continua buscando o caminho até ter passado por todos os vertices
        while (!visitados.containsAll(distancias.keySet())) {
            int verticeAtual = encontrarVerticeMenorDistancia(distancias, visitados);

            // Adiciona no set de visitados
            visitados.add(verticeAtual);

            for (Aresta aresta : arestas) {
                if (aresta.getOrigem() == verticeAtual) {
                    // calcula a distancia mínima
                    double novaDistanciaMinima = distancias.get(verticeAtual) + aresta.getPeso();

                    // Se a nova distancia minima for menor em relação ao destino da aresta atual
                    if (novaDistanciaMinima < distancias.get(aresta.getDestino())) {
                        // Se sim substiua na distancia com a aresta do menor valor
                        distancias.put(aresta.getDestino(), novaDistanciaMinima);
                        caminhosAnteriores.put(aresta.getDestino(), verticeAtual);
                    }
                }
            }
        }

        return distancias;
    }

    private int encontrarVerticeMenorDistancia(HashMap<Integer, Double> distancias, Set<Integer> visitados) {
        double menorDistancia = Double.MAX_VALUE;
        int verticeMenorDistancia = -1;

        for (Integer vertice : distancias.keySet()) {
            if (!visitados.contains(vertice) && distancias.get(vertice) < menorDistancia) {
                menorDistancia = distancias.get(vertice);
                verticeMenorDistancia = vertice;
            }
        }

        return verticeMenorDistancia;
    }
}
