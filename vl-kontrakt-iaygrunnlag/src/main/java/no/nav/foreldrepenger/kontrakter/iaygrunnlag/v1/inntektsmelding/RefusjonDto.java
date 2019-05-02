package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.inntektsmelding;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RefusjonDto {
    private BigDecimal refusjonsbeløpMnd;
    private LocalDate fom;

    public RefusjonDto() {
    }

    public BigDecimal getRefusjonsbeløpMnd() {
        return refusjonsbeløpMnd;
    }

    public void setRefusjonsbeløpMnd(BigDecimal refusjonsbeløpMnd) {
        this.refusjonsbeløpMnd = refusjonsbeløpMnd;
    }

    public LocalDate getFom() {
        return fom;
    }

    public void setFom(LocalDate fom) {
        this.fom = fom;
    }
}
