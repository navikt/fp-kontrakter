package no.nav.foreldrepenger.kontrakter.felles.kodeverk;

public enum Overføringsårsak implements Kodeverdi {
    INSTITUSJONSOPPHOLD_ANNEN_FORELDER,
    SYKDOM_ANNEN_FORELDER,
    ALENEOMSORG,
    IKKE_RETT_ANNEN_FORELDER;

    @Override
    public String getKode() {
        return name();
    }
}
