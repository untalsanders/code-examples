package io.github.sandersgutierrez.rate.impl;

import io.github.sandersgutierrez.rate.api.QuoteManager;
import io.github.sandersgutierrez.rate.spi.ExchangeRateProvider;

public class YahooFinanceExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }
}
