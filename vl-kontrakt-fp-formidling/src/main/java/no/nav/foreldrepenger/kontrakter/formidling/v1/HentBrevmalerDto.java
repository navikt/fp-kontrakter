package no.nav.foreldrepenger.kontrakter.formidling.v1;

import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * TODO: Team Onyx - Dette trenges til fpsak er brukt som proxy for Fpsak-frontend.
 * Må slettes når fpsak-frontend kaller fpformidling direkt.
 */
public class HentBrevmalerDto {
    @NotNull
    private List<BrevmalDto> brevmalDtoListe;

    public HentBrevmalerDto() {
    }

    public HentBrevmalerDto(List<BrevmalDto> brevmalDtoListe) {
        this.brevmalDtoListe = brevmalDtoListe;
    }

    public List<BrevmalDto> getBrevmalDtoListe() {
        return brevmalDtoListe;
    }
}
