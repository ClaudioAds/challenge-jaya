package com.jaya.moneyapi.factory;

import com.jaya.moneyapi.config.handler.InvalidCurrency;
import com.jaya.moneyapi.model.*;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFactory {

    public Currency buildCurrency(String description){
        if (description.equalsIgnoreCase(BRL.class.getSimpleName())){
            return new BRL();
        }

        if (description.equalsIgnoreCase(USD.class.getSimpleName())){
            return new USD();
        }

        if (description.equalsIgnoreCase(EUR.class.getSimpleName())){
            return new EUR();
        }

        if (description.equalsIgnoreCase(JPY.class.getSimpleName())){
            return new JPY();
        }

        throw new InvalidCurrency("Currency '" + description+ "' is not available!");
    }
}
