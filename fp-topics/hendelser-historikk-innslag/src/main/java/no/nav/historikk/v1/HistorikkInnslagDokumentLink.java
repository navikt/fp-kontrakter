package no.nav.historikk.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.historikk.JournalpostId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HistorikkInnslagDokumentLink {

    @NotNull
    @Valid
    @JsonProperty
    private String linkTekst;

    @NotNull
    @Valid
    @JsonProperty
    private JournalpostId journalpostId;

    @NotNull
    @Valid
    @JsonProperty
    private String dokumentId;

    public String getLinkTekst() { return linkTekst; }

    public JournalpostId getJournalpostId() {
        return journalpostId;
    }

    public String getDokumentId() {
        return dokumentId;
    }

    public static class Builder {
        private HistorikkInnslagDokumentLink historikkinnslagDokumentLink;

        public Builder() {
            historikkinnslagDokumentLink = new HistorikkInnslagDokumentLink();
        }

        public Builder medLinkTekst(String linkTekst) {
            historikkinnslagDokumentLink.linkTekst = linkTekst;
            return this;
        }

        public Builder medJournalpostId(JournalpostId journalpostId) {
            historikkinnslagDokumentLink.journalpostId = journalpostId;
            return this;
        }

        public Builder medDokumentId(String dokumentId) {
            historikkinnslagDokumentLink.dokumentId = dokumentId;
            return this;
        }

        public HistorikkInnslagDokumentLink build() {
            return historikkinnslagDokumentLink;
        }
    }
}
