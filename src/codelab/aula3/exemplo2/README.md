# Aula 3

## Parametrizando classes

```java
// NodoGenerico.java
// T -> tipo parametrizado -> pode ser qualquer tipo!
public class NodoGenerico<T> {
    T dado;
    NodoGenerico<T> esq, dir;

    // construtor omitido
    // coloca o dado desse nodo
}

// ListaDuplaGenerica.java
public class ListaDuplaGenerica<T> {
    NodoGenerico<T> inicio, fim;
    int tamanho = 0;

    // inserirInicio omitido

    // inserirFim omitido

    // pesquisar omitido
    // se receber um dado para pesquisar e tiver um nodo com dado igual, retornar o nodo
    // como saber se o dado é igual: override do método equals do tipo do dado

    // deletar omitido
    // se receber um dado para pesquisar e tiver um nodo com dado igual, remover nodo
    // como remove: pegar o nodo da equerda do que vai deletar e conectar com o da direita que vai deletar
}

// Main.java
public class Main {
    public static void main(String args[]) {
        ListaDuplaGenerica<Carro> listaDuplaCarros = new ListaDuplaGenerica<Carro>();
        listaDuplaCarros.inserirInicio(new Carro("ABC", "Audi"));
        listaDuplaCarros.inserirFim(new Carro("DEF", "Volkswagen"));

        listaDuplaCarros.pesquisar(new Carro("ABC", "Audi")); // -> carro encontrado!
        listaDuplaCarros.pesquisar(new Carro("GHI", "Tesla")); // -> null

        listaDuplaCarros.deletar(new Carro("ABC", "Audi")); // deleta o carro!
    }
}

```
