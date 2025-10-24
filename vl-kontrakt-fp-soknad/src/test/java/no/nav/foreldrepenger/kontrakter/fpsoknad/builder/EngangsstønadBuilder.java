package no.nav.foreldrepenger.kontrakter.fpsoknad.builder;

import no.nav.foreldrepenger.kontrakter.fpsoknad.EngangsstønadDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Målform;
import no.nav.foreldrepenger.kontrakter.fpsoknad.SøkerDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.UtenlandsoppholdsperiodeDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


public class EngangsstønadBuilder implements SøknadBuilder<EngangsstønadBuilder> {
    private LocalDateTime mottattdato;
    private SøkerDto søkerinfo;
    private Målform språkkode;
    private BarnDto barn;
    private List<UtenlandsoppholdsperiodeDto> utenlandsopphold;
    private List<VedleggDto> vedlegg;

    public EngangsstønadBuilder() {
        this.språkkode = Målform.standard();
    }

    public EngangsstønadBuilder medMottattdato(LocalDate mottattdato) {
        this.mottattdato = LocalDateTime.of(mottattdato, LocalTime.now());
        return this;
    }

    public EngangsstønadBuilder medMottattdato(LocalDateTime mottattdato) {
        this.mottattdato = mottattdato;
        return this;
    }

    public EngangsstønadBuilder medSøkerinfo(SøkerDto søkerinfo) {
        this.søkerinfo = søkerinfo;
        return this;
    }

    public EngangsstønadBuilder medSpråkkode(Målform språkkode) {
        this.språkkode = språkkode;
        return this;
    }

    public EngangsstønadBuilder medBarn(BarnDto barn) {
        this.barn = barn;
        return this;
    }

    public EngangsstønadBuilder medUtenlandsopphold(List<UtenlandsoppholdsperiodeDto> utenlandsopphold) {
        this.utenlandsopphold = utenlandsopphold;
        return this;
    }

    public EngangsstønadBuilder medVedlegg(List<VedleggDto> vedlegg) {
        this.vedlegg = vedlegg;
        return this;
    }

    public EngangsstønadDto build() {
        if (mottattdato == null) {
            mottattdato = LocalDateTime.now();
        }
        return new EngangsstønadDto(mottattdato, søkerinfo, språkkode, barn, utenlandsopphold, vedlegg);
    }
}
