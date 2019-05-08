package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.arbeid;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.PermisjonsbeskrivelseTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
public class PermisjonDto {

    @Valid
    private PeriodeDto periode;
    
    @Valid
    private PermisjonsbeskrivelseTypeDto type;
    
    /** Prosent sats med to desimaler - min 0.00 - 100.00. */
    @JsonProperty("prosentsats")
    @Valid
    @DecimalMin(value="0.00", message = "prosentsats >= 0.00")
    @DecimalMax(value="500.00", message="prosentsats < 500.00") // insane maks verdi, men Aa-reg sier så
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
