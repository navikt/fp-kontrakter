package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Scanner;

import javax.validation.Validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.IayGrunnlagJsonMapper;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.InntektArbeidYtelseGrunnlagDto;

@RunWith(Parameterized.class)
public class IAYMigreringNPETest {

    private String fileName;

    @Parameters(name = "test_parse_file={0}")
    public static List<String> fileNames() {
        return List.of(
            "/iay_case_001.json",
            "/iay_case_002.json",
            "/iay_case_003.json",
            "/iay_case_004.json",
            "/iay_case_005.json");
    }

    public IAYMigreringNPETest(String fileName) {
        this.fileName = fileName;

    }

    @Test
    public void test_file() throws Exception {
        var reader = IayGrunnlagJsonMapper.getMapper().readerFor(InntektArbeidYtelseGrunnlagDto.class);

        String str = readNextTestCase();

        InntektArbeidYtelseGrunnlagDto dto = reader.readValue(str);
        assertThat(dto).isNotNull();
        assertThat(dto.getPerson()).isNotNull();

        validateResult(dto);

    }

    private String readNextTestCase() throws IOException {
        String str = null;
        try (var is = getClass().getResourceAsStream(fileName);
                java.util.Scanner s = new java.util.Scanner(is, Charset.forName("UTF-8"));
                Scanner s2 = s.useDelimiter("\\A")) {

            str = s2.hasNext() ? s2.next() : "";
        }
        return str;
    }

    private void validateResult(Object roundTripped) {
        assertThat(roundTripped).isNotNull();
        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }
    }
}
