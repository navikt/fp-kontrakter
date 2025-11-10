package no.nav.foreldrepenger.kontrakter.fpoversikt;


import jakarta.validation.constraints.NotNull;

public record Arbeidsgiver(@NotNull String id, ArbeidsgiverType type) {

    public enum ArbeidsgiverType {
        PRIVAT,
        ORGANISASJON
    }

    @Override
    public String toString() {
        return "Arbeidsgiver{" + "id='******', type=" + type + '}';
    }
}
