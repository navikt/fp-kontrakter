package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

import java.util.Objects;

import javax.validation.constraints.AssertTrue;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
        @JsonSubTypes.Type(value = UtbetaltYtelseFraOffentligeType.class, name = UtbetaltYtelseFraOffentligeType.KODEVERK),
        @JsonSubTypes.Type(value = UtbetaltPensjonTrygdType.class, name = UtbetaltPensjonTrygdType.KODEVERK),
        @JsonSubTypes.Type(value = UtbetaltNæringsYtelseType.class, name = UtbetaltNæringsYtelseType.KODEVERK),
})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public abstract class Kodeverk {

    @JacksonInject
    private KodeValidator kodeValidator;

    protected Kodeverk() {
        // default ctor
    }

    /**
     * Kode for angitt kodeverk. Gyldige verdier og validering er per kodeverk klasse.
     */
    public abstract String getKode();

    /**
     * Kodeverk - må matche kodeverk property generert for klassen.
     */
    public abstract String getKodeverk();

    @AssertTrue
    private boolean isOk() {
        return kodeValidator.valider(getKodeverk(), getKode()) == null;
    }
    @Override
    public String toString() {
        return getKodeverk() +"<"+ getKode() + ">";
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==this)return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        var other = getClass().cast(obj);
        return Objects.equals(this.getKode(), other.getKode())
                && Objects.equals(this.getKodeverk(), other.getKodeverk());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getKode(), getKodeverk());
    }
}
