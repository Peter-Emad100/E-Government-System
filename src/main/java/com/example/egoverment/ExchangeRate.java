package com.example.egoverment;
import java.net.http.*;
import java.net.URI;
import java.util.concurrent.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
public class ExchangeRate {
    private static final String API_URL ="https://v6.exchangerate-api.com/v6/1e76e5bc0750f12609666e7e/latest/EGP";
    public static JsonObject FetchRates()throws Exception
    {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(API_URL)).GET().build();
        HttpResponse<String> response = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return JsonParser.parseString(response.body()).getAsJsonObject();
    }
    public static String Formater(JsonObject jsOb) {
        try {
            // Navigate to the "conversion_rates" object
            JsonObject rates = jsOb.getAsJsonObject("conversion_rates");

            // Retrieve values or provide a fallback
            String usd = rates.has("USD") ? String.format("%.2f", 1 / rates.get("USD").getAsDouble()) : "N/A";
            String eur = rates.has("EUR") ? String.format("%.2f", 1 / rates.get("EUR").getAsDouble()) : "N/A";
            String jpy = rates.has("JPY") ? String.format("%.2f", 1 / rates.get("JPY").getAsDouble()) : "N/A";
            String gbp = rates.has("GBP") ? String.format("%.2f", 1 / rates.get("GBP").getAsDouble()) : "N/A";
            String cny = rates.has("CNY") ? String.format("%.2f", 1 / rates.get("CNY").getAsDouble()) : "N/A";
            String aud = rates.has("AUD") ? String.format("%.2f", 1 / rates.get("AUD").getAsDouble()) : "N/A";
            String chf = rates.has("CHF") ? String.format("%.2f", 1 / rates.get("CHF").getAsDouble()) : "N/A";
            String hkd = rates.has("HKD") ? String.format("%.2f", 1 / rates.get("HKD").getAsDouble()) : "N/A";
            String sgd = rates.has("SGD") ? String.format("%.2f", 1 / rates.get("SGD").getAsDouble()) : "N/A";

            // Get the last update time
            String time = jsOb.has("time_last_update_utc") ? jsOb.get("time_last_update_utc").getAsString() : "Unknown";

            // Correctly format the output string
            String st = String.format("Last updated: %s\nUSD = %s EGP\nEUR = %s EGP\nJPY = %s EGP\n" +
                            "GBP = %s EGP\nCNY = %s EGP\nAUD = %s EGP\nCHF = %s EGP\n" +
                            "HKD = %s EGP\nSGD = %s EGP",
                    time, usd, eur, jpy, gbp, cny, aud, chf, hkd, sgd);

            return st;

        } catch (Exception e) {
            // Handle unexpected exceptions
            return "An error occurred while formatting the data: " + e.getMessage();
        }
    }

}
