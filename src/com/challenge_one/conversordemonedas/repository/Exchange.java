package com.challenge_one.conversordemonedas.repository;

import com.challenge_one.conversordemonedas.model.CurrencyData;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Exchange {

    private final FieldNamingStrategy customPolicy = field -> field.getName().toUpperCase();

    public void setResult(String result) {
        this.result = result;
    }

    private  String result ="";

    private String connectExchange(String currency){
        String APIKEY = "b90d1acc6150bfff7d4288dd";

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+ APIKEY + "/latest/"+currency);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion).timeout(Duration.ofSeconds(5))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private CurrencyData convertJsonToModel(String jsonData){
        var jsonObject = new GsonBuilder().create()
                .fromJson(jsonData, JsonObject.class);
        return new GsonBuilder().setFieldNamingStrategy(customPolicy)
                .create() .fromJson(jsonObject.get("conversion_rates"), CurrencyData.class);

    }

    public String convertCurrency(float ammount,String fromCurrency,String toCurrency){
        var data = connectExchange(fromCurrency);
        var modelData = convertJsonToModel(data);
        float equivalentAmmount = switch (toCurrency) {
            case "USD" -> modelData.usd();
            case "ARS" -> modelData.ars();
            case "BRL" -> modelData.brl();
            case "COP" -> modelData.cop();
            default -> 0.0F;
        };

        float results = equivalentAmmount * ammount;

        return result.formatted(ammount,results);
    }
}
