package no.nav.familie.topic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TopicManifestTest {

    @Test
    public void test_that_topic_manifest_is_set() {
        String topic = TopicManifest.AKSJONSPUNKT_HENDELSE.getTopic();
        assertThat(topic).startsWith("privat");
        String topicWithEnv = TopicManifest.AKSJONSPUNKT_HENDELSE.getTopicWithEnv("p");
        assertThat(topicWithEnv).endsWith("p");
    }

    @Test
    public void test_that_illegal_environments_throws_exeption() {
        assertThrows(IllegalArgumentException.class, () -> TopicManifest.AKSJONSPUNKT_HENDELSE.getTopicWithEnv("k"));
    }

    @Test
    public void test_that_topics_defined_is_correct() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] declaredFields = TopicManifest.class.getDeclaredFields();
        for (Field field : declaredFields) {
            assertThat(field.getType().getName()).isEqualTo(Topic.class.getName());
            field.setAccessible(true);
            Object fieldValue = field.get(TopicManifest.class);
            Method myMethod = fieldValue.getClass().getDeclaredMethod("getTopic", new Class[]{});
            Object result = myMethod.invoke(fieldValue);
            assertThat(result.toString()).startsWith("privat");
        }
    }
}
