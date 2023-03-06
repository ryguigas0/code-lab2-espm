package codelab.aula3.exemplo2;

public class NodoGenerico<T> {
    T dado;
    NodoGenerico<T> esq, dir;

    public NodoGenerico(T dado) {
        this.dado = dado;
    }

    @Override
    public String toString() {
        return dado.toString();
    }
}
