package codelab.aula7.buscaProfundidade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GrafoNDirecionado {
    private int numVertices;

    private List<List<Integer>> listaAdjacencia;

    public GrafoNDirecionado(int numVerticesInicial) {
        if (numVerticesInicial <= 0) {
            throw new RuntimeException("numVerticesInicial menor ou igual a 0 não é permitido");
        }

        this.numVertices = numVerticesInicial;
        this.listaAdjacencia = new ArrayList<>(numVerticesInicial);

        aumentarNumVertices(numVerticesInicial);
    }

    public void aumentarNumVertices(int quantidade) {
        if (quantidade <= 0) {
            throw new RuntimeException("quantidade menor ou igual a 0 não é permitido");
        }

        for (int i = 0; i < quantidade; i++) {
            this.listaAdjacencia.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int verticeInicio, int verticeFim) {
        if (verticeInicio < 0) {
            throw new RuntimeException("Vertice " + verticeInicio + " inalcançável");
        }

        if (verticeFim >= numVertices) {
            throw new RuntimeException("Vertice " + verticeFim + " inalcançável");
        }

        if (verticeInicio == verticeFim) {
            throw new RuntimeException("Arestas de grafos não direcionados não podem apontar para o mesmo Vertice");
        }

        this.listaAdjacencia.get(verticeInicio).add(verticeFim); // A -> B
        this.listaAdjacencia.get(verticeFim).add(verticeInicio); // B -> A
    }

    @Override
    public String toString() {
        String output = "";

        for (int vetorInicio = 0; vetorInicio < listaAdjacencia.size(); vetorInicio++) {
            output += vetorInicio + " -> ";
            output += listaAdjacencia.get(vetorInicio);
            output += "\n";
        }

        return output;
    }

    public void percorrerBuscaProfundidade(int verticeInico) {
        boolean[] verticesVisitados = new boolean[numVertices];
        Stack<Integer> verticesVisitar = new Stack<>();

        verticesVisitar.push(verticeInico);
        verticesVisitados[verticeInico] = true;
        System.out.println("Iniciando a busca pelo vertice: " + verticeInico);

        while (!verticesVisitar.isEmpty()) {
            int indVerticeVisitar = verticesVisitar.pop();

            System.out.println(indVerticeVisitar + " foi visitado!");

            List<Integer> verticesConectados = listaAdjacencia.get(indVerticeVisitar);

            for (int i = 0; i < verticesConectados.size(); i++) {
                if (!verticesVisitados[verticesConectados.get(i)]) {
                    // Adiciona na pilha de visitar se não já foi visitado
                    verticesVisitados[verticesConectados.get(i)] = true;
                    verticesVisitar.add(verticesConectados.get(i));
                }
            }

        }

    }

    public void percorrerBuscaLargura(int verticeInicio) {
        boolean[] verticesVisitados = new boolean[numVertices];
        Queue<Integer> verticesVisitar = new LinkedList<Integer>();

        verticesVisitar.add(verticeInicio);
        System.out.println("Iniciando a busca pelo vertice: " + verticeInicio);

        while (!verticesVisitar.isEmpty()) {
            int indVerticeVisitar = verticesVisitar.remove();
            System.out.println(indVerticeVisitar + " foi visitado!");

            List<Integer> verticesConectados = listaAdjacencia.get(indVerticeVisitar);

            for (int i = 0; i < verticesConectados.size(); i++) {
                if (!verticesVisitados[verticesConectados.get(i)]) {
                    // Adiciona na pilha de visitar se não já foi visitado
                    verticesVisitados[verticesConectados.get(i)] = true;
                    verticesVisitar.add(verticesConectados.get(i));
                }
            }

        }
    }
}
