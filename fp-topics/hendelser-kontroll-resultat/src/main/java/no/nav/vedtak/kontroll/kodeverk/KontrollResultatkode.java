package no.nav.vedtak.kontroll.kodeverk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class KontrollResultatkode extends Kodeverk {

    public static final String DISCRIMINATOR = "KONTROLL_RESULTATKODE"; //$NON-NLS-1$

    public static final KontrollResultatkode HØY = new KontrollResultatkode("HOY"); //$NON-NLS-1$
    public static final KontrollResultatkode IKKE_HØY = new KontrollResultatkode("IKKE_HOY"); //$NON-NLS-1$
    public static final KontrollResultatkode IKKE_KLASSIFISERT = new KontrollResultatkode("IKKE_KLASSIFISERT"); //$NON-NLS-1$

    @JsonCreator
    private KontrollResultatkode(@JsonProperty("kode") String kode) {
        super(DISCRIMINATOR, kode);
    }

}
