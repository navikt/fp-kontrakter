package no.nav.foreldrepenger.kontrakter.fpsoknad.builder;

import no.nav.foreldrepenger.kontrakter.fpsoknad.Målform;
import no.nav.foreldrepenger.kontrakter.fpsoknad.SvangerskapspengesøknadDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.SøkerDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.UtenlandsoppholdsperiodeDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.FødselDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.TerminDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.AnnenInntektDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.FrilansDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening.NæringDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.AvtaltFerieDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.BarnSvpDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.TilretteleggingbehovDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class SvangerskapspengerBuilder implements SøknadBuilder<EngangsstønadBuilder> {
    private LocalDateTime mottattdato;
    private SøkerDto søkerinfo;
    private Målform språkkode;
    private BarnSvpDto barnSvp;
    private FrilansDto frilans;
    private NæringDto egenNæring;
    private List<AnnenInntektDto> andreInntekterSiste10Mnd;
    private List<UtenlandsoppholdsperiodeDto> utenlandsopphold;
    private List<TilretteleggingbehovDto> tilretteleggingsbehov;
    private List<AvtaltFerieDto> avtaltFerie;
    private List<VedleggDto> vedlegg;

    public SvangerskapspengerBuilder(List<TilretteleggingbehovDto> tilretteleggingsbehov) {
        this.tilretteleggingsbehov = tilretteleggingsbehov;
        this.språkkode = Målform.standard();
    }

    public SvangerskapspengerBuilder medMottattdato(LocalDate mottattdato) {
        this.mottattdato = LocalDateTime.of(mottattdato, LocalTime.now());
        return this;
    }

    public SvangerskapspengerBuilder medMottattdato(LocalDateTime mottattdato) {
        this.mottattdato = mottattdato;
        return this;
    }

    public SvangerskapspengerBuilder medSøkerinfo(SøkerDto søkerinfo) {
        this.søkerinfo = søkerinfo;
        return this;
    }

    public SvangerskapspengerBuilder medSpråkkode(Målform språkkode) {
        this.språkkode = språkkode;
        return this;
    }

    public SvangerskapspengerBuilder medBarn(BarnDto barn) {
        if (barn instanceof FødselDto fødsel) {
            this.barnSvp = new BarnSvpDto(fødsel.termindato(), fødsel.fødselsdato());
        } else if (barn instanceof TerminDto termin) {
            this.barnSvp = new BarnSvpDto(termin.termindato(), null);
        } else {
            throw new IllegalStateException("Svangerskapspengesøknad støtter bare fødsel eller termin!");
        }
        return this;
    }

    public SvangerskapspengerBuilder medFrilansInformasjon(FrilansDto frilans) {
        this.frilans = frilans;
        return this;
    }

    public SvangerskapspengerBuilder medSelvstendigNæringsdrivendeInformasjon(NæringDto egenNæring) {
        this.egenNæring = egenNæring;
        return this;
    }

    public SvangerskapspengerBuilder medAndreInntekterSiste10Mnd(List<AnnenInntektDto> andreInntekterSiste10Mnd) {
        this.andreInntekterSiste10Mnd = andreInntekterSiste10Mnd;
        return this;
    }

    public SvangerskapspengerBuilder medUtenlandsopphold(List<UtenlandsoppholdsperiodeDto> utenlandsopphold) {
        this.utenlandsopphold = utenlandsopphold;
        return this;
    }

    public SvangerskapspengerBuilder medAvtaltFerie(List<AvtaltFerieDto> avtaltFerie) {
        this.avtaltFerie = avtaltFerie;
        return this;
    }

    public SvangerskapspengerBuilder medVedlegg(List<VedleggDto> vedlegg) {
        this.vedlegg = vedlegg;
        return this;
    }

    public SvangerskapspengesøknadDto build() {
        if (mottattdato == null) {
            mottattdato = LocalDateTime.now();
        }
        return new SvangerskapspengesøknadDto(
                mottattdato,
                søkerinfo,
                språkkode,
                barnSvp,
                frilans,
                egenNæring,
                andreInntekterSiste10Mnd,
                utenlandsopphold,
                tilretteleggingsbehov,
                avtaltFerie,
                vedlegg
        );
    }
}
