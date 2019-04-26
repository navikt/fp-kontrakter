package no.nav.familie.topic;

import java.util.Objects;

import org.apache.kafka.common.serialization.Serde;

public class Topic {

    private final String topic;
    private final Serde serdeKey;
    private final Serde serdeValue;

    <K, V> Topic(String topic, Serde<K> serdeKey, Serde<V> serdeValue) {
        Objects.requireNonNull(topic, "topic");
        Objects.requireNonNull(serdeKey, "serdeKey");
        Objects.requireNonNull(serdeValue, "serdeValue");
        this.topic = topic;
        this.serdeKey = serdeKey;
        this.serdeValue = serdeValue;
    }

    public String getTopic() {
        return topic;
    }

    public Serde getSerdeKey() {
        return serdeKey;
    }

    public Serde getSerdeValue() {
        return serdeValue;
    }

    /**
     * Genererer clientId basert på standard definert på https://confluence.adeo.no/display/AURA/Kafka#Kafka-TopicogSikkerhetskonfigurasjon
     * @return clientId
     */
    public String getProducerClientId() {
        return "KP-" + topic;
    }

    /**
     * Genererer clientId basert på standard definert på https://confluence.adeo.no/display/AURA/Kafka#Kafka-TopicogSikkerhetskonfigurasjon
     * @return clientId
     */
    public String getConsumerClientId() {
        return "KC-" + topic;
    }
}
