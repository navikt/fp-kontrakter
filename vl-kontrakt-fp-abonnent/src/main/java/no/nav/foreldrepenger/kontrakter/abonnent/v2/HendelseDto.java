package no.nav.foreldrepenger.kontrakter.abonnent.v2;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.DødHendelseDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.DødfødselHendelseDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.FødselHendelseDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl.UtflyttingHendelseDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = FødselHendelseDto.class, name = FødselHendelseDto.HENDELSE_TYPE),
        @JsonSubTypes.Type(value = DødHendelseDto.class, name = DødHendelseDto.HENDELSE_TYPE),
        @JsonSubTypes.Type(value = DødfødselHendelseDto.class, name = DødfødselHendelseDto.HENDELSE_TYPE),
        @JsonSubTypes.Type(value = UtflyttingHendelseDto.class, name = UtflyttingHendelseDto.HENDELSE_TYPE)
})
public abstract class HendelseDto {

    @NotNull
    @Pattern(regexp = "^[a-zA-ZæøåÆØÅ_\\-0-9]*")
    @Size(min = 1, max = 100)
    private String id; // unik per hendelse

    @NotNull
    @Valid
    private Endringstype endringstype;

    public HendelseDto() { // NOSONAR
        // Jackson
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Endringstype getEndringstype() {
        return endringstype;
    }

    public void setEndringstype(Endringstype endringstype) {
        this.endringstype = endringstype;
    }

    public abstract String getAvsenderSystem();

    public abstract String getHendelsetype();

    public abstract List<String> getAlleAktørId();

}
