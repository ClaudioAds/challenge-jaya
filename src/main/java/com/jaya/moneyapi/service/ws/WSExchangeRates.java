package com.jaya.moneyapi.service.ws;

import com.jaya.moneyapi.dto.response.ws.WSExchangeRatesDtoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WSExchangeRates {
    private final String baseUrl;
    private final String apiKey;


    public WSExchangeRates(@Value("${ws.url}") String baseUrl, @Value("${ws.access-token}") String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public WSExchangeRatesDtoResponse findExchangeRates(){
        return WebClient.create(baseUrl + "&apikey=" + apiKey)
                .get().retrieve().bodyToMono(WSExchangeRatesDtoResponse.class).block();
    }
}
