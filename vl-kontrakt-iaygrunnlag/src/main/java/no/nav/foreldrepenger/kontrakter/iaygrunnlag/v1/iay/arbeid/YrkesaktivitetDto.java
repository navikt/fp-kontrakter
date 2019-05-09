package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.Aktør;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.Periode;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
public class YrkesaktivitetDto {

    @JsonProperty("arbeidsgiver")
    @Valid
    private Aktør arbeidsgiver;

    @JsonProperty("arbeidsforholdId")
    @Valid
    private ArbeidsforholdRefDto arbeidsforholdId;

    @JsonProperty("arbeidType")
    @Valid
    @NotNull
    private ArbeidTypeDto arbeidType;

    @JsonProperty("ansettelsesPerioder")
    @Valid
    private List<Periode> ansettelsesPerioder;

    @JsonProperty("aktivitetsAvtaler")
    @Valid
    private List<AktivitetsAvtaleDto> aktivitetsAvtaler;

    @JsonProperty("permisjoner")
    @Valid
    private List<PermisjonDto> permisjoner;

    protected YrkesaktivitetDto() {
        // default ctor
    }

    public YrkesaktivitetDto(Aktør arbeidsgiver, ArbeidTypeDto arbeidType) {
        Objects.requireNonNull(arbeidsgiver, "arbeidsgiver");
        Objects.requireNonNull(arbeidType, "arbeidType");
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidType = arbeidType;
    }

    public YrkesaktivitetDto(Aktør arbeidsgiver, String arbeidType) {
        Objects.requireNonNull(arbeidsgiver, "arbeidsgiver");
        Objects.requireNonNull(arbeidType, "arbeidType");
        this.arbeidsgiver = arbeidsgiver;
        this.arbeidType = new ArbeidTypeDto(arbeidType);
    }
    
    @AssertTrue(message = "Må ha minst en av ansettelsesPerioder, aktivitetsAvtaler eller permisjoner")
    private boolean isOk() {
        boolean ok = (ansettelsesPerioder != null && !ansettelsesPerioder.isEmpty())
            || (aktivitetsAvtaler != null && !aktivitetsAvtaler.isEmpty())
            || (permisjoner != null && !permisjoner.isEmpty());
        return ok;
    }

    public Aktør getArbeidsgiver() {
        return arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdId() {
        return arbeidsforholdId;
    }

    public void setArbeidsforholdId(ArbeidsforholdRefDto arbeidsforholdId) {
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidTypeDto getType() {
        return arbeidType;
    }

    public List<Periode> getAnsettelsesperiode() {
        return ansettelsesPerioder;
    }

    public void setAnsettelsesperiode(List<Periode> ansettelsesperiode) {
        this.ansettelsesPerioder = ansettelsesperiode;
    }

    public YrkesaktivitetDto medAnsettelsesperiode(List<Periode> ansettelsesperiode) {
        this.ansettelsesPerioder = ansettelsesperiode;
        return this;
    }

    public List<AktivitetsAvtaleDto> getAktivitetsAvtaler() {
        return aktivitetsAvtaler;
    }

    public void setAktivitetsAvtaler(List<AktivitetsAvtaleDto> aktivitetsAvtaler) {
        this.aktivitetsAvtaler = aktivitetsAvtaler;
    }

    public YrkesaktivitetDto medAktivitetsAvtaler(List<AktivitetsAvtaleDto> aktivitetsAvtaler) {
        this.aktivitetsAvtaler = aktivitetsAvtaler;
        return this;
    }

    public List<PermisjonDto> getPermisjoner() {
        return permisjoner;
    }

    public void setPermisjoner(List<PermisjonDto> permisjoner) {
        this.permisjoner = permisjoner;
    }

    public YrkesaktivitetDto medPermisjoner(List<PermisjonDto> permisjoner) {
        this.permisjoner = permisjoner;
        return this;
    }
}
