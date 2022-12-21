package no.nav.foreldrepenger.kontrakter.fpwsproxy.tilbakekreving.kravgrunnlag.request;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum KodeAksjon {
    FINN_GRUNNLAG_OMGJØRING("3"),
    HENT_KORRIGERT_KRAVGRUNNLAG("4"),
    HENT_GRUNNLAG_OMGJØRING("5"),
    FATTE_VEDTAK("8"),
    ANNULERE_GRUNNLAG("A");

    private static final Map<String, KodeAksjon> KODER = new LinkedHashMap<>();

    static {
        for (var v : values()) {
            if (KODER.putIfAbsent(v.kode, v) != null) {
                throw new IllegalArgumentException("Duplikat : " + v.kode);
            }
        }
    }

    public static KodeAksjon fraKode(String kode) {
        if (kode == null) {
            return null;
        }
        var ad = KODER.get(kode);
        if (ad == null) {
            throw new IllegalArgumentException("Ukjent KodeAksjon: " + kode);
        }
        return ad;
    }

    @JsonValue
    private final String kode;

    KodeAksjon(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }
}
