package org.example.turistguidedel2.model;

public class CurrencyRate {
    private Rate rates;

    static final class Rate {
        private double DKK;
        private double EUR;

        private double dkkToEur() {
            return EUR / DKK;
        }

        public double getDkkToEur() {
            return dkkToEur();
        }
    }

    public double getDkkToEur() {
        return rates.getDkkToEur();
    }
}
