package no.nav.historikk.kodeverk;


public class HistorikkInnslagFeltType extends Kodeverk {

    private static final String DISCRIMINATOR = "HISTORIKKINNSLAG_FELT_TYPE"; //$NON-NLS-1$

    public static final HistorikkInnslagFeltType UDEFINIERT = new HistorikkInnslagFeltType("-");

    public static final HistorikkInnslagFeltType AARSAK = new HistorikkInnslagFeltType("AARSAK");
    public static final HistorikkInnslagFeltType BEGRUNNELSE = new HistorikkInnslagFeltType("BEGRUNNELSE");
    public static final HistorikkInnslagFeltType HENDELSE = new HistorikkInnslagFeltType("HENDELSE");
    public static final HistorikkInnslagFeltType RESULTAT = new HistorikkInnslagFeltType("RESULTAT");
    public static final HistorikkInnslagFeltType OPPLYSNINGER = new HistorikkInnslagFeltType("OPPLYSNINGER");
    public static final HistorikkInnslagFeltType ENDRET_FELT = new HistorikkInnslagFeltType("ENDRET_FELT");
    public static final HistorikkInnslagFeltType SKJERMLENKE = new HistorikkInnslagFeltType("SKJERMLENKE");
    public static final HistorikkInnslagFeltType GJELDENDE_FRA = new HistorikkInnslagFeltType("GJELDENDE_FRA");
    public static final HistorikkInnslagFeltType AKSJONSPUNKT_BEGRUNNELSE = new HistorikkInnslagFeltType("AKSJONSPUNKT_BEGRUNNELSE");
    public static final HistorikkInnslagFeltType AKSJONSPUNKT_GODKJENT = new HistorikkInnslagFeltType("AKSJONSPUNKT_GODKJENT");
    public static final HistorikkInnslagFeltType AKSJONSPUNKT_KODE = new HistorikkInnslagFeltType("AKSJONSPUNKT_KODE");
    public static final HistorikkInnslagFeltType AVKLART_SOEKNADSPERIODE = new HistorikkInnslagFeltType("AVKLART_SOEKNADSPERIODE");
    public static final HistorikkInnslagFeltType ANGÅR_TEMA = new HistorikkInnslagFeltType("ANGÅR_TEMA");

    private HistorikkInnslagFeltType(String kode) {
        super(DISCRIMINATOR, kode);
    }

}