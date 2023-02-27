# Aula 2 - Construtores e listas duplas

## Construtores

```java
// cubo.java
public class Cubo {

    double altura;
    double largura;
    double profundidade;

    // Método contrutor -> Na hora que cria no objeto já colocar os dados nele
    public Cubo(double altura, double largura, double profundidade) {
        this.altura = altura; // this -> força a variável ser a do objeto
        this.largura = largura;
        this.profundidade = profundidade;
    }

    @Override
    public String toString(){
        //...
    }
}

//main.java
public class Main {
    public static void main(String args[]){
        // Método construtor Cubo() foi chamado
        Cubo a = new Cubo(22.5, 23.2, 21.3);

        System.out.println(a); // -> {"altura": 22.5, "largura": 23.2, "profundidade": 21.3}
    }
}
```

## Listas duplas

```java
// Nodo.java
public class Nodo {
    int valor;
    Nodo esq, dir; // Sabe o endr de memória de quem está atrás e na frente dele

    // construtor 

    // override toString
}

// ListaDupla.java
public class ListaDupla {
    Nodo inicio, fim;
    int tamanho = 0;

    // inserir inicio
    // Se não tiver nodos, coloca no fim e no inicio o novo nodo
    // Se tiver nodos
    //  colocar o novo na esquerda do início
    //  colocar o início na direita do novo
    //  subistiuir o início com o novo
    // Incrementar o tamanho

    // inserir fim
    // Se não tiver nodos, coloca no fim e no inicio o novo nodo
    // Se tiver nodos
    //  colocar o novo na direita do fim
    //  colocar o fim na esquerda do novo
    //  subistiuir o fim com o novo
    // Incrementar o tamanho

    // buscar nodo
    // Curr começar a partir do início/fim da lista
    // Enquanto curr não for null
    //  Se curr for o buscado, retornar ele
    //  Se curr não for o buscado, ir para a direita/esquerda da lista e repetir busca
    // Retornar curr

    // override toString
}
```
