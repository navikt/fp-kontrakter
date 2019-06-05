package no.nav.foreldrepenger.kontrakter.iaygrunnlag.arbeidsforhold.v1;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.BekreftetPermisjonStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class BekreftetPermisjon {
    
    @JsonProperty(value = "status")
    @NotNull
    @Valid
    private BekreftetPermisjonStatus status;

    @JsonProperty("periode")
    @Valid
    @NotNull
    private Periode periode;

    @JsonCreator
    public BekreftetPermisjon(@JsonProperty("periode") @Valid @NotNull Periode periode, 
                              @JsonProperty(value = "status") @Valid @NotNull BekreftetPermisjonStatus status) {
        Objects.requireNonNull(periode, "periode");
        this.periode = periode;
        this.status = status;
    }

    public BekreftetPermisjon(LocalDate permisjonFom, LocalDate permisjonTom, BekreftetPermisjonStatus status) {
        this(new Periode(permisjonFom, permisjonTom), status);
    }

    public Periode getPeriode() {
        return periode;
    }

    public BekreftetPermisjonStatus getBekreftetPermisjonStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        BekreftetPermisjon that = (BekreftetPermisjon) o;
        return Objects.equals(periode, that.periode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periode);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<" +
            "periode=" + periode +
            ", status=" + status+
            '>';
    }

}
