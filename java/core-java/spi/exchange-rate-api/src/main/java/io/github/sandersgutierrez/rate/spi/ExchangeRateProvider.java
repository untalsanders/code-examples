package io.github.sandersgutierrez.rate.spi;

import io.github.sandersgutierrez.rate.api.QuoteManager;

public interface ExchangeRateProvider {
    QuoteManager create();
}
