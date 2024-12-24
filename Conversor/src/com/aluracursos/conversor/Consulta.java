package com.aluracursos.conversor;

import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.URI;
import com.google.gson.Gson;
import java.net.http.HttpRequest;



public class Consulta {

    private static final String API_KEY = "SU_API";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public Moneda obtenerCambio(String base, String destino) throws IOException, InterruptedException {
        String url = BASE_URL + base + "/" + destino;
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Convertir la respuesta JSON en un objeto Moneda
        return new Gson().fromJson(respuesta.body(), Moneda.class);
    }
}
