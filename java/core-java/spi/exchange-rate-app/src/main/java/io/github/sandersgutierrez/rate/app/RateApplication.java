package io.github.sandersgutierrez.rate.app;

import io.github.sandersgutierrez.rate.ExchangeRate;
import io.github.sandersgutierrez.rate.api.Quote;

import java.time.LocalDate;
import java.util.List;

public class RateApplication {
    public static void main(String[] args) {
        ExchangeRate.providers().forEach(provider -> {
            System.out.println("Retrieving USD quotes from provider : " + provider);
            List<Quote> quotes = provider.create().getQuotes("USD", LocalDate.now());
            System.out.printf("%14s%12s|%12s%n", "", "Ask", "Bid");
            System.out.println("----------------------------------------");
            quotes.forEach(quote -> System.out.println("USD --> " + quote.getCurrency()));
        });
    }
}
