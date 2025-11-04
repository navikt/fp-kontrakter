package no.nav.foreldrepenger.kontrakter.felles.kodeverk;

public enum KontoType implements Kodeverdi {
    FELLESPERIODE,
    MØDREKVOTE,
    FEDREKVOTE,
    FORELDREPENGER,
    FORELDREPENGER_FØR_FØDSEL;

    @Override
    public String getKode() {
        return name();
    }
}