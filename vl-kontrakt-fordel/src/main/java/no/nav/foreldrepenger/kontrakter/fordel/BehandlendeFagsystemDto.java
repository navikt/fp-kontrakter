package no.nav.foreldrepenger.kontrakter.fordel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

import java.util.Optional;

public class BehandlendeFagsystemDto {
    private boolean behandlesIVedtaksløsningen;
    private boolean sjekkMotInfotrygd;
    private boolean manuellVurdering;


    @Valid
    @JsonProperty
    private SaksnummerDto saksnummerDto;

    public BehandlendeFagsystemDto(String saksnummer) {
        this(new SaksnummerDto(saksnummer));
    }

    public BehandlendeFagsystemDto(SaksnummerDto saksnummerDto) {
        this.saksnummerDto = saksnummerDto;
    }

    public BehandlendeFagsystemDto() {  // For Jackson
    }

    public boolean isBehandlesIVedtaksløsningen() {
        return behandlesIVedtaksløsningen;
    }

    public void setBehandlesIVedtaksløsningen(boolean behandlesIVedtaksløsningen) {
        this.behandlesIVedtaksløsningen = behandlesIVedtaksløsningen;
    }

    public boolean isSjekkMotInfotrygd() {
        return sjekkMotInfotrygd;
    }

    public void setSjekkMotInfotrygd(boolean sjekkMotInfotrygd) {
        this.sjekkMotInfotrygd = sjekkMotInfotrygd;
    }

    public boolean isManuellVurdering() {
        return manuellVurdering;
    }

    public void setManuellVurdering(boolean manuellVurdering) {
        this.manuellVurdering = manuellVurdering;
    }

    @JsonIgnore
    public Optional<String> getSaksnummer() {
        return Optional.ofNullable(saksnummerDto).map(SaksnummerDto::saksnummer);
    }

}
