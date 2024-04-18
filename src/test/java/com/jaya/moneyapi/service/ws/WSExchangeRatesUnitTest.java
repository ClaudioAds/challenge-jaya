package com.jaya.moneyapi.service.ws;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaya.moneyapi.dto.response.ws.WSExchangeRatesDtoResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Date;


@ExtendWith(MockitoExtension.class)
class WSExchangeRatesUnitTest {

    private MockWebServer mockWebServer;
    private WSExchangeRates wsExchangeRates;

    @BeforeEach
    void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        wsExchangeRates = new WSExchangeRates(String.format("https://api.apilayer.com/exchangerates_data/latest?base=EUR",  mockWebServer.getPort()), "04DwFO4mayyX8AoRHU0BolReHhbruQbX");
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    @DisplayName("Should receive WS response")
    void shouldReceiveWSResponse() throws JsonProcessingException {
        WSExchangeRatesDtoResponse wsExchangeRatesDtoResponse = new WSExchangeRatesDtoResponse();
        wsExchangeRatesDtoResponse.setDate(wsExchangeRates.findExchangeRates().getDate());
        wsExchangeRatesDtoResponse.setSuccess(wsExchangeRates.findExchangeRates().isSuccess());
        wsExchangeRatesDtoResponse.setRates(wsExchangeRates.findExchangeRates().getRates());
        wsExchangeRatesDtoResponse.setTimestamp(wsExchangeRates.findExchangeRates().getTimestamp());
        wsExchangeRatesDtoResponse.setBase(wsExchangeRates.findExchangeRates().getBase());
        mockWebServer.enqueue(new MockResponse().setBody(new ObjectMapper().writeValueAsString(wsExchangeRatesDtoResponse)).addHeader("Content-Type", "application/json"));
        assertEquals(wsExchangeRatesDtoResponse, wsExchangeRates.findExchangeRates());

    }
}