package no.nav.vedtak.hendelser.behandling.los;

public record LosFagsakEgenskaperDto(FagsakMarkering fagsakMarkering) {

    public enum FagsakMarkering {
        NASJONAL, EØS_BOSATT_NORGE, BOSATT_UTLAND, SAMMENSATT_KONTROLL, DØD, NÆRING, PRAKSIS_UTSETTELSE
    }
}
