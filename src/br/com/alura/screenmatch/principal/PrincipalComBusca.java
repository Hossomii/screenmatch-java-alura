package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("O que deseja assistir? ");
        var busca = input.nextLine();

        // Monta a URL da requisição para a API do OMDb com o título buscado.
        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=d82e38ab";

        // Cria um cliente HTTP para enviar a requisição.
        HttpClient client = HttpClient.newHttpClient();

        // Cria a requisição HTTP com a URL da API.
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        // Envia a requisição e armazena a resposta como texto (JSON).
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);

        // Usa Gson para adaptar os nomes dos campos do JSON da API (em UpperCamelCase)
        // aos atributos da classe Java.
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        // Converte o JSON da resposta em um objeto Java usando a classe TituloOmdb.
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        System.out.println("Título já convertido: ");
        System.out.println(meuTitulo);
    }
}

