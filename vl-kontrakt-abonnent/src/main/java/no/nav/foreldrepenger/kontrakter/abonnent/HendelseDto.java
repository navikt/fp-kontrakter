package no.nav.foreldrepenger.kontrakter.abonnent;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import no.nav.foreldrepenger.kontrakter.abonnent.tps.DødHendelseDto;
import no.nav.foreldrepenger.kontrakter.abonnent.tps.DødfødselHendelseDto;
import no.nav.foreldrepenger.kontrakter.abonnent.tps.FødselHendelseDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FødselHendelseDto.class, name = FødselHendelseDto.HENDELSE_TYPE),
        @JsonSubTypes.Type(value = DødHendelseDto.class, name = DødHendelseDto.HENDELSE_TYPE),
        @JsonSubTypes.Type(value = DødfødselHendelseDto.class, name = DødfødselHendelseDto.HENDELSE_TYPE)
})
public abstract class HendelseDto {

    @NotNull
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*")
    @Size(min = 1, max = 100)
    private String id; // unik per hendelse

    public HendelseDto() {
        // Jackson
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getAvsenderSystem();

    public abstract String getHendelsetype();

    public abstract List<String> getAlleAktørId();

}
