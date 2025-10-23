package no.nav.foreldrepenger.kontrakter.fpsoknad.builder;

import no.nav.foreldrepenger.kontrakter.fpsoknad.BrukerRolle;
import no.nav.foreldrepenger.kontrakter.fpsoknad.EndringssøknadForeldrepengerDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Målform;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Saksnummer;
import no.nav.foreldrepenger.kontrakter.fpsoknad.SøkerDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.BarnDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.annenpart.AnnenForelderDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.UttaksplanDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.Uttaksplanperiode;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class EndringssøknadBuilder {
    private LocalDateTime mottattdato;
    private Saksnummer saksnummer;
    private SøkerDto søkerinfo;
    private BrukerRolle rolle;
    private Målform språkkode;
    private BarnDto barn;
    private AnnenForelderDto annenForelder;
    private UttaksplanDto uttaksplan;
    private List<VedleggDto> vedlegg;

    public EndringssøknadBuilder(Saksnummer saksnummer) {
        this.saksnummer = saksnummer;
        this.språkkode = Målform.standard();
    }

    public EndringssøknadBuilder medMottattdato(LocalDate mottattdato) {
        this.mottattdato = LocalDateTime.of(mottattdato, LocalTime.now());
        return this;
    }

    public EndringssøknadBuilder medMottattdato(LocalDateTime mottattdato) {
        this.mottattdato = mottattdato;
        return this;
    }

    public EndringssøknadBuilder medRolle(BrukerRolle rolle) {
        this.rolle = rolle;
        return this;
    }

    public EndringssøknadBuilder medSøkerinfo(SøkerDto søkerinfo) {
        this.søkerinfo = søkerinfo;
        return this;
    }

    public EndringssøknadBuilder medSpråkkode(Målform språkkode) {
        this.språkkode = språkkode;
        return this;
    }

    public EndringssøknadBuilder medBarn(BarnDto barn) {
        this.barn = barn;
        return this;
    }

    public EndringssøknadBuilder medAnnenForelder(AnnenForelderDto annenForelder) {
        this.annenForelder = annenForelder;
        return this;
    }

    public EndringssøknadBuilder medUttaksplan(UttaksplanDto uttaksplan) {
        this.uttaksplan = uttaksplan;
        return this;
    }

    public EndringssøknadBuilder medUttaksplan(List<Uttaksplanperiode> uttaksplanperiodeer) {
        this.uttaksplan = new UttaksplanDto(null, uttaksplanperiodeer);
        return this;
    }

    public EndringssøknadBuilder medVedlegg(List<VedleggDto> vedlegg) {
        this.vedlegg = vedlegg;
        return this;
    }

    public EndringssøknadForeldrepengerDto build() {
        if (mottattdato == null) {
            mottattdato = LocalDateTime.now();
        }
        return new EndringssøknadForeldrepengerDto(mottattdato, saksnummer, søkerinfo, rolle, språkkode, barn, annenForelder, uttaksplan , vedlegg);
    }
}
