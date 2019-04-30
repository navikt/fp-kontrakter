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

    private TopicManifest() {
    }
}
