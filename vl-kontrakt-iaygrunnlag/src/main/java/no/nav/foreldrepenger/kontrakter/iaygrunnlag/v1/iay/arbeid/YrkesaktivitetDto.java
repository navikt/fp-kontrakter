package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.ArbeidTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsforholdRefDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.ArbeidsgiverDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class YrkesaktivitetDto {

    private ArbeidsgiverDto arbeidsgiver;
    private ArbeidsforholdRefDto arbeidsforholdId;
    private ArbeidTypeDto type;
    private List<PeriodeDto> ansettelsesperiode;
    private List<AktivitetsAvtaleDto> aktivitetsAvtaler;
    private List<PermisjonDto> permisjoner;

    public YrkesaktivitetDto() {
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

    public List<AktivitetsAvtaleDto> getAktivitetsAvtaler() {
        return aktivitetsAvtaler;
    }

    public void setAktivitetsAvtaler(List<AktivitetsAvtaleDto> aktivitetsAvtaler) {
        this.aktivitetsAvtaler = aktivitetsAvtaler;
    }

    public List<PermisjonDto> getPermisjoner() {
        return permisjoner;
    }

    public void setPermisjoner(List<PermisjonDto> permisjoner) {
        this.permisjoner = permisjoner;
    }
}
