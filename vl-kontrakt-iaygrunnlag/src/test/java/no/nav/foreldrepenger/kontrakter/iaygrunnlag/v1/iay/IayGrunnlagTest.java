package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;

import javax.validation.Validation;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.IayGrunnlagJsonMapper;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.FnrPersonident;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Organisasjon;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.ArbeidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid.YrkesaktivitetDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.inntekt.InntekterDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ytelse.YtelserDto;

public class IayGrunnlagTest {

    private static final ObjectWriter WRITER = IayGrunnlagJsonMapper.getMapper().writerWithDefaultPrettyPrinter();
    private static final ObjectReader READER = IayGrunnlagJsonMapper.getMapper().reader();

    @Test
    public void skal_generere_iaygrunnlag_json() throws Exception {

        FnrPersonident fnr = new FnrPersonident("12341234123");
        Organisasjon org = new Organisasjon("022090422");

        ArbeidTypeDto arbeidType = new ArbeidTypeDto("ORDINÆRT");

        UUID uuid = UUID.randomUUID();

        GrunnlagDto grunnlag = new GrunnlagDto(uuid);
        grunnlag.medRegister(new InntektArbeidYtelseAggregatDto()
            .medArbeid(List.of(new ArbeidDto(fnr).medYrkesaktiviteter(List.of(new YrkesaktivitetDto(org, arbeidType)))))
            .medInntekt(List.of(new InntekterDto(fnr)))
            .medYtelse(List.of(new YtelserDto(fnr))));

        String json = WRITER.writeValueAsString(grunnlag);
        System.out.println(json);

        GrunnlagDto roundTripped = READER.forType(GrunnlagDto.class).readValue(json);

        assertThat(roundTripped).isNotNull();

        try (var factory = Validation.buildDefaultValidatorFactory()) {
            var validator = factory.getValidator();
            var violations = validator.validate(roundTripped);
            assertThat(violations).isEmpty();
        }

    }
}
