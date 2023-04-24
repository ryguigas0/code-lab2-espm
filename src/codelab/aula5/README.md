# Aula 5 - Estruturas lineares de dados e a implementação no java

## Pilha

Acumula dados na ordem inversa que são inseridos e remove o último que foi inserido

```java
// Pilha: 
//                              
//                  B            C
//            A     A     A      A
//  Pilha -> +A -> +B -> pop -> +C
```

### Implementação

```java
Stack<T> pilha = new Stack<T>;
pilha.add(dado); // -> Adiciona o dado na pilha
pilha.pop();     // -> Retorna e remove o último elemento da pilha
pilha.peek();    // -> Retorna o último elemento da pilha
pilha.isEmpty(); // -> Retorna verdadeiro se estiver vazio
pilha.toArray(new T[] {}); // -> Retorna um vetor na ordem dos elementos do topo para baixo
```

## Fila

Acumula dados na ordem que são inseridos e remove o primeiro que foi inserido

```java
// Fila
//
//
//                A            B
//          A     B     B      C
// Fila -> +A -> +B -> pop -> +C 
```

### Implementação

```java
Queue<T> fila = new LinkedList<T>(); // Instancia um objeto com os métodos da interface Queue
fila.add(dado); // Adiciona o elemento na fila
T poped = fila.remove(); // Remove o elemento mais velho na lista e retorna ele
T top = fila.element(); // Retorna o elemento mais velho na lista
fila.size(); // Retorna o tamanho da fila
fila.toArray(new T[] {}); // Retorna um vetor na ordem dos elementos do início até o fim
```
