package no.nav.historikk.kodeverk;

public class HistorikkAktør extends Kodeverk
{

    public static final String DISCRIMINATOR = "HISTORIKK_AKTOER"; //$NON-NLS-1$
    public static final HistorikkAktør BESLUTTER = new HistorikkAktør("BESL"); //$NON-NLS-1$
    public static final HistorikkAktør SAKSBEHANDLER = new HistorikkAktør("SBH"); //$NON-NLS-1$
    public static final HistorikkAktør SØKER = new HistorikkAktør("SOKER"); //$NON-NLS-1$
    public static final HistorikkAktør ARBEIDSGIVER = new HistorikkAktør("ARBEIDSGIVER"); //$NON-NLS-1$
    public static final HistorikkAktør VEDTAKSLØSNINGEN = new HistorikkAktør("VL"); //$NON-NLS-1$
    public static final HistorikkAktør UDEFINERT =  new HistorikkAktør("-"); //$NON-NLS-1$

    private HistorikkAktør(String kode) { super(DISCRIMINATOR, kode); }

    @Override
    public void setKodeverk(String kodeverk) {
        if (DISCRIMINATOR.equals(kodeverk)) {
            super.setKodeverk(kodeverk);
        }
    }

}
