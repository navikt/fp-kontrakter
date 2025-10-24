package no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.annenpart;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.constraints.NotNull;
import no.nav.foreldrepenger.kontrakter.fpsoknad.Fødselsnummer;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = NorskForelderDto.class, name = "norsk"), @JsonSubTypes.Type(value = UtenlandskForelderDto.class, name = "utenlandsk")})
public interface AnnenForelderDto {
    Fødselsnummer fnr();

    Rettigheter rettigheter();

    record Rettigheter(@NotNull Boolean harRettPåForeldrepenger,
                       Boolean erInformertOmSøknaden,
                       Boolean erAleneOmOmsorg,
                       Boolean harMorUføretrygd,
                       Boolean harAnnenForelderOppholdtSegIEØS,
                       Boolean harAnnenForelderTilsvarendeRettEØS) {
    }
}
