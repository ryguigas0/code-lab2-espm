# Aula 8 - Algoritimo de Dijkstra

Nem sempre o menor caminho é o mais próximo, podemos considerar também os pesos de cada aresta (combustível consumido, distância, dificuldade, ...)

## Algoritimo

```java
/*
Usa um grafo ponderado (G), sem pesos n,egativos, e o algoritimo procura a caminho com a menor soma de pesos

O algoritimo começa pelo vertice de início e passa pelos outros vertices, registrando a menor distância conhecida e atualiza esse valores até achar o menor valor possível. 
Depois de encontrar o menor caminho do vertice visitado e a origem, ele é marcado como visitado e adicionado no caminho. 
Quando o caminho conter todos os vertices temos um grafo com o menor caminho para conectar a vertice origem com o vertice

Exemplo: Qual o menor caminho entre 0 e 5?
Grafo de 6 vertices
Lista de conexões
0 -> {id: 1, peso: 2}, {id: 2, peso: 6}
1 -> {id: 0, peso: 2}, {id: 2, peso: 1}, {id: 4, peso: 2}, {id: 3, peso: 3}
2 -> {id: 0, peso: 6}, {id: 1, peso: 1}, {id: 4, peso: 4}
3 -> {id: 1, peso: 3}, {id: 4, peso: 4}, {id: 5, peso: 4}
4 -> {id: 2, peso: 4}, {id: 1, peso: 2}, {id: 3, peso: 2}, {id: 5, peso: 2}
5 -> {id: 3, peso: 4}, {id: 4, peso: 2}

Examinando a partir do vertice 0 -> Do vertice 0, tem o vertice 1 com peso 2 e o vertice 2 com peso 6
Vertice   = [0f, 1f, 2, 3, 4, 5] (f -> fixo)
Distancia = [-f, 2f, 6, x, x, x] (x -> ainda não é conhecido)
Anterior  = [-f, 0f, 0, x, x, x]
Passando pelo vertice 1 é o menor caminho!
Menor distância = 2

Examinando a partir do vertice 1 -> Do vertice 1, o vertice 2 com peso 1, o vertice 4 com peso 2 e o vertice 3 com peso 3, pulando os já visitados
Menor distância = 2
Vertice   = [0f, 1, 2         , 3    , 4    , 5] (fixa o menor caminho)
Distancia = [-f, 2, 6 ou 1+2=3, 3+2=5, 2+2=4, x] (Tem que somar a distância mínima com a distância do vertice)
Anterior  = [-f, 0, 0 ou 1    , 1    , 1    , x]
Passando pelo vertice 2 é o menor caminho!
Menor distância =  3

Examinando a partir do vertice 2 -> Do vertice 2, e vertice 4 com peso 4, pulando os já visitados
Menor distancia = 3
Vertice   = [0f, 1f, 2f, 3, 4         , 5]
Distancia = [-f, 2f, 3f, 5, 4 ou 4+3=7, x] (Tem que guardar os anteriores porque talvez eles sejam menores)
Anterior  = [-f, 0f, 1f, 1, 1 ou 2    , x]
Passando pelo vertice 4 a partir do 1 é o menor caminho!
Menor distância = 4

Examinando a partir do vertice 4 -> Do vertice 4, vertice 3 com peso 2 e vertice 5 com peso 2, tirando os já visitados
Menor distancia = 4
Vertice   = [0f, 1f, 2f, 3         , 4f, 5    ]
Distancia = [-f, 2f, 3f, 5 ou 2+4=6, 4f, 2+4=6]
Anterior  = [-f, 0f, 1f, 1 ou 4    , 1f, 4    ]
Passando pelo vertice 3 a partir do 1 é o menor caminho!
Menor distancia = 5

Examinando a partir do vertice 3 -> Do vertice 3 tem o vertice 5 com peso 4, tirando os já visitados
Menor distancia = 5
Vertice   = [0f, 1f, 2f, 3f, 4f, 5         ]
Distancia = [-f, 2f, 3f, 5f, 4f, 6 ou 5+4=9]
Anterior  = [-f, 0f, 1f, 1f, 1f, 4 ou 3    ]
Passado pelo vertice 5 a partir do vertice 4 é o menor caminho!
Menor distancia = 6

Examinando a partir do vertice 5 -> Chegou no final!
Distâncias a partir do nodo 0
Menor distancia = 6
Vertice   = [0f, 1f, 2f, 3f, 4f, 5f]
Distancia = [-f, 2f, 3f, 5f, 4f, 6f]
Anterior  = [-f, 0f, 1f, 1f, 1f, 4f] 

Caminho: (B <- A) 5 <- 4 <- 1 <- 0
Custo total: 6

*/
```
