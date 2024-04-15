package com.jaya.moneyapi.factory;

import com.jaya.moneyapi.config.handler.InvalidCurrency;
import com.jaya.moneyapi.model.*;
import org.springframework.stereotype.Component;

@Component
public class CurrencyFactory {

    public Currency buildCurrency(String description){
        if (description.equalsIgnoreCase(CurrencyBRL.class.getSimpleName())){
            return new CurrencyBRL();
        }

        if (description.equalsIgnoreCase(CurrencyUSD.class.getSimpleName())){
            return new CurrencyUSD();
        }

        if (description.equalsIgnoreCase(CurrencyEUR.class.getSimpleName())){
            return new CurrencyEUR();
        }

        if (description.equalsIgnoreCase(CurrencyJPY.class.getSimpleName())){
            return new CurrencyJPY();
        }

        throw new InvalidCurrency("Currency '" + description+ "' is not available!");
    }
}
