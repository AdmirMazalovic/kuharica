package onlineKuharica;

public enum TezinaPripreme {
    LAKO("Lako"),
    SREDNJE("Srednje"),
    TESKO("Tesko")
    ;

    private final String tezina;

    TezinaPripreme(String tezinaPripreme){tezina = tezinaPripreme;}

    @Override
    public String toString() {
        return this.tezina;
    }

    public String getTezinaPripeme() {
        return tezina;
    }
}
