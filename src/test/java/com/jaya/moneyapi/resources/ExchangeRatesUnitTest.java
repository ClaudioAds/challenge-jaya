package com.jaya.moneyapi.resources;

import com.jaya.moneyapi.controller.ExchangeCurrencyController;
import com.jaya.moneyapi.dto.request.ExchangeCurrencyDtoRequest;
import com.jaya.moneyapi.dto.response.ExchangeRatesDtoResponse;
import com.jaya.moneyapi.model.ExchangeRecord;
import com.jaya.moneyapi.service.ExchangeRatesService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
class ExchangeRatesUnitTest {

    @Mock
    private ExchangeRatesService exchangeRatesService;
    private ExchangeCurrencyController exchangeRatesResource;

    @BeforeEach
    void setup() {
        exchangeRatesResource = new ExchangeCurrencyController(exchangeRatesService);
    }

    @Test
    @DisplayName("Should return exchange record saved")
    void shouldReturnExchangeRecordSaved() {
        ExchangeRatesDtoResponse build = ExchangeRatesDtoResponse.builder().build();
        ExchangeCurrencyDtoRequest exchangeRatesDtoRequest = new EasyRandom().nextObject(ExchangeCurrencyDtoRequest.class);
        when(exchangeRatesService.exchangeAndSave(any(ExchangeCurrencyDtoRequest.class))).thenReturn(build);
        assertEquals(build, exchangeRatesResource.exchangeCurrency(exchangeRatesDtoRequest).getBody());
    }

    @Test
    @DisplayName("Should return list of exchange records")
    void shoulReturnLExchangeRecordList() {
        List<ExchangeRecord> recordList = Collections.singletonList(ExchangeRecord.builder().build());
        when(exchangeRatesService.findExchangeRecordsByUser(anyLong())).thenReturn(recordList);
        assertEquals(recordList, exchangeRatesResource.findExchangeRecordsByUser(1L).getBody());
    }
}