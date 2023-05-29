# Aula 7 - Teoria dos grafos

## Grafos

```java
/*
Grafos tem Vertices (ou Nodos) conectados por Arestas

Grafos pode ser representados por G = (V, A), onde V é um conjunto de Vertices e A é um conjunto de Arestas

- Grafo direcionado: só dá pra caminhar em uma direção (uma Aresta pode iniciar e terminar no mesmo vertice)
    0 <-d- 3  
   a|     A
    V     |c
    1 -b->  2
  G = ({0,1,2,3}, {(0, 1), (1, 2), (2, 3), (3, 0)})
  (Grau do Vertice = Quantas Arestas iniciam a conexão com o Vertice)
  grau vertice 3 = 1
- Grafo não direcionado: dá pra ir e voltar entre Vertices (uma Aresta não pode iniciar e terminar no mesmo vertice)
    0 ---d-- 3
    |a        \
    1 -b- 2 -c- 4
G = ({0,1,2,3, 4}, {(0, 1), (1, 2), (2, 4), (4, 3), (3, 0)})
   (Grau do Vertice = Quantas Arestas tem comexão com o Vertice)
   grau vertice 3 = 2
*/
```

## Estrutura de dado

### Matriz de adjacência

```java
// Matriz de Arestas entre Vertices
// Regra da matriz Eij = 1 se existir uma aresta entre os Vertices i e j, 0 se não
/*
G ñ direcionado = ({A, B, C, D, E}, {(A, B), (D, A), (C, B)})
  A B C D E
A 0 1 0 1 0
B 1 0 1 0 0
C 0 1 0 0 0
D 1 0 0 0 0
E 0 0 0 0 0
(abaixo da diagonal principal reflete a parte de cima)
*/

/*
G direcionado = ({A, B, C, D, E}, {(A, B), (B, B), (D, A), (C, B)})
  A B C D E (termina)
A 0 1 0 0 0
B 0 1 0 0 0
C 0 1 0 0 0
D 1 0 0 0 0
E 0 0 0 0 0
(inicia)
*/
```

### Matriz de incidência

```java
// Matriz de Arestas entre Vertices
/*
G ñ direcionado = ({A, B, C, D, E}, {(A, B) -> 1, (D, A) -> 2, (C, B) -> 3})
Regra da matriz Eij = 1 se existir uma aresta entre os Vertices i e j, 0 se não
  1 2 3 (arestas)
A 1 1 0
B 1 0 1
C 0 0 1
D 0 1 0
E 0 0 0
(vertices)
*/

/*
G direcionado = ({A, B, C, D, E}, {(A, B) -> 1, (B, B) -> 2, (D, A) -> 3, (C, B) -> 4})
Regra da matriz Eij = 1 se o Vertice j sai do nó i (j incidente de i), -1 se o Vertice j chega no nó i (j incidente para i), 0 se não houver Aresta
  1  2  3  4 
A -1 0  1  0
B 1  0  0  1
C 0  0  0  -1
D 0  0  -1 0
E 0  0  0  0
(inicia)
*/
```

### Lista de adjacência

```java
// Lista de adjacência
/*
G ñ direcionado = ({A, B, C, D, E}, {(A, B), (D, A), (C, B)})
(Lista nodo início)
A:  B (Lista nodo fim)
|
V
B: 
|
V
C: B
|
V
D: A
|
V
E
  
*/

/*
G direcionado = ({A, B, C, D, E}, {(A, B), (B, B), (D, A), (C, B)})
(Lista nodo início)
A:  B (Lista nodo fim)
|
V
B: B
|
V
C: B
|
V
D: A
|
V
E
*/
```

## Buscando nos grafos

### Busca em profundidade (Depth first search)

```java
/*
G direcionado = ({A, B, C, D, E}, {(A, B), (B, B), (A, D), (C, B), (E, A), (B, E)})
Buscando A
1. Escolher um Vertice aleatório para começar -> C
2. Marcar o visitado -> Cx
3. Adicionar conexões para visitar -> pilha para visitar = [B]
4. Marcar o visitado -> Bx
5. Adicionar conexões para visitar -> pilha para visitar = [E] (não add já visitados)
6. Marcar o visitado -> Ex
7. Adicionar conexões para visitar -> pilha para visitar = [A]
8. Marcar o visitado -> Ax
9. Encontrou A!
*/
```

### Busca em largura (Breadth first search)

```java
/*
G ñ direcionado = ({A, B, C, D, E}, {(A, B), (D, A), (C, B)})
Buscando C
1. Escolher um Vertice aleatório para começar -> A
2. Marcar o visitado -> Ax
3. Adicionar conexões para visitar -> fila para visitar = [B, D]
4. Marcar o visitado -> Bx
5. Adicionar conexões para visitar -> pilha para visitar = [D, C]
6. Marcar o visitado -> Dx
7. Adicionar conexões para visitar -> pilha para visitar = [C]
8. Marcar o visitado -> Cx
9. Encontrou C!
*/
```
