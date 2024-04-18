package com.jaya.moneyapi.model;

import com.jaya.moneyapi.dto.response.ws.WSRatesDtoResponse;

import java.math.BigDecimal;

public class EUR implements Currency{

    @Override
    public BigDecimal getEuroExchangeRate(WSRatesDtoResponse wsRatesDtoResponse) {
        return BigDecimal.valueOf(wsRatesDtoResponse.getEUR());
    }
}
