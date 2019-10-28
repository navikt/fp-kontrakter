package no.nav.vedtak.felles.integrasjon.kafka;

public class Event {
    protected String fagsystem;
    protected String saksnummer;
    protected String aktørId;
    protected String behandlendeEnhet;  // Enheten som har ansvar for behandlingen for eksempel: 4066
    protected String ytelseTypeKode;  // koden til ytelsetype for eksempel : PF
    protected String behandlingTypeKode; // koden til behandlingstype feks : BT-002

    public String getFagsystem() {
        return fagsystem;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public String getAktørId() {
        return aktørId;
    }

    public String getBehandlendeEnhet() {
        return behandlendeEnhet;
    }

    public String getYtelseTypeKode() {
        return ytelseTypeKode;
    }

    public String getBehandlingTypeKode() {
        return behandlingTypeKode;
    }
}
