package no.nav.foreldrepenger.kontrakter.felles.kodeverk;

public enum MorsAktivitet implements Kodeverdi {
    ARBEID,
    UTDANNING,
    KVALPROG,
    INTROPROG,
    TRENGER_HJELP,
    INNLAGT,
    ARBEID_OG_UTDANNING,
    UFØRE,
    IKKE_OPPGITT;

    @Override
    public String getKode() {
        return name();
    }
}

