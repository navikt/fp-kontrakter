package no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TilkjentYtelseBehandlingInfoV1 {
    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    @JsonProperty(value = "aktoerId", index = 0)
    private String aktørId;
    @NotNull
    @Size(min = 1, max = 10)
    @Pattern(regexp = "^\\d*$")
    private String saksnummer;
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private long behandlingId;
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private Long forrigeBehandlingId;
    @NotNull
    private TilkjentYtelseV1.YtelseType ytelseType;
    private boolean gjelderAdopsjon;
    @NotNull
    private LocalDate vedtaksdato;
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9]*$")
    private String ansvarligSaksbehandler;

    public String getAktørId() {
        return aktørId;
    }

    public String getSaksnummer() {
        return saksnummer;
    }

    public long getBehandlingId() {
        return behandlingId;
    }

    public Long getForrigeBehandlingId() {
        return forrigeBehandlingId;
    }

    public TilkjentYtelseV1.YtelseType getYtelseType() {
        return ytelseType;
    }

    public boolean isGjelderAdopsjon() {
        return gjelderAdopsjon;
    }

    public LocalDate getVedtaksdato() {
        return vedtaksdato;
    }

    public String getAnsvarligSaksbehandler() {
        return ansvarligSaksbehandler;
    }

    public TilkjentYtelseBehandlingInfoV1 setAktørId(String aktørId) {
        this.aktørId = aktørId;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setSaksnummer(String saksnummer) {
        this.saksnummer = saksnummer;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setBehandlingId(long behandlingId) {
        this.behandlingId = behandlingId;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setForrigeBehandlingId(Long forrigeBehandlingId) {
        this.forrigeBehandlingId = forrigeBehandlingId;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setYtelseType(TilkjentYtelseV1.YtelseType ytelseType) {
        this.ytelseType = ytelseType;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setGjelderAdopsjon(boolean gjelderAdopsjon) {
        this.gjelderAdopsjon = gjelderAdopsjon;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setVedtaksdator(LocalDate vedtaksdator) {
        this.vedtaksdato = vedtaksdator;
        return this;
    }

    public TilkjentYtelseBehandlingInfoV1 setAnsvarligSaksbehandler(String ansvarligSaksbehandler) {
        this.ansvarligSaksbehandler = ansvarligSaksbehandler;
        return this;
    }

}
