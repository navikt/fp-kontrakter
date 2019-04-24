package no.nav.vedtak.ytelse;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Desimaltall {

    @JsonProperty("verdi")
    private BigDecimal verdi;

    public Desimaltall(BigDecimal verdi) {
        setVerdi(verdi);
    }

    public BigDecimal getVerdi() {
        return verdi;
    }

    public void setVerdi(BigDecimal verdi) {
        if (verdi != null) {
            this.verdi = verdi.setScale(2, RoundingMode.HALF_UP);
        }
    }
}
