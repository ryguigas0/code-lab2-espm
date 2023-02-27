package codelab.aula2.exemplo2;

public class ListaDupla {
    private Nodo inicio, fim;
    private int tamanho = 0;

    public void inserirInicio(int ra, String nomeAluno) {
        Nodo novoNodo = new Nodo(ra, nomeAluno);

        if (tamanho == 0) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            inicio.esq = novoNodo;
            novoNodo.dir = inicio;
            inicio = novoNodo;
        }

        tamanho++;
    }

    public void inserirFim(int ra, String nomeAluno) {
        Nodo novoNodo = new Nodo(ra, nomeAluno);

        if (tamanho == 0) {
            inicio = novoNodo;
            fim = novoNodo;
        } else {
            novoNodo.esq = fim;
            fim.dir = novoNodo;
            fim = novoNodo;
        }

        tamanho++;
    }

    public Nodo buscarRA(int ra) {
        Nodo curr = inicio;

        while (curr != null) {
            if (curr.ra == ra) {
                return curr;
            }
            curr = curr.dir;
        }

        return null;
    }

    @Override
    public String toString() {
        if (inicio == null) {
            return "Lista vazia!";
        }

        String output = "";
        Nodo curr = inicio;

        while (curr != null) {
            output += String.format("\t%s,\n", curr);
            curr = curr.dir;
        }

        return String.format("{\n\"INICIO\": %s,\n\"FIM\": %s,\n\"ELEMENTOS\": [\n%s]}", inicio, fim, output);
    }
}
