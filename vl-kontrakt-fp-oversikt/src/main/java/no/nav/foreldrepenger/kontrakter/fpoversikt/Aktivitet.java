package no.nav.foreldrepenger.kontrakter.fpoversikt;

import jakarta.validation.constraints.NotNull;

public record Aktivitet(@NotNull Aktivitet.AktivitetType type, Arbeidsgiver arbeidsgiver, String arbeidsgiverNavn) {

    public enum AktivitetType {
        FRILANS, ORDINÆRT_ARBEID, SELVSTENDIG_NÆRINGSDRIVENDE, ANNET
    }
}
