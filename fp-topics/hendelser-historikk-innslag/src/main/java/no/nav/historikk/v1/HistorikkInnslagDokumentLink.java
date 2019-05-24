package no.nav.historikk.v1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.historikk.JournalpostId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class HistorikkInnslagDokumentLink {

    @NotNull
    @Valid
    @JsonProperty(required = true)
    private String linkTekst;

    @NotNull
    @Valid
    @JsonProperty(required = true)
    private JournalpostId journalpostId;

    @NotNull
    @Valid
    @JsonProperty(required = true)
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
