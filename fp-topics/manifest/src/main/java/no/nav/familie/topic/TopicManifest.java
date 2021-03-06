package no.nav.familie.topic;

import org.apache.kafka.common.serialization.Serdes;

/**
 * Manifest over topics for familieområdet
 */
public final class TopicManifest {
    /**
     * Publiseres vedtak og deres anvisninger som lagres så i et ytelselager.
     */
    public static final Topic FATTET_VEDTAK = new Topic("privat-familie-vedtakFattet-v1", Serdes.String(), Serdes.String());
    /**
     * Publiserer hendelser ved endringer i aksjonspunkt. Benyttes for oppgavestyring
     */
    public static final Topic AKSJONSPUNKT_HENDELSE = new Topic("privat-foreldrepenger-aksjonspunkthendelse", Serdes.String(), Serdes.String());
    /**
     * Publiserer hendelser ved bestilling av dokument
     */
    public static final Topic DOKUMENT_HENDELSE = new Topic("privat-foreldrepenger-dokumentbestilling", Serdes.String(), Serdes.String());
    /**
     * Publiserer hendelser ved opprettelse av historikk innslag
     */
    public static final Topic HISTORIKK_HENDELSE = new Topic("privat-foreldrepenger-historikkinnslag", Serdes.String(), Serdes.String());
    /**
     * Publiserer kontrollresultat av en behandling
     */
    public static final Topic KONTROLL_RESULTAT = new Topic("privat-foreldrepenger-kontroll-resultat", Serdes.String(), Serdes.String());

    /**
     * Publiserer risikoklassifiseringstopic
     */
    public static final Topic RISIKOKLASSIFISERING = new Topic("privat-foreldrepenger-fprisk-utfor", Serdes.String(), Serdes.String());

    /**
     * Publiser dokumenthendelser for inntektsmelding (og potensielt andre dokument sendt inn av andre enn bruker)
     */
    public static final Topic BRUKERDIALOG_INNTEKTSMELDING = new Topic("privat-foreldrepenger-brukerdialog-inntektsmelding", Serdes.String(), Serdes.String());

    private TopicManifest() {
    }
}
