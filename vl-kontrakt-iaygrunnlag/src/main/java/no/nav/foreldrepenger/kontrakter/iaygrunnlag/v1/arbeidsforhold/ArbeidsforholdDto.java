package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.arbeidsforhold;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class ArbeidsforholdDto {

    private ArbeidsgiverDto arbeidsgiver;
    private ArbeidsforholdRefDto arbeidsforholdId;
    private ArbeidTypeDto type;
    private List<PeriodeDto> ansettelsesperiode;

    public ArbeidsforholdDto() {
    }

    public ArbeidsgiverDto getArbeidsgiver() {
        return arbeidsgiver;
    }

    public void setArbeidsgiver(ArbeidsgiverDto arbeidsgiver) {
        this.arbeidsgiver = arbeidsgiver;
    }

    public ArbeidsforholdRefDto getArbeidsforholdId() {
        return arbeidsforholdId;
    }

    public void setArbeidsforholdId(ArbeidsforholdRefDto arbeidsforholdId) {
        this.arbeidsforholdId = arbeidsforholdId;
    }

    public ArbeidTypeDto getType() {
        return type;
    }

    public void setType(ArbeidTypeDto type) {
        this.type = type;
    }

    public List<PeriodeDto> getAnsettelsesperiode() {
        return ansettelsesperiode;
    }

    public void setAnsettelsesperiode(List<PeriodeDto> ansettelsesperiode) {
        this.ansettelsesperiode = ansettelsesperiode;
    }
}
