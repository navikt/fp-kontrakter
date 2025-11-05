package no.nav.foreldrepenger.kontrakter.fpoversikt;


public record Arbeidsgiver(String id, ArbeidsgiverType type) {

    public enum ArbeidsgiverType {
        PRIVAT,
        ORGANISASJON
    }

    @Override
    public String toString() {
        return "Arbeidsgiver{" + "id='******', type=" + type + '}';
    }
}
