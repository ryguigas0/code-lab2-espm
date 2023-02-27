package codelab.aula2.exemplo2;

public class Nodo {
    int ra;
    String nome;
    Nodo esq, dir;

    public Nodo(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "{ \"RA\": " + ra + ", \"NOME\": \"" + nome + "\" }";
    }
}
