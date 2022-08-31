## Esse repositório acompanha:

- Pasta com fonte externa
- Pasta com imagens para uso no HTML
- Pasta com o projeto Maven/Java da API que utiliza JPA para banco de dados (com MySQL) e Spring Boot para conexão
- Pasta com prints dos resultados obtidos durante o desenvolvimento
- Pasta com o código HTML da sessão de vendas
- Pasta com o código HTML do testador de Strings

## Tarefa 1: Desenvolver uma API

Foi criada uma aplicação simples que recebe uma requisição HTTP com uma string e encontra o primeiro caractere Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repita na string.

Exemplo:

Input: aAbBABacafe

No exemplo, ‘e’ é o primeiro caractere Vogal da stream que não se repete após a primeira Consoante ‘f’ o qual tem uma vogal ‘a’ como antecessora.

E o resultado do processamento é, por exemplo:
```json
{
  "string": " aAbBABacafe",
  "vogal": "e",
  "tempoTotal": "10ms"
}
```

## Tarefa 2: Criar uma aplicação Web

Foi criada uma aplicação com Spring Boot com métodos Get e Post, para o setor de vendas onde é possível:
- salvar um novo objeto 
- recuperar/consultar um só objeto salvo ou todos os objetos salvos no banco de dados (MySQL). 

Adicionalmente foi desenvolvido um protótipo de página para apresentar os dados salvos no banco de dados.