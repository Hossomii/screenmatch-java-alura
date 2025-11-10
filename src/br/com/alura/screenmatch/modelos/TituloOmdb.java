package br.com.alura.screenmatch.modelos;

public record TituloOmdb(String title, String year, String runtime) {
}

// Este record é como um modelo de dados fixo e direto, usado para guardar
// as informações que vêm da API (como título, ano, duração).
// Ele já cria automaticamente os métodos básicos (como construtor e toString)
// sem precisar escrever tudo manualmente.
// Exemplo: se a API retorna {"Title":"Matrix","Year":"1999"},
// o record ajuda a transformar isso em um objeto Java com title = "Matrix" e year = "1999".

