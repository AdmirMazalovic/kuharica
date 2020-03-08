package onlineKuharica;

public enum MjernaJedinica {
    GRAM("g"),
    KILOGRAM("kg"),
    DEKAGRAM("dkg"),
    MILILITAR("ml"),
    DECILITAR("dl"),
    LITAR("l"),
    KOMAD("kom");

    private final String name;

    MjernaJedinica(String mjera) {
        name = mjera;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
