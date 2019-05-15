package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Marker interface for ytelser som har blitt utbetalt
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kodeverk", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = UtbetaltYtelseFraOffentligeType.class, name = UtbetaltYtelseFraOffentligeType.KODEVERK),
        @JsonSubTypes.Type(value = UtbetaltPensjonTrygdType.class, name = UtbetaltPensjonTrygdType.KODEVERK),
        @JsonSubTypes.Type(value = UtbetaltNæringsYtelseType.class, name = UtbetaltNæringsYtelseType.KODEVERK),
})
public interface UtbetaltYtelseType {

}
