# Questões
- [x] Implemente um verificador de consequência lógica utilizando os dois teoremas vistos em sala de aula, considerando:
  - [x] Use a tabela verdade
  - [x] Sem o uso da tabela verdade
- [x] Incremente a questão **1** aceitando uma entrada em linguagem natural (português), mapeando para a linguagem da lógica proposicional para verificar se um dado argumento é válido.
- [x] Utilizar:
  * Modus Ponens;
  * Modus Tolens;
  * ...

# Documentação
## Nomeclatura
Os operadores lógicos foram traduzidos para que o tratamento utilizando linguagem de programação seja mais eficiente e, logicamente, mais fácil. A tradução é mostrada na tabela a seguir:

Operador | Símbolo utilizado
-------- | -----------------
E | ^
OU | v
IMPLICAÇÃO | >
NEGAÇÃO | ¬

## Expressões regulares
A utilização de expressões regulares foi fundamental para o processo de desenvovimento deste trabalho. Através dela foi possível identificar os padrões em textos (expressões, nesse contexto) para que tais padrões pudessem ser utilizados em determinadas operações específicas de cada problema proposto.

## Implementação
### Questão 1
**OBS.:** Todas as operações nesta questão foram baseadas na notação posfixa, ou polonesa invertida (vide [Wikipedia](http://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa_inversa)).

#### Entrada
As proposições não devem conter espaços e elas são separadas por *'vírgula espaço'*. Após digitar as proposições basta teclar `Enter` e digitar a consequência lógica. Todas as entradas devem estar em *uppercase*, ou seja, devem estar em letras maiúsculas. A seguir temos um exemplo de entrada:
```
Digite as proposições: 
J>G, ¬J>T, G>C, ¬C
Digite a consequência: 
T
```

#### Letra A
Para a letra A foi criado um array bidimensional do tipo `boolean` que representa a tabela verdade. Os valores iniciais da tabela são setados estaticamente (valores dos átomos [P, Q, etc.]), e então o algorítmo recupera tais valores para resolver as proposições e a consequência com a finalidade de utilizar o teorema 1 e o teorema 2 para testar a consequência lógica.

Tomamos como exemplo a seguinte entrada:
```
Digite as proposições: 
A>B, A
Digite a consequência: 
B
```
Daí temos a seguinte saída:
```
Tabela verdade:
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|
|A	|B	|A>B	|A	|conj.	|B	|teo. 1	|¬(B)	|teo. 2	|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|false	|false	|true	|false	|false	|false	|true	|true	|false	|
|true	|false	|false	|true	|false	|false	|true	|true	|false	|
|false	|true	|true	|false	|false	|true	|true	|false	|false	|
|true	|true	|true	|true	|true	|true	|true	|false	|false	|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
De acordo coma a tabela verdade, pelo teorema 1, é consequência lógica.
De acordo coma a tabela verdade, pelo teorema 2, é consequência lógica.
```

#### Letra B
Para a letra B foi criada uma única expressão para cada teorema, e então é feita uma busca em largura utilizando as equivalências lógicas existentes para gerar os nós filhos com a finalidade de chegar ao resultado final, que é uma tautologia para o teorema 1 e uma contradição para o teorema 2. Cada nó representa uma expressão. Seus filhos são as utilizações das equivalências lógicas aplicadas na expressão pai. A imagem seguinte ilustra como é feita a busca em largura:

![Busca em largura](https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Depth-first-tree.png/300px-Depth-first-tree.png)

A saída mostra qual foi o caminho percorrido até chegar ao nó final, indicando qual equivaliencia foi utilizada. Aproveitando a mesma entrada descrita anteriormente, ao executar essa etapa, temos a seguinte saída:
```
Utilizando equivalências com o teorema 1, é uma consequência lógica.
Caminho até chegar a esta conclusão:
¬((A>B)^A)vB
¬((¬AvB)^A)vB		 [Eliminação da implicação]
¬((¬A^A)v(B^A))vB		 [Distributividade de ^ sobre v]
¬(((¬A^A)vB)^((¬A^A)vA))vB		 [Distributividade de v sobre ^]
¬((fvB)^(fvA))vB		 [Simplificação do ^]
(¬(fvB)v¬(fvA))vB		 [De Morgan]
(¬Bv¬A)vB		 [Simplificação do v]
(¬Av¬B)vB		 [Comutatividade de v]
¬Av(¬BvB)		 [Associatividade de v]
¬Avt		 [Simplificação do v]
t		 [Simplificação do v]

Utilizando equivalências com o teorema 2, é uma consequência lógica.
Caminho até chegar a esta conclusão:
(A>B)^(A^¬B)
(¬AvB)^(A^¬B)		 [Eliminação da implicação]
((A^¬A)v(A^B))^¬B		 [Distributividade de ^ sobre v]
(((A^¬A)vA)^((A^¬A)vB))^¬B		 [Distributividade de v sobre ^]
((fvA)^(fvB))^¬B		 [Simplificação do ^]
(fvA)^((fvB)^¬B)		 [Associatividade de ^]
A^(B^¬B)		 [Simplificação do v]
A^f		 [Simplificação do ^]
f		 [Simplificação do ^]
```

##### Dificuldades
Em alguns casos, a busca em largura é custosa para executar, mas com ela é possível evitar loops que, a grosso modo, não são possíveis de identificar. Anteriormente foi utilizada uma busca em profundidade, mas, em alguns casos, um conjunto de equivalências lógicas eram utilizadas na mesma sequência sempre, ocasionando um loop que não terminava. Por esse motivo foi decidido implementar a busca em largura.

### Questão 2
Nesta questão, a utilização das expressões regulares foi fundamental. Com ela são detectados os seguintes padrões:
```
se ..., então ...
... e ...
... ou ...
... (uma afirmação)
logo, ... (consequência)
```

Com isso é feito o mapeamento de cada afirmação contida nas proposições digitadas para que o programa possa utilizar a linguagem da lógica proposicional. Após realizar o mapeamento, as proposições equivalentes (na liguagem da lógica proposicional) são utilizadas na questão **1** e na questão **3**, e são executados os mesmos procedimentos.

#### Entrada
O usuário digita livremente linha por linha até digitar a consequência ("logo, ..."). Todas as linhas devem estar em *lowercase*, ou seja, com todas as letras minúsculas. A seguir temos um exemplo de entrada, seguido do mapeamento realizado:
```
Digite em português...
se chove, então não faz sol
chove
logo, não faz sol

resultado do mapeamento:
proposições: B>¬A, B
consequência: ¬A
```

#### Dificuldades

### Questão 3
Como na questão 1.B, foi realizada uma busca em profundidade utilizando as regras de inferência para gerar os nós filhos.
