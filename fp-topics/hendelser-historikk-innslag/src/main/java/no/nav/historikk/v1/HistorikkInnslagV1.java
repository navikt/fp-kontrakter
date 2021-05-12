package no.nav.historikk.v1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.historikk.HistorikkInnslag;
import no.nav.historikk.Saksnummer;
import no.nav.historikk.kodeverk.BrukerKjønnEnum;
import no.nav.historikk.kodeverk.HistorikkAktørEnum;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class HistorikkInnslagV1 extends HistorikkInnslag {

    @NotNull
    @Valid
    @JsonProperty(value = "behandlingUuid", required = true)
    private UUID behandlingUuid;

    /**
     * Unik ID for dokumentbestilling for å håndtere duplikater
     */
    @NotNull
    @Valid
    @JsonProperty(required = true)
    private UUID historikkUuid;

    @Valid
    @JsonProperty(value = "saksnummer", required = true)
    private Saksnummer saksnummer;

    @NotNull
    @Valid
    @JsonProperty(value = "historikkAktørType", required = true)
    private HistorikkAktørEnum historikkAktørType;

    /**
     * Kode for hvilket innslagtype som skal benyttes Obligatorisk Se i
     * HistorikkInnslagType.java i fpsak For gyldige verdier
     */
    @NotNull
    @Size(max = 100)
    @JsonProperty(value = "historikkInnslagType", required = true)
    private String historikkInnslagType;

  
    @Valid
    @JsonProperty(value = "brukerKjønn", required = true)
    private BrukerKjønnEnum brukerKjønn;

    @NotNull
    @Valid
    @JsonProperty(value = "dokumentLinker", required = true)
    private List<HistorikkInnslagDokumentLink> dokumentLinker = new ArrayList<>();

    @NotNull
    @Valid
    @JsonProperty(value = "historikkInnslagDeler", required = true)
    private List<HistorikkInnslagDel> historikkInnslagDeler = new ArrayList<>();

    @NotNull
    @Valid
    @Size(max = 20)
    @JsonProperty(value = "avsender", required = true)
    private String avsender;

    @NotNull
    @Valid
    @JsonProperty(value = "opprettetTidspunkt", required = true)
    private LocalDateTime opprettetTidspunkt;

    public String getAvsender() {
        return avsender;
    }

    public UUID getBehandlingUuid() {
        return behandlingUuid;
    }

    public UUID getHistorikkUuid() {
        return historikkUuid;
    }

    public HistorikkAktørEnum getHistorikkAktørType() {
        return historikkAktørType;
    }

    public String getHistorikkInnslagType() {
        return historikkInnslagType;
    }

    public List<HistorikkInnslagDokumentLink> getDokumentLinker() {
        return dokumentLinker;
    }

    public BrukerKjønnEnum getBrukerKjønn() {
        return brukerKjønn;
    }

    public BrukerKjønnEnum getBrukerKjoenn() {
        return brukerKjønn;
    }

    public Saksnummer getSaksnummer() {
        return saksnummer;
    }

    public List<HistorikkInnslagDel> getHistorikkInnslagDeler() {
        return historikkInnslagDeler;
    }

    public LocalDateTime getOpprettetTidspunkt() {
        return opprettetTidspunkt;
    }

    public static class Builder {
        private HistorikkInnslagV1 historikkinnslag;

        public Builder() {
            historikkinnslag = new HistorikkInnslagV1();
        }

        public Builder medBehandlingUuid(UUID behandlingUuid) {
            historikkinnslag.behandlingUuid = behandlingUuid;
            return this;
        }

        public Builder medHistorikkUuid(UUID historikkUuid) {
            historikkinnslag.historikkUuid = historikkUuid;
            return this;
        }

        public Builder medSaksnummer(Saksnummer Saksnummer) {
            historikkinnslag.saksnummer = Saksnummer;
            return this;
        }

        public Builder medHistorikkAktørType(HistorikkAktørEnum historikkAktørType) {
            historikkinnslag.historikkAktørType = historikkAktørType;
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

        public Builder medOpprettetTidspunkt(LocalDateTime opprettetTidspunkt) {
            historikkinnslag.opprettetTidspunkt = opprettetTidspunkt;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[behandlingUuid=" + behandlingUuid + ", historikkUuid=" + historikkUuid
                + ", saksnummer=" + saksnummer + ", historikkAktørType=" + historikkAktørType
                + ", historikkInnslagType=" + historikkInnslagType + ", brukerKjønn=" + brukerKjønn
                + ", dokumentLinker=" + dokumentLinker + ", historikkInnslagDeler=" + historikkInnslagDeler
                + ", avsender=" + avsender + ", opprettetTidspunkt=" + opprettetTidspunkt + "]";
    }
}
