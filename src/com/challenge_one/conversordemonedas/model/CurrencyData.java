package com.challenge_one.conversordemonedas.model;

public record CurrencyData(
        float usd,
        float ars,
        float brl,
        float cop
) {
    @Override
    public String toString() {
        return "USD: " + usd + "\nPesos argentinos: "
                + ars + "\nReal brasileño: "+ brl
                + "\nPeso colombiano: " + cop  ;
    }
}
