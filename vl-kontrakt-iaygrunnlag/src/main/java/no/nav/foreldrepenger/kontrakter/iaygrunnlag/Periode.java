package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Periode med fom/tom dato. */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.ALWAYS)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class Periode {

    @JsonProperty(value = "fom")
    @NotNull
    private LocalDate fom;

    @JsonProperty(value = "tom")
    @NotNull
    private LocalDate tom;

    @JsonCreator
    public Periode(@JsonProperty(value = "fom") LocalDate fom, @JsonProperty(value = "tom") LocalDate tom) {
        if (fom == null && tom == null) {
            throw new IllegalArgumentException("Både fom og tom er null");
        } else if (fom != null && tom != null) {
            if (fom.isAfter(tom)) {
                throw new IllegalArgumentException("Input data gir umulig periode (fom > tom): [" + fom + ", " + tom + "]");
            }
        }
        this.fom = fom;
        this.tom = tom;
    }

    public LocalDate getFom() {
        return fom;
    }

    public LocalDate getTom() {
        return tom;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "<" + getFom() + ", " + getTom() + ">";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var other = getClass().cast(obj);
        return Objects.equals(this.getFom(), other.getFom())
            && Objects.equals(this.getTom(), other.getTom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFom(), getTom());
    }

}
