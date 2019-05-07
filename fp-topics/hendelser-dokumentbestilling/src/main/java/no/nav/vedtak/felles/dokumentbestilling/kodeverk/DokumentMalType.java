package no.nav.vedtak.felles.dokumentbestilling.kodeverk;

public class DokumentMalType extends Kodeverk {

    public static final DokumentMalType POSITIVT_VEDTAK_DOK = new DokumentMalType("POSVED");
    public static final DokumentMalType INNHENT_DOK = new DokumentMalType("INNHEN");
    public static final DokumentMalType HENLEGG_BEHANDLING_DOK = new DokumentMalType("HENLEG");
    public static final DokumentMalType AVSLAGSVEDTAK_DOK = new DokumentMalType("AVSLAG");
    public static final DokumentMalType UENDRETUTFALL_DOK = new DokumentMalType("UENDRE");
    public static final DokumentMalType FORLENGET_DOK = new DokumentMalType("FORLEN");
    public static final DokumentMalType FORLENGET_MEDL_DOK = new DokumentMalType("FORLME");
    public static final DokumentMalType FORLENGET_TIDLIG_SOK = new DokumentMalType("FORLTS");
    public static final DokumentMalType FORLENGET_OPPTJENING = new DokumentMalType("FOROPT");
    public static final DokumentMalType REVURDERING_DOK = new DokumentMalType("REVURD");
    public static final DokumentMalType KLAGE_AVVIST_DOK = new DokumentMalType("KLAGAV");
    public static final DokumentMalType KLAGE_YTELSESVEDTAK_STADFESTET_DOK = new DokumentMalType("KLAGVE");
    public static final DokumentMalType KLAGE_YTELSESVEDTAK_OPPHEVET_DOK = new DokumentMalType("KLAGNY");
    public static final DokumentMalType KLAGE_OVERSENDT_KLAGEINSTANS_DOK = new DokumentMalType("KLAGOV");
    public static final DokumentMalType INNSYNSKRAV_SVAR = new DokumentMalType("INSSKR");
    public static final DokumentMalType INNVILGELSE_FORELDREPENGER_DOK = new DokumentMalType("INNVFP");
    public static final DokumentMalType OPPHØR_DOK = new DokumentMalType("OPPHOR");
    public static final DokumentMalType INNTEKTSMELDING_FOR_TIDLIG_DOK = new DokumentMalType("INNTID");
    public static final DokumentMalType AVSLAG_FORELDREPENGER_DOK = new DokumentMalType("AVSLFP");
    public static final DokumentMalType FRITEKST_DOK = new DokumentMalType("FRITKS");
    public static final DokumentMalType VEDTAK_MEDHOLD = new DokumentMalType("VEDMED");

    private DokumentMalType(String kode) {
        super(kode);
    }

}
