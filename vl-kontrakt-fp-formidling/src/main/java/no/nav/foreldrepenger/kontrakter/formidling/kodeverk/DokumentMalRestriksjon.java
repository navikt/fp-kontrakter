package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DokumentMalRestriksjon extends Kodeverk {
    private static final String DISCRIMINATOR = "DOKUMENT_MAL_RESTRIKSJON";

    public static final DokumentMalRestriksjon INGEN = new DokumentMalRestriksjon("INGEN");
    public static final DokumentMalRestriksjon REVURDERING = new DokumentMalRestriksjon("REVURDERING");
    public static final DokumentMalRestriksjon ÅPEN_BEHANDLING = new DokumentMalRestriksjon("ÅPEN_BEHANDLING");
    public static final DokumentMalRestriksjon ÅPEN_BEHANDLING_IKKE_SENDT = new DokumentMalRestriksjon("ÅPEN_BEHANDLING_IKKE_SENDT");

    @JsonCreator
    private DokumentMalRestriksjon(@JsonProperty("kode") String kode) {
        super(DISCRIMINATOR, kode);
    }
}
