package no.nav.historikk.kodeverk;

public class HistorikkInnslagType extends Kodeverk {

    public static final String DISCRIMINATOR = "HISTORIKKINNSLAG_TYPE"; //$NON-NLS-1$

    public static final HistorikkInnslagType UDEFINIERT = new HistorikkInnslagType("-");

    static final String MAL_TYPE_1 = "TYPE1";
    static final String MAL_TYPE_2 = "TYPE2";
    static final String MAL_TYPE_3 = "TYPE3";
    static final String MAL_TYPE_4 = "TYPE4";
    static final String MAL_TYPE_5 = "TYPE5";
    static final String MAL_TYPE_6 = "TYPE6";
    static final String MAL_TYPE_7 = "TYPE7";
    static final String MAL_TYPE_8 = "TYPE8";
    static final String MAL_TYPE_9 = "TYPE9";
    static final String MAL_TYPE_10 = "TYPE10";

    // type 1
    public static final HistorikkInnslagType KØET_BEH_GJEN = new HistorikkInnslagType("KØET_BEH_GJEN");
    public static final HistorikkInnslagType BEH_GJEN = new HistorikkInnslagType("BEH_GJEN");
    public static final HistorikkInnslagType BEH_MAN_GJEN = new HistorikkInnslagType("BEH_MAN_GJEN");
    public static final HistorikkInnslagType BEH_STARTET = new HistorikkInnslagType("BEH_STARTET");
    public static final HistorikkInnslagType BEH_STARTET_PÅ_NYTT = new HistorikkInnslagType("BEH_STARTET_PÅ_NYTT");
    public static final HistorikkInnslagType VEDLEGG_MOTTATT = new HistorikkInnslagType("VEDLEGG_MOTTATT");
    public static final HistorikkInnslagType BREV_SENT = new HistorikkInnslagType("BREV_SENT");
    public static final HistorikkInnslagType BREV_BESTILT = new HistorikkInnslagType("BREV_BESTILT");
    public static final HistorikkInnslagType REVURD_OPPR = new HistorikkInnslagType("REVURD_OPPR");
    public static final HistorikkInnslagType REGISTRER_PAPIRSØK = new HistorikkInnslagType("REGISTRER_PAPIRSØK");
    public static final HistorikkInnslagType MANGELFULL_SØKNAD = new HistorikkInnslagType("MANGELFULL_SØKNAD");
    public static final HistorikkInnslagType INNSYN_OPPR = new HistorikkInnslagType("INNSYN_OPPR");
    public static final HistorikkInnslagType VRS_REV_IKKE_SNDT = new HistorikkInnslagType("VRS_REV_IKKE_SNDT");
    public static final HistorikkInnslagType NYE_REGOPPLYSNINGER = new HistorikkInnslagType("NYE_REGOPPLYSNINGER");
    public static final HistorikkInnslagType BEH_AVBRUTT_VUR = new HistorikkInnslagType("BEH_AVBRUTT_VUR");
    public static final HistorikkInnslagType KLAGEBEH_STARTET = new HistorikkInnslagType("KLAGEBEH_STARTET");
    public static final HistorikkInnslagType BEH_OPPDATERT_NYE_OPPL = new HistorikkInnslagType("BEH_OPPDATERT_NYE_OPPL");
    public static final HistorikkInnslagType SPOLT_TILBAKE = new HistorikkInnslagType("SPOLT_TILBAKE");
    public static final HistorikkInnslagType TERMINBEKREFTELSE_UGYLDIG = new HistorikkInnslagType("TERMINBEKREFTELSE_UGYLDIG");

    // type 2
    public static final HistorikkInnslagType FORSLAG_VEDTAK = new HistorikkInnslagType("FORSLAG_VEDTAK");
    public static final HistorikkInnslagType FORSLAG_VEDTAK_UTEN_TOTRINN = new HistorikkInnslagType("FORSLAG_VEDTAK_UTEN_TOTRINN");
    public static final HistorikkInnslagType VEDTAK_FATTET = new HistorikkInnslagType("VEDTAK_FATTET");
    public static final HistorikkInnslagType UENDRET_UTFALL = new HistorikkInnslagType("UENDRET_UTFALL");
    public static final HistorikkInnslagType REGISTRER_OM_VERGE = new HistorikkInnslagType("REGISTRER_OM_VERGE");
    public static final HistorikkInnslagType TILBAKEKREVING_VIDEREBEHANDLING = new HistorikkInnslagType("TILBAKEKR_VIDEREBEHANDLING");


    // type 3
    public static final HistorikkInnslagType SAK_RETUR = new HistorikkInnslagType("SAK_RETUR");

    // type 4
    public static final HistorikkInnslagType AVBRUTT_BEH = new HistorikkInnslagType("AVBRUTT_BEH");
    public static final HistorikkInnslagType BEH_VENT = new HistorikkInnslagType("BEH_VENT");
    public static final HistorikkInnslagType BEH_KØET = new HistorikkInnslagType("BEH_KØET");
    public static final HistorikkInnslagType IVERKSETTELSE_VENT = new HistorikkInnslagType("IVERKSETTELSE_VENT");

    // type 5
    public static final HistorikkInnslagType FAKTA_ENDRET = new HistorikkInnslagType("FAKTA_ENDRET");
    public static final HistorikkInnslagType BYTT_ENHET = new HistorikkInnslagType("BYTT_ENHET");
    public static final HistorikkInnslagType KLAGE_BEH_NFP = new HistorikkInnslagType("KLAGE_BEH_NFP");
    public static final HistorikkInnslagType KLAGE_BEH_NK = new HistorikkInnslagType("KLAGE_BEH_NK");
    public static final HistorikkInnslagType UTTAK = new HistorikkInnslagType("UTTAK");

    // type 6
    public static final HistorikkInnslagType NY_INFO_FRA_TPS = new HistorikkInnslagType("NY_INFO_FRA_TPS");

    // type 7
    public static final HistorikkInnslagType OVERSTYRT = new HistorikkInnslagType("OVERSTYRT");

    // type 8
    public static final HistorikkInnslagType OPPTJENING = new HistorikkInnslagType("OPPTJENING");

    // type 9
    public static final HistorikkInnslagType OVST_UTTAK_SPLITT = new HistorikkInnslagType("OVST_UTTAK_SPLITT");
    public static final HistorikkInnslagType FASTSATT_UTTAK_SPLITT = new HistorikkInnslagType("FASTSATT_UTTAK_SPLITT");

    // type 10
    public static final HistorikkInnslagType OVST_UTTAK = new HistorikkInnslagType("OVST_UTTAK");
    public static final HistorikkInnslagType FASTSATT_UTTAK = new HistorikkInnslagType("FASTSATT_UTTAK");


    private HistorikkInnslagType(String kode) {
        super(DISCRIMINATOR, kode);
    }

}
