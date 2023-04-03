# Aula 5 - Pilhas e outras estruturas prontas no Java

## Pilha

Acumula dados na ordem inversa que são inseridos e remove o último que foi inserido

```java
// Pilha: 
//                              
//                  B                      C
//            A     A         A            A
//  Pilha -> +A -> +B -> Tira o último -> +C
```

## Estruturas de dados no Java

```java
Stack<T> pilha = new Stack<T>;
pilha.add(dado); // -> Adiciona o dado na pilha
pilha.pop();     // -> Retorna e remove o último elemento da pilha
pilha.peek();    // -> Retorna o último elemento da pilha
pilha.isEmpty(); // -> Retorna verdadeiro se estiver vazio
```
