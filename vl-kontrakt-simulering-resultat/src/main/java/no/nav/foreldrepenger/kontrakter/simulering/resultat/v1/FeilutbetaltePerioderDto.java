package no.nav.foreldrepenger.kontrakter.simulering.resultat.v1;

import java.util.List;

// Convention: sumFeilutbetaling >= 0
public record FeilutbetaltePerioderDto(Long sumFeilutbetaling, List<PeriodeDto> perioder) { }
