package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.LandkoderDto;

public class OppgittUtenlandskVirksomhetDto {
    private LandkoderDto landkode;
    private String utenlandskVirksomhetNavn;

    public OppgittUtenlandskVirksomhetDto() {
    }

    public LandkoderDto getLandkode() {
        return landkode;
    }

    public void setLandkode(LandkoderDto landkode) {
        this.landkode = landkode;
    }

    public String getUtenlandskVirksomhetNavn() {
        return utenlandskVirksomhetNavn;
    }

    public void setUtenlandskVirksomhetNavn(String utenlandskVirksomhetNavn) {
        this.utenlandskVirksomhetNavn = utenlandskVirksomhetNavn;
    }
}
