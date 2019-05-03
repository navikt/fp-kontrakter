package no.nav.foreldrepenger.kontrakter.callback.registerdata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;
import java.util.regex.Pattern;

import org.junit.Test;

public class ReferanseDtoTest {

    @Test
    public void skal_validere_UUID_med_regex() {

        UUID uuid = UUID.randomUUID();

        Pattern pattern = Pattern.compile(ReferanseDto.UUID_REGEX);

        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        assertThat(pattern.matcher("FASDFASDA-asd").matches()).isFalse();
        assertThat(pattern.matcher("FASDFASD-asdd-asdf-asdf-asdfasdfasdf").matches()).isFalse();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
        uuid = UUID.randomUUID();
        assertThat(pattern.matcher(uuid.toString()).matches()).isTrue();
    }
}