package no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening;

import com.neovisionaries.i18n.CountryCode;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

import static no.nav.foreldrepenger.kontrakter.felles.validering.InputValideringRegex.FRITEKST;

public record AnnenInntektDto(@NotNull AnnenOpptjeningType type,
                              @NotNull LocalDate fom,
                              LocalDate tom,
                              CountryCode land,
                              @Pattern(regexp = FRITEKST) String arbeidsgiverNavn) {

    @AssertTrue(message = "Ved JOBB_I_UTLANDET så må land og arbeidsgiverNavn være satt")
    boolean isGyldigJobbIUtlandet() {
        if (AnnenOpptjeningType.JOBB_I_UTLANDET.equals(type)) {
            return land != null && arbeidsgiverNavn != null;
        }
        return true;
    }

    public enum AnnenOpptjeningType {
        ETTERLØNN_SLUTTPAKKE,
        ETTERLØNN_ARBEIDSGIVER,
        JOBB_I_UTLANDET,
        LØNN_UNDER_UTDANNING,
        MILITÆR_ELLER_SIVILTJENESTE,
        SLUTTPAKKE,
        VENTELØNN_VARTPENGER,
        VENTELØNN,
        VARTPENGER
    }
}
