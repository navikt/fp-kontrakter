package no.nav.historikk.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.historikk.HistorikkInnslag;
import no.nav.historikk.kodeverk.HistorikkAktørEnum;
import no.nav.historikk.kodeverk.BrukerKjønnEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HistorikkInnslagV1 extends HistorikkInnslag {

    @NotNull
    @JsonProperty("behandlingUuid")
    private UUID behandlingUuid;

    @NotNull
    @Pattern(regexp = "^(-?[1-9]|[a-z0])[a-z0-9_:-]*$", flags = {Pattern.Flag.CASE_INSENSITIVE})
    @JsonProperty("saksnummer")
    private Long saksnummer;

    @NotNull
    @JsonProperty("aktør")
    private HistorikkAktørEnum aktør;

    /**
     * Kode for hvilket innslagtype som skal benyttes
     * Obligatorisk
     * Se i HistorikkInnslagType.java i fpsak
     * For gyldige verdier
     */
    @NotNull
    @Pattern(regexp = "[A-Z]{6}")
    private String historikkInnslagType;

    @NotNull
    @JsonProperty("brukerKjønn")
    private BrukerKjønnEnum brukerKjønn;

    @NotNull
    @Valid
    @JsonProperty("dokumentLinker")
    private List<HistorikkInnslagDokumentLink> dokumentLinker = new ArrayList<>();

    @NotNull
    @Valid
    @JsonProperty("historikkInnslagDeler")
    private List<HistorikkInnslagDel> historikkInnslagDeler = new ArrayList<>();


    @NotNull
    @Valid
    @JsonProperty
    private String avsender;

    public String getAvsender() { return avsender; }

    public UUID getBehandlingUuid() { return behandlingUuid; }

    public HistorikkAktørEnum getAktør() {
        return aktør;
    }

    public String getHistorikkInnslagType() {
        return historikkInnslagType;
    }

    public List<HistorikkInnslagDokumentLink> getDokumentLinker() {
        return dokumentLinker;
    }

    public BrukerKjønnEnum getBrukerKjoenn() {
        return brukerKjønn;
    }

    public Long getSaksnummer() {
        return saksnummer;
    }

    public List<HistorikkInnslagDel> getHistorikkInnslagDeler() {
        return historikkInnslagDeler;
    }

    public static class Builder {
        private HistorikkInnslagV1 historikkinnslag;

        public Builder() {
            historikkinnslag = new HistorikkInnslagV1();
        }

        public Builder medBehandlingId(UUID behandlingId) {
            historikkinnslag.behandlingUuid = behandlingId;
            return this;
        }

        public Builder medFagsakId(Long fagsakId) {
            historikkinnslag.saksnummer = fagsakId;
            return this;
        }

        public Builder medAktør(HistorikkAktørEnum historikkAktørEnum) {
            historikkinnslag.aktør = historikkAktørEnum;
            return this;
        }

        public Builder medType(String type) {
            historikkinnslag.historikkInnslagType = type;
            return this;
        }

        public Builder medBrukerKjoenn(BrukerKjønnEnum kjoenn) {
            historikkinnslag.brukerKjønn = kjoenn;
            return this;
        }

        public Builder medAvsender(String avsender) {
            historikkinnslag.avsender = avsender;
            return this;
        }

        public Builder medDokumentLinker(List<HistorikkInnslagDokumentLink> dokumentLinker) {
            if (historikkinnslag.dokumentLinker == null) {
                historikkinnslag.dokumentLinker = dokumentLinker;
            } else if (dokumentLinker != null) {
                historikkinnslag.dokumentLinker.addAll(dokumentLinker);
            }
            return this;
        }

        public Builder medHistorikkInnslagDeler(List<HistorikkInnslagDel> historikkInnslagDeler) {
            if (historikkinnslag.historikkInnslagDeler == null) {
                historikkinnslag.historikkInnslagDeler = historikkInnslagDeler;
            } else if (historikkInnslagDeler != null) {
                historikkinnslag.historikkInnslagDeler.addAll(historikkInnslagDeler);
            }
            return this;
        }

        public HistorikkInnslagV1 build() {
            return historikkinnslag;
        }
    }
}
