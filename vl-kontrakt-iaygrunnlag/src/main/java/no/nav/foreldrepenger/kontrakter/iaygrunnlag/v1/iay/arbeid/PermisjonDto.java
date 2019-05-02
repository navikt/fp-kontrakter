package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.math.BigDecimal;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.PermisjonsbeskrivelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class PermisjonDto {

    private PeriodeDto periode;
    private PermisjonsbeskrivelseTypeDto type;
    private BigDecimal prosentsats;

    public PermisjonDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public PermisjonsbeskrivelseTypeDto getType() {
        return type;
    }

    public void setType(PermisjonsbeskrivelseTypeDto type) {
        this.type = type;
    }

    public BigDecimal getProsentsats() {
        return prosentsats;
    }

    public void setProsentsats(BigDecimal prosentsats) {
        this.prosentsats = prosentsats;
    }
}
