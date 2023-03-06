package no.nav.vedtak.hendelser.behandling.los;

public record LosFagsakEgenskaperDto(UtlandMarkering utlandMarkering) {

    public enum UtlandMarkering {
        NASJONAL, EØS_BOSATT_NORGE, BOSATT_UTLAND
    }
}
