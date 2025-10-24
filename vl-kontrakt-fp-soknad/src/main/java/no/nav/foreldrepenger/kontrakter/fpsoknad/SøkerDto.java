package no.nav.foreldrepenger.kontrakter.fpsoknad;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

import static no.nav.foreldrepenger.kontrakter.fpsoknad.validering.InputValideringRegex.FRITEKST;

/**
 * Denne informasjonen hentes fra PDL, AAREG og EEREG ved inngangen til søknadsdialogen vidersendes med resten av søknaden.
 * Vi brukes ikke denne informasjonen i XML, men i PDF for å vise bruker navn og arbeidsforhold som ble vist på søknadstidspunktet.
 * Ved saksbehandling vil vi uansett slå opp denne informasjonen på nytt, og derfor ikke behov for å sende inn i XMLen.
 */
public record SøkerDto(@Valid @NotNull Fødselsnummer fnr, @Valid @NotNull Navn navn, @Size(max = 50) List<@NotNull Arbeidsforhold> arbeidsforhold) {

    public record Arbeidsforhold(String navn, Orgnummer orgnummer, Double stillingsprosent, LocalDate fom, LocalDate tom) {
    }

    public record Navn(@NotNull @Pattern(regexp = FRITEKST) String fornavn, @Pattern(regexp = FRITEKST) String mellomnavn, @NotNull @Pattern(regexp = FRITEKST) String etternavn) {
        @Override
        public String toString() {
            return "Navn{" + "fornavn='*****', mellomnavn='*****', etternavn='*****'}";
        }
    }
}
