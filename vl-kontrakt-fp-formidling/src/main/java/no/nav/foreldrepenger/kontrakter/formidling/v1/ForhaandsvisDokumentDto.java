package no.nav.foreldrepenger.kontrakter.formidling.v1;

import javax.validation.constraints.NotNull;

/**
 * TODO: Team Onyx - Dette trenges til fpsak er brukt som proxy for Fpsak-frontend.
 * Må slettes når fpsak-frontend kaller fpformidling direkt.
 */
public class ForhaandsvisDokumentDto {
    @NotNull
    private byte[] dokument;

    public ForhaandsvisDokumentDto() {
    }

    public ForhaandsvisDokumentDto(byte[] dokument) {
        this.dokument = dokument;
    }

    public byte[] getDokument() {
        return dokument;
    }
}
