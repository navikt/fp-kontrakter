package no.nav.foreldrepenger.kontrakter.simulering.resultat.v1;

import java.util.List;

import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.Fagområde;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.MottakerType;
import no.nav.foreldrepenger.kontrakter.simulering.resultat.kodeverk.RadId;

public record SimuleringDto(DetaljertSimuleringResultatDto simuleringResultat,
                            DetaljertSimuleringResultatDto simuleringResultatUtenInntrekk,
                            boolean slåttAvInntrekk) {


    public record DetaljertSimuleringResultatDto(PeriodeDto periode, boolean ingenPerioderMedAvvik,
                                                 Long sumEtterbetaling, Long sumFeilutbetaling, Long sumInntrekk,
                                                 List<SimuleringForMottakerDto> perioderPerMottaker) {
    }


    public record SimuleringForMottakerDto(MottakerType mottakerType, String mottakerNummer, String mottakerIdentifikator,
                                           List<SimuleringResultatPerFagområdeDto> resultatPerFagområde,
                                           List<SimuleringResultatRadDto> resultatOgMotregningRader,
                                           PeriodeDto nesteUtbPeriode) {
    }


    public record SimuleringResultatPerFagområdeDto(Fagområde fagOmrådeKode, List<SimuleringResultatRadDto> rader) { }

    public record SimuleringResultatRadDto(RadId feltnavn, List<SimuleringResultatPerMånedDto> resultaterPerMåned) { }

    public record SimuleringResultatPerMånedDto(PeriodeDto periode, Long beløp) { }
}
