package no.nav.foreldrepenger.kontrakter.fpsoknad.opptjening;

import com.neovisionaries.i18n.CountryCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Orgnummer;

import java.time.LocalDate;

import static no.nav.foreldrepenger.kontrakter.fpsoknad.validering.InputValideringRegex.FRITEKST;

public record NæringDto(@Valid @NotNull LocalDate fom,
                        @Valid LocalDate tom,
                        @Valid @NotNull Virksomhetstype næringstype,
                        @Pattern(regexp = FRITEKST) String navnPåNæringen,
                        @Valid Orgnummer organisasjonsnummer,
                        @Digits(integer = 9, fraction = 0) Integer næringsinntekt,
                        @NotNull boolean registrertINorge,
                        CountryCode registrertILand,
                        Boolean harBlittYrkesaktivILøpetAvDeTreSisteFerdigliknedeÅrene,
                        LocalDate oppstartsdato,
                        Boolean hattVarigEndringAvNæringsinntektSiste4Kalenderår,
                        LocalDate varigEndringDato,
                        @Digits(integer = 9, fraction = 0) Integer varigEndringInntektEtterEndring,
                        @Pattern(regexp = FRITEKST) String varigEndringBeskrivelse) {

    @AssertTrue(message = "Søker har oppgitt varig endring men varigEndringDato, varigEndringInntektEtterEndring og varigEndringBeskrivelse er ikke"
        + " satt")
    public boolean isVarigEndringGyldig() {
        if (Boolean.TRUE.equals(hattVarigEndringAvNæringsinntektSiste4Kalenderår)) {
            return varigEndringDato != null && varigEndringInntektEtterEndring != null && varigEndringBeskrivelse != null;
        }
        return true;
    }

    public enum Virksomhetstype {
        ANNEN,
        JORDBRUK_SKOGBRUK,
        FISKE,
        DAGMAMMA
    }
}
