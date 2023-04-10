# Aula 5 - Estruturas de dados e a implementação no java

## Pilha

Acumula dados na ordem inversa que são inseridos e remove o último que foi inserido

```java
// Pilha: 
//                              
//                  B            C
//            A     A     A      A
//  Pilha -> +A -> +B -> pop -> +C
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

## Estruturas de dados no Java

```java
Stack<T> pilha = new Stack<T>;
pilha.add(dado); // -> Adiciona o dado na pilha
pilha.pop();     // -> Retorna e remove o último elemento da pilha
pilha.peek();    // -> Retorna o último elemento da pilha
pilha.isEmpty(); // -> Retorna verdadeiro se estiver vazio
```
