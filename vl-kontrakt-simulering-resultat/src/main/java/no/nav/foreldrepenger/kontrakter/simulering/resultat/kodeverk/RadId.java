package no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RadId {

    NYTT_BELØP("nyttBeløp"),
    TIDLIGERE_UTBETALT("tidligereUtbetalt"),
    DIFFERANSE("differanse"),
    RESULTAT_ETTER_MOTREGNING("resultatEtterMotregning"),
    INNTREKK_NESTE_MÅNED("inntrekkNesteMåned"),
    RESULTAT("resultat");

    private String eksternRepresentasjon;

    RadId(String eksternRepresentasjon) {
        this.eksternRepresentasjon = eksternRepresentasjon;
    }

    @JsonValue
    public String getEksternRepresentasjon() {
        return eksternRepresentasjon;
    }
}
