package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import javax.validation.constraints.AssertTrue;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kodeverk", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ArbeidsforholdHandlingTypeDto.class, name = ArbeidsforholdHandlingTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = ArbeidskategoriDto.class, name = ArbeidskategoriDto.KODEVERK),
        @JsonSubTypes.Type(value = ArbeidTypeDto.class, name = ArbeidTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = Fagsystem.class, name = Fagsystem.KODEVERK),
        @JsonSubTypes.Type(value = InntektPeriodeTypeDto.class, name = InntektPeriodeTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = InntektsKildeDto.class, name = InntektsKildeDto.KODEVERK),
        @JsonSubTypes.Type(value = InntektsmeldingInnsendingsårsakDto.class, name = InntektsmeldingInnsendingsårsakDto.KODEVERK),
        @JsonSubTypes.Type(value = InntektspostTypeDto.class, name = InntektspostTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = LandkoderDto.class, name = LandkoderDto.KODEVERK),
        @JsonSubTypes.Type(value = NaturalytelseTypeDto.class, name = NaturalytelseTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = OrganisasjonstypeDto.class, name = OrganisasjonstypeDto.KODEVERK),
        @JsonSubTypes.Type(value = PermisjonsbeskrivelseTypeDto.class, name = PermisjonsbeskrivelseTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = YtelseStatus.class, name = YtelseStatus.KODEVERK),
        @JsonSubTypes.Type(value = SkatteOgAvgiftsregelTypeDto.class, name = SkatteOgAvgiftsregelTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = UtsettelseÅrsakDto.class, name = TemaUnderkategoriDto.KODEVERK),
        @JsonSubTypes.Type(value = VirksomhetTypeDto.class, name = VirksomhetTypeDto.KODEVERK),
        @JsonSubTypes.Type(value = YtelseType.class, name = YtelseType.KODEVERK),
})
public abstract class Kodeverk {

    @JacksonInject
    private KodeValidator kodeValidator;

    protected Kodeverk() {
        // default ctor
    }

    /** Kode for angitt kodeverk. Gyldige verdier og validering er per kodeverk klasse. */
    public abstract String getKode();

    /** Kodeverk - må matche kodeverk property generert for klassen. */
    public abstract String getKodeverk();

    @AssertTrue
    private boolean isOk() {
        return kodeValidator.valider(getKodeverk(), getKode()) == null;
    }
}
