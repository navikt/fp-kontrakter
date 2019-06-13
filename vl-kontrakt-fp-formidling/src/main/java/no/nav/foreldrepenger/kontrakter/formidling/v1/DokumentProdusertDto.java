package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DokumentProdusertDto {
    /**
     * ID til Behandlingen i FPSAK det bestilles dokument for
     */
    @NotNull
    @Valid
    private UUID behandlingUuid;
    /**
     * Kode for hvilket dokument som er bestilt
     * Se i DokumentMalType.java her  https://github.com/navikt/fp-formidling/
     * For gyldige verdier
     */
    @NotNull
    @Pattern(regexp = "[A-Z]{6}")
    private String dokumentMal;

    public DokumentProdusertDto() {
        // trengs for deserialisering av JSON
    }

    public DokumentProdusertDto(UUID behandlingUuid, String dokumentMal) {
        this.behandlingUuid = behandlingUuid;
        this.dokumentMal = dokumentMal;
    }

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public void setBehandlingUuid(UUID behandlingUuid) {
        this.behandlingUuid = behandlingUuid;
    }

    public String getDokumentMal() {
        return dokumentMal;
    }

    public void setDokumentMal(String dokumentMal) {
        this.dokumentMal = dokumentMal;
    }
}
