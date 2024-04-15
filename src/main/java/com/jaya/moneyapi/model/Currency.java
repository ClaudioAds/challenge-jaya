package com.jaya.moneyapi.model;

import com.jaya.moneyapi.dto.response.ws.WSRatesDtoResponse;

import java.math.BigDecimal;

public interface Currency {

    BigDecimal getEuroExchangeRate(WSRatesDtoResponse wsRatesDtoResponse);

}
