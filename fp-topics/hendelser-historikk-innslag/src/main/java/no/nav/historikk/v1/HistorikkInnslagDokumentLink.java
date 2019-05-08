package no.nav.historikk.v1;

import no.nav.historikk.JournalpostId;

public class HistorikkInnslagDokumentLink {

    private Long id;
    private String linkTekst;
    private JournalpostId journalpostId;
    private String dokumentId;

    public Long getId() { return id; }

    public String getLinkTekst() {
        return linkTekst;
    }

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

        public Builder medId(Long id) {
            historikkinnslagDokumentLink.id = id;
            return this;
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
