package io.github.sandersgutierrez.rate.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Quote {
    private String currency;
    private BigDecimal ask;
    private BigDecimal bid;
    private LocalDate date;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        return Objects.equals(currency, quote.currency) && Objects.equals(date, quote.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, date);
    }

    @Override
    public String toString() {
        return "Quote{" +
            "currency='" + currency + '\'' +
            ", date=" + date +
            '}';
    }
}
