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
    public static final Topic AKSJONSPUNKT_HENDELSE = new Topic("privat-foreldrepenger-aksjonspunkthendelse-fpsak", Serdes.String(), Serdes.String());
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

    private TopicManifest() {
    }
}
