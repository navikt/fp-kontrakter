package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeid.v1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.PermisjonsbeskrivelseType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class PermisjonDto {

    @JsonProperty(value = "periode", required = true)
    @NotNull
    @Valid
    private Periode periode;

    /** Permisjon type, hvis oppgitt. Kan være null. */
    @JsonProperty(value = "type", required = true)
    @Valid
    private PermisjonsbeskrivelseType type;

    /**
     * Prosent sats med to desimaler - min 0.00 - 100.00.
     * Pga inntastingfeil og manglende validering i LPS systemer og Altinn har man historisk akseptert mottatt permisjonsprosenter langt over
     * 100%. C'est la vie.
     */
    @JsonProperty("prosentsats")
    @Valid
    @DecimalMin(value = "0.00", message = "permisjon prosentsats ${validatedValue} må være >= {value}")
    @DecimalMax(value = "500.00", message = "permisjon prosentsats ${validatedValue} må være <= {value}") // insane maks verdi, men Aa-reg sier så
    private BigDecimal prosentsats;

    protected PermisjonDto() {
    }

    public PermisjonDto(@NotNull @Valid Periode periode, @NotNull @Valid PermisjonsbeskrivelseType type) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
        this.type = type;
    }

    public Periode getPeriode() {
        return periode;
    }

    public PermisjonsbeskrivelseType getType() {
        return type;
    }

    public BigDecimal getProsentsats() {
        return prosentsats;
    }

    public void setProsentsats(BigDecimal prosentsats) {
        this.prosentsats = prosentsats == null ? null : prosentsats.setScale(2, RoundingMode.HALF_UP);
    }

    public PermisjonDto medProsentsats(BigDecimal prosentsats) {
        setProsentsats(prosentsats);
        return this;
    }

    public PermisjonDto medProsentsats(int prosentsats) {
        setProsentsats(BigDecimal.valueOf(prosentsats));
        return this;
    }

}
