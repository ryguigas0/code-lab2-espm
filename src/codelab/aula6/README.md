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
