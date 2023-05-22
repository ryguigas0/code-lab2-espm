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

## Balanciando árvores - Árvore AVL

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

## Árvore rubro-negra

### Regras da estrutura

- Os nodos são vermelhos ou pretos
- A raíz é sempre preta
- Nulos contam como nodos pretos
- O pai de um nodo vermelho é sempre preto (não pode ter nodo pai e filho vermelhos)
- Qualquer caminho de um nodo até um nodo nulo tem sempre o mesmo número de nodos pretos

### Regras de inserção

- O nodo inserido é rubro até última instância
- Segue as mesmas regras de inserção da Árvore AVL
- Após cada inserção, verifica se as regras da estrutura se mantém
  - Se o pai do nodo inserido é preto, manter a estrutura
  - Se o pai do nodo inserido é vermelho, rotacionar ou alterar a cor

### Exemplo 1

```java
/*
- Regra da árvore: menor a esquerda, maior a direita
- V -> vermelho
- P -> preto
- Árvore inicial:
      70V
    /
57P
    \
      35V

- Inserir 61 -> Quebra a regra que pai de um nodo vermelho deve ser preto
      70V
    /     \ 
57P         61V
    \
      35V
- Correção: Corrigir as cores do pai, tio e avô de 61 -> Quebra a regra da raíz ser sempre preta
      70P
    /     \ 
57V         61V
    \
      35P
- Correção: Corrigir a cor da raíz -> Árvore balanciada!
            P
          /
      70P       P
    /     \    /
  /        61V
57P           \
  \         P   P
    \     /
      35P
        \
          P
*/
```

### Exemplo 2

```java
/*
- Regra da árvore: menor a esquerda, maior a direita
- V -> vermelho
- P -> preto
- Árvore inicial:
                90V
              /
           80P
          /  \
      70V      73V
    /     \
  /         61P
57P       40P
    \    /
      35V     28V
        \    /
          24P
- Inserir 97 -> 97 quebra a regra de ser vermelho e seu pai ser vermelho
                    97V
                   /
                90V
              /
           80P
          /  \
      70V      73V
    /     \
  /         61P
57P       40P
    \    /
      35V     28V
        \    /
          24P
- Correção: alterar pai, tio e avô de 97 -> 80 quebra a regra de ser vermelho e seu pai é vermelho
                    97V
                   /
                90P
              /
           80V
          /  \
      70V      73P
    /     \
  /         61P
57P       40P
    \    /
      35V     28V
        \    /
          24P
- Correção: alterar pai, tio e avô de 80 -> 57 quebra a regra da raíz ser negra
                    97V
                   /
                90P
              /
           80V
          /  \
      70P      73P
    /     \
  /         61P
57V       40P
    \    /
      35P     28V
        \    /
          24P
- Correção: alterar cor da raíz -> Árvore balanciada!
                    97V
                   /
                90P
              /
           80V
          /  \
      70P      73P
    /     \
  /         61P
57P       40P
    \    /
      35P     28V
        \    /
          24P
*/
```

### Exemplo 3

```java
/*
- Regra da árvore: menor a esquerda, maior a direita
- V -> vermelho
- P -> preto
- Árvore inicial:
      P
    /
57P       P
    \    /
      35V 
        \
          P
- Inserir 24 -> 24 quebra a regra de não poder ser vermelho e ter pai vermelho
      P
    /
57P       P
    \    /
      35V       P
        \     /
          24V
            \
              P
- Correção: alterar a cor do pai, tio e avô -> Avô do novo nodo tem filho na esquerda e o pai do novo nodo tem filho a esquerda
      P
    /
57V       P
    \    /
      35P       P
        \     /
          24V
            \
              P
- Correção: rotacionar: puxar 35 pra cima e colocar 57 para baixo -> Árore balanciada!
         P
        /
    57V
    /   \
  /      P
35P     P
  \   /
  24V
    \
      P
*/  
```

### Exemplo 4

```java
/*
- Regra da árvore: menor a esquerda, maior a direita
- V -> vermelho
- P -> preto
- Árvore inicial:
      P
    /
57P       P
    \    /
      35V 
        \
          P
- Inserir 40 -> 40 quebra a regra de não poder ser vermelho e por ter pai vermelho e tio preto ele deve ser rotacionado duplamente
      P        P
    /         /
57P       40V
    \    /    \
      35V      P
        \
          P
- Correção: alterar a cor do pai, tio e avô -> Avô do novo nodo tem filho na esquerda e o pai do novo nodo tem filho a direita
      P        P
    /         /
57V       40V
    \    /    \
      35P      P
        \
          P
- Correção: rotacionar: subir o 40 e descer o 35 e inverter as cores ->  Avô do novo nodo tem filho na esquerda e o pai do novo nodo tem filho a esquerda
      P
    /
57V
    \
      40P
        \
          35V
- Correção: rotacionar: subir o 40 e descer o 57 -> Árvore balanciada!
    57V
  /
40P
  \
    35V
*/  
```

### Comparação entre AVL e Rubro Negro

- Rubro-negro: melhor para mais inserção/remoção do que leitura, mas a árvore pode tender mais pra um lado que o outro
- AVL: melhor para mais busca do que inserção/remoção, mas a árvore fica o mais simétrica possível

### Implementação do rubro negro no Java

```java
  Map<Integer, String> arvore = new TreeMap<Integer, String>();
  // TreeMap é uma classe que implementa a interface Map

  arvore.put(1, "Anais"); // Insere na árvore

  arvore.get(2); // Busca na árvore

  // Iterar entre as inserções na árvore
  for (Map.Entry<Integer,String> entry : arvore.entrySet()) {
      // Código
  }
```
