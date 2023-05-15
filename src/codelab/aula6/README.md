# Aula 6 - Árvores

## Estrutura de dado

```java
/*
- Regra da árvore: número menor que a raíz vai pra esquerda, se não para direita, 
se não tiver espaço olhe quem está conectado ao nodo escolhido
null

- inserir 50
50

- inserir 60 -> 60 vem depois de 50
    60
  /
50

- inserir 52 -> 52 vem depois de 50, mas antes de 60
    60
  /    \
50      52

- inserir 63 -> 63 vem depois de 50 e depois de 60
        63
       /
    60
  /    \
50      52

- inserir 52 -> 52 vem depois de 50, mas antes de 60. Apesar disso o número 
já está na árvore, então não vai ser inserido
        63
       /
    60
  /    \
50      52

*/
```

## Formas de buscar na árvore

```java
/*
- Só vai pro próximo passo da busca recursiva se bater em um null
Árvore exemplo: 
        63
      /
    60
   /  \
  /     59
50
  \     39
    \  / 
     24
       \
         19

- Buscar 99
Busca pré ordem: (Raiz, Esquerda, Direita) -> 50, 24, 19, 39, 60, 59, 63
Busca em ordem:  (Esquerda, Raiz, Direita) -> 19, 24, 39, 50, 59, 60, 63
Busca pós ordem: (Esquerda, Direita, Raiz) -> 19, 39, 24, 59, 63, 60, 50

*/
```

## Removendo elementos da árvore

```java
/*
- Só vai pro próximo passo da busca recursiva se bater em um null
Árvore exemplo: 
        63
      /
    60
   /  \
  /     59
50
  \     39
    \  / 
     24
       \
         19

- Remover 39
1. compare(39, 50) -> -1 -> lado esquerdo de 50
2. compare(39, 24) -> +1 -> lado direito de 24
3. compare(39, 39) -> 0 -> alvo encontrado!

- Depois de encontrar o alvo:
1. Se tiver 0 filhos -> Remover nodo e a conexão com o pai
2. Se tiver 1 filho -> Remover nodo e conectar o pai do removido com o filho do removido
3. Se tiver 2 filhos -> 
  - Se na esquerda da raíz, encontrar o maior entre os valores, remover nodo, conectar o pai do removido com o encontrado
  - Se na direita da raíz, encontrar o menor entre os valores, remover nodo, conectar o pai do removido com o encontrado

        63
      /
    60
   /  \
  /     59
50
  \
    \
     24
       \
         19


*/
```

## Balanciando árvores

```java
/*
- Inserir até desbalancear
- A diferença entre o tamanho da árvore da esquerda e direita é maior que 1, então precisa rotacionar
  - Rotação simples:
    No 7 a árvore está desbalanciada! (tamanho da esquerda é 0 e na direita é 2)
    7
      \
      10
        \
         11
    Rebalanciado:
       10
      /  \
     7    11
  - Rotação dupla:
    No 5 a árvore está desbalanceada! (tamanho da esquerda é 1 e na direita é 2)
        5
      /   \
    4      10
          /   \
        7      11
      /
    6
    Rebalanciada
            7
          /   \
        5      10
      /       /  \
    4        6    11

*/
```
