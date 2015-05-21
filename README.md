# 1ª lista de exercícios

## Questões
- [x] Implemente um verificador de consequência lógica utilizando os dois teoremas vistos em sala de aula, considerando:
  - [x] Use a tabela verdade
  - [x] Sem o uso da tabela verdade
- [ ] Incremente a questão **1** aceitando uma entrada em linguagem natural (português), mapeando para a linguagem da lógica proposicional para verificar se um dado argumento é válido.
- [x] Utilizar:
  * Modus Ponens;
  * Modus Tolens;
  * ...

## Documentação
### Questão 1
**OBS.:** Todas as operações foram baseadas na notação posfixa, ou polonesa invertida (vide [Wikipedia](http://pt.wikipedia.org/wiki/Nota%C3%A7%C3%A3o_polonesa_inversa)).

#### Letra A
Para a letra A foi criado um array bidimensional do tipo `boolean` que representa a tabela verdade. Os valores iniciais da tabela são setados estaticamente (valores dos átomos [P, Q, etc.]), e então o algorítmo recupera tais valores para resolver as proposições e a consequência com a finalidade de utilizar o teorema 1 e o teorema 2 para testar a consequência lógica.

#### Letra B
Para a letra B foi criada uma única expressão para cada teorema, e então é feita uma busca em profundidade utilizando as equivalências lógicas existentes para gerar os nós filhos com a finalidade de chegar ao resultado final, que é uma tautologia para o teorema 1 e uma contradição para o teorema 2.

### Questão 2

### Questão 3
Como na questão 1.B, foi realizada uma busca em profundidade utilizando as regras de inferência para gerar os nós filhos.
