package codelab.prova2.questao6;

import java.util.Map;

import codelab.aula8.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo grafoPonderado = popularGrafo();

        double menorDistanciaPossivel = Double.MAX_VALUE;

        for (int origem = 1; origem < 7; origem++) {
            Map<Integer, Double> caminhos = grafoPonderado.calcularCaminhoMinimo(origem);

            double somaDistancia = 0.0;
            for (int destino = 1; destino < 7; destino++) {
                somaDistancia += caminhos.get(destino);
            }

            if (somaDistancia < menorDistanciaPossivel) {
                menorDistanciaPossivel = somaDistancia;
            }
        }

        System.out.println(String.format("Menor custo total possível: R$%.2f (%.2fm)", (menorDistanciaPossivel * 5.0),
                menorDistanciaPossivel));
    }

    private static Grafo popularGrafo() {
        Grafo grafoPonderado = new Grafo();

        grafoPonderado.adicionarAresta(1, 2, 1550);
        grafoPonderado.adicionarAresta(1, 3, 850);
        grafoPonderado.adicionarAresta(2, 3, 1000);
        grafoPonderado.adicionarAresta(1, 4, 1420);
        grafoPonderado.adicionarAresta(2, 4, 320);
        grafoPonderado.adicionarAresta(3, 4, 810);
        grafoPonderado.adicionarAresta(1, 5, 1260);
        grafoPonderado.adicionarAresta(2, 5, 340);
        grafoPonderado.adicionarAresta(3, 5, 820);
        grafoPonderado.adicionarAresta(4, 5, 350);
        grafoPonderado.adicionarAresta(1, 6, 560);
        grafoPonderado.adicionarAresta(2, 6, 1250);
        grafoPonderado.adicionarAresta(3, 6, 300);
        grafoPonderado.adicionarAresta(4, 6, 1050);
        grafoPonderado.adicionarAresta(5, 6, 1050);

        return grafoPonderado;
    }
}
