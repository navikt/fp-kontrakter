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
        @JsonSubTypes.Type(value = ArbeidsforholdHandlingType.class, name = ArbeidsforholdHandlingType.KODEVERK),
        @JsonSubTypes.Type(value = Arbeidskategori.class, name = Arbeidskategori.KODEVERK),
        @JsonSubTypes.Type(value = ArbeidType.class, name = ArbeidType.KODEVERK),
        @JsonSubTypes.Type(value = Fagsystem.class, name = Fagsystem.KODEVERK),
        @JsonSubTypes.Type(value = InntektPeriodeType.class, name = InntektPeriodeType.KODEVERK),
        @JsonSubTypes.Type(value = InntektskildeType.class, name = InntektskildeType.KODEVERK),
        @JsonSubTypes.Type(value = InntektsmeldingInnsendingsårsakType.class, name = InntektsmeldingInnsendingsårsakType.KODEVERK),
        @JsonSubTypes.Type(value = InntektspostType.class, name = InntektspostType.KODEVERK),
        @JsonSubTypes.Type(value = Landkode.class, name = Landkode.KODEVERK),
        @JsonSubTypes.Type(value = NaturalytelseType.class, name = NaturalytelseType.KODEVERK),
        @JsonSubTypes.Type(value = OrganisasjonType.class, name = OrganisasjonType.KODEVERK),
        @JsonSubTypes.Type(value = PermisjonsbeskrivelseType.class, name = PermisjonsbeskrivelseType.KODEVERK),
        @JsonSubTypes.Type(value = YtelseStatus.class, name = YtelseStatus.KODEVERK),
        @JsonSubTypes.Type(value = SkatteOgAvgiftsregelType.class, name = SkatteOgAvgiftsregelType.KODEVERK),
        @JsonSubTypes.Type(value = UtsettelseÅrsakType.class, name = TemaUnderkategori.KODEVERK),
        @JsonSubTypes.Type(value = VirksomhetType.class, name = VirksomhetType.KODEVERK),
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