package io.github.sandersgutierrez.rate;

import io.github.sandersgutierrez.rate.exception.ProviderNotFoundException;
import io.github.sandersgutierrez.rate.spi.ExchangeRateProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ExchangeRate {
    public static final String DEFAULT_PROVIDER = "io.github.sandersgutierrez.rate.spi.YahooFinanceExchangeRateProvider";

    public static List<ExchangeRateProvider> providers() {
        List<ExchangeRateProvider> services = new ArrayList<>();
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        loader.forEach(exchangeRateProvider -> services.add(exchangeRateProvider));
        return services;
    }

    public static ExchangeRateProvider provider() {
        return provider(DEFAULT_PROVIDER);
    }

    public static ExchangeRateProvider provider(String providerName) {
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        for (ExchangeRateProvider provider : loader) {
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException("Exchange Rate Provider " + providerName + " not found");
    }
}
