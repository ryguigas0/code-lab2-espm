package codelab.aula7.buscaProfundidade;

public class Main {

    public static void main(String[] args) {
        GrafoNDirecionado g = new GrafoNDirecionado(11);

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(2, 3);
        g.adicionarAresta(2, 4);
        g.adicionarAresta(3, 6);
        g.adicionarAresta(3, 5);
        g.adicionarAresta(4, 5);

        System.out.println(g);

        System.out.println("Busca por profundidade");
        g.percorrerBuscaProfundidade(4);

        System.out.println("Busca por largura");
        g.percorrerBuscaLargura(4);

    }
}
