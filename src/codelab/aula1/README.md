# Aula 1 - Lista linear simplesmente encadeada

## O que é uma lista linear simplesmente encadeada?
```java
int[] vetor = new int[10]; // Tamanho fixo -> E se eu precisar de mais que 10 elementos?
vetor[2] = 22; // Recuperação por indice rápida

Lista l = new Lista(); // Lista linear simplesmente encadeada -> Tamanho dinâmico

l.inserirInicio(22); // O novo nodo tem como próximo o velho primeiro nodo

// Lista de nodos atual
// Nodo@11 [valor: 25, próximoNodo: Nodo@33] -> Início da lista
// ...
// Nodo@NN [valor: 172, próximoNodo: null] -> Final da lista

// Inserção do nodo @22 no começo
// Nodo@22 [valor: 22, próximoNodo: null]
// Nodo@22.proximo = Nodo@11 -> Agora o nodo @22 é o primeiro, o próximo é o @11, depois o @33, ..., depois @NN

// Nova lista de nodos
// Nodo@22 [valor: 22, próximoNodo: Nodo@11] -> Início da lista
// Nodo@11 [valor: 25, próximoNodo: Nodo@33]
// ...
// Nodo@NN [valor: 172, próximoNodo: null] -> Final da lista

l.inserirFim(96); // O velho nodo de fim tem como próximo o novo nodo de fim

// Inserção do nodo @96 no fim
// Nodo@96 [valor: 96, próximoNodo: null]
// Nodo@NN.próximoNodo = Nodo@96 -> Agora o nodo @96 é o último, antes dele é o @NN, ..., e no começo o @22

// Nova lista de nodos
// Nodo@22 [valor: 22, próximoNodo: Nodo@11] -> Início da lista
// Nodo@11 [valor: 25, próximoNodo: Nodo@33]
// ...
// Nodo@NN [valor: 172, próximoNodo: Nodo@96]
// Nodo@96 [valor: 96, próximoNodo: null] -> Final da lista

// Implementação em https://github.com/ryguigas0/lista-lib
```

## Importando bibliotecas
1. Clone e siga as intruções da [lista-lib](https://github.com/ryguigas0/lista-lib)
2. `CTRL + Shift + P`
3. Selecione `Java: Configure Classpath`
4. Adicione nas `Referenced Libraries` a localização do arquivo `lista-lib.jar`
5. Use `import teste.Lista` para importar a classe `Lista`