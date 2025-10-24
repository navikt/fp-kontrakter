package no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg;

import no.nav.foreldrepenger.kontrakter.fpsoknad.Kodeverdi;

import java.util.Set;

public enum DokumentTypeId implements Kodeverdi {

    // Søknader
    I000001("Søknad om svangerskapspenger"),
    I000002("Søknad om foreldrepenger ved adopsjon"),
    I000003("Søknad om engangsstønad ved fødsel"),
    I000004("Søknad om engangsstønad ved adopsjon"),
    I000005("Søknad om foreldrepenger ved fødsel"),
    I000050("Søknad om endring av uttak av foreldrepenger eller overføring av kvote"),

    // Vedlegg
    I000007("Inntektsopplysninger om selvstendig næringsdrivende og/eller frilansere som skal ha foreldrepenger eller svangerskapspenger"),
    I000023("Legeerklæring"),
    I000032("Resultatregnskap"),
    I000036("Dokumentasjon av ferie"),
    I000037("Dokumentasjon av innleggelse i helseinstitusjon"),
    I000038("Dokumentasjon av mors utdanning arbeid eller sykdom"),
    I000039("Dokumentasjon av militær- eller siviltjeneste"),
    I000042("Dokumentasjon av dato for overtakelse av omsorg"),
    I000044("Dokumentasjon av etterlønn/sluttvederlag"),
    I000051("Bekreftelse på deltakelse i kvalifiseringsprogrammet"),
    I000061("Bekreftelse fra studiested/skole"),
    I000062("Bekreftelse på ventet fødselsdato"),
    I000063("Fødselsattest"),
    I000066("Kopi av likningsattest eller selvangivelse"),
    I000065("Bekreftelse fra arbeidsgiver"),
    I000109("Skjema for tilrettelegging og omplassering ved graviditet"),
    I000110("Dokumentasjon av aleneomsorg"),
    I000111("Dokumentasjon av begrunnelse for hvorfor man søker tilbake i tid"),
    I000112("Dokumentasjon av deltakelse i introduksjonsprogrammet"),
    I000114("Uttalelse tilbakekreving"),
    I000116("Bekreftelse på øvelse eller tjeneste i Forsvaret eller Sivilforsvaret"),
    I000117("Bekreftelse på tiltak i regi av Arbeids- og velferdsetaten"),
    I000118("Begrunnelse for sen søknad"),
    I000119("Uttalelse om tilbakebetaling"),
    I000120("Dokumentasjon på at mor er innlagt på sykehus"),
    I000121("Dokumentasjon på at mor er syk"),
    I000122("Dokumentasjon på at far/medmor er innlagt på sykehus"),
    I000123("Dokumentasjon på at far/medmor er syk"),
    I000124("Dokumentasjon på at barnet er innlagt på sykehus"),
    I000130("Dokumentasjon på at mor studerer og arbeider til sammen heltid"),
    I000131("Dokumentasjon på at mor studerer på heltid"),
    I000132("Dokumentasjon på at mor er i arbeid"),
    I000133("Dokumentasjon av mors deltakelse i kvalifiseringsprogrammet"),
    I000140("Skattemelding"),
    I000141("Terminbekreftelse"),
    I000143("Dokumentasjon på oppholdstillatelse"),
    I000144("Dokumentasjon på reiser til og fra Norge"),
    I000145("Dokumentasjon på oppfølging i svangerskapet"),
    I000146("Dokumentasjon på inntekt"),
    I000060("Annet");

    private String tittel;

    DokumentTypeId(String tittel) {
        this.tittel = tittel;
    }

    public String getTittel() {
        return tittel;
    }

    @Override
    public String getKode() {
        return name();
    }

    public boolean erSøknad() {
        return Set.of(I000001, I000002, I000003, I000004, I000005, I000050).contains(this);
    }

    public boolean erUttalelseOmTilbakebetaling() {
        return Set.of(I000114, I000119).contains(this);
    }
}
