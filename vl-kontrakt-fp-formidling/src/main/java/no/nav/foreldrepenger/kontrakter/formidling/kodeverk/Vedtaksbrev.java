package no.nav.foreldrepenger.kontrakter.formidling.kodeverk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vedtaksbrev extends Kodeverk {

    private static final String DISCRIMINATOR = "VEDTAKSBREV";

    public static final Vedtaksbrev AUTOMATISK = new Vedtaksbrev("AUTOMATISK"); //$NON-NLS-1$
    public static final Vedtaksbrev FRITEKST = new Vedtaksbrev("FRITEKST"); //$NON-NLS-1$
    public static final Vedtaksbrev INGEN = new Vedtaksbrev("INGEN"); //$NON-NLS-1$

    public static final Vedtaksbrev UDEFINERT = new Vedtaksbrev("-"); //$NON-NLS-1$

    @JsonCreator
    private Vedtaksbrev(@JsonProperty("kode") String kode) {
        super(DISCRIMINATOR, kode);
    }
}
