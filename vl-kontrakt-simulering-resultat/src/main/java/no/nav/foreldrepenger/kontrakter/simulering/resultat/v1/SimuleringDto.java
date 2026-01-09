package no.nav.foreldrepenger.kontrakter.simulering.resultat.v1;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.Fagområde;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.MottakerType;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.RadId;

public record SimuleringDto(@NotNull DetaljertSimuleringResultatDto simuleringResultat,
                            DetaljertSimuleringResultatDto simuleringResultatUtenInntrekk,
                            @NotNull boolean slåttAvInntrekk) {


    public record DetaljertSimuleringResultatDto(@NotNull PeriodeDto periode, @NotNull boolean ingenPerioderMedAvvik,
                                                 @NotNull Long sumEtterbetaling, @NotNull Long sumFeilutbetaling,
                                                 @NotNull Long sumInntrekk,
                                                 @NotNull List<SimuleringForMottakerDto> perioderPerMottaker) {
    }


    public record SimuleringForMottakerDto(@NotNull MottakerType mottakerType, @NotNull String mottakerNummer,
                                           @NotNull String mottakerIdentifikator,
                                           @NotNull List<SimuleringResultatPerFagområdeDto> resultatPerFagområde,
                                           @NotNull List<SimuleringResultatRadDto> resultatOgMotregningRader,
                                           @NotNull PeriodeDto nesteUtbPeriode) {
    }


    public record SimuleringResultatPerFagområdeDto(@NotNull Fagområde fagOmrådeKode,
                                                    @NotNull List<SimuleringResultatRadDto> rader) {
    }

    public record SimuleringResultatRadDto(@NotNull RadId feltnavn,
                                           @NotNull List<SimuleringResultatPerMånedDto> resultaterPerMåned) {
    }

    public record SimuleringResultatPerMånedDto(@NotNull PeriodeDto periode, @NotNull Long beløp) {
    }
}
