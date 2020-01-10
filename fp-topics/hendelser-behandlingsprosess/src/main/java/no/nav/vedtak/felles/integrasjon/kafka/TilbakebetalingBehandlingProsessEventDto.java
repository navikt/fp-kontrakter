package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class TilbakebetalingBehandlingProsessEventDto extends BehandlingProsessEventDto {
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate førsteFeilutbetaling;
    private BigDecimal feilutbetaltBeløp;


    public LocalDate getFørsteFeilutbetaling() {
        return førsteFeilutbetaling;
    }

    public BigDecimal getFeilutbetaltBeløp() {
        return feilutbetaltBeløp;
    }

    public static TilbakebetalingBehandlingProsessEventDto.Builder tilbakebetalingBuilder() {
        return new TilbakebetalingBehandlingProsessEventDto.Builder();
    }

    public static class Builder {

        private TilbakebetalingBehandlingProsessEventDto tmpDto;

        private Builder() {
            tmpDto = new TilbakebetalingBehandlingProsessEventDto();
            tmpDto.fagsystem = Fagsystem.FPTILBAKE;
        }

        public Builder medFørsteFeilutbetaling(LocalDate førsteFeilutbetaling) {
            tmpDto.førsteFeilutbetaling = førsteFeilutbetaling;
            return this;
        }

        public Builder medFeilutbetaltBeløp(BigDecimal feilutbetaltBeløp) {
            tmpDto.feilutbetaltBeløp = feilutbetaltBeløp;
            return this;
        }

        public Builder medEksternId(UUID eksternId) {
            tmpDto.eksternId = eksternId;
            return this;
        }

        public Builder medEventTid(LocalDateTime eventTid) {
            tmpDto.eventTid = eventTid;
            return this;
        }

        public Builder medSaksnummer(String saksnummer) {
            tmpDto.saksnummer = saksnummer;
            return this;
        }

        public Builder medAktørId(String aktørId) {
            tmpDto.aktørId = aktørId;
            return this;
        }

        public Builder medEventHendelse(EventHendelse eventHendelse) {
            tmpDto.eventHendelse = eventHendelse;
            return this;
        }

        public Builder medBehandlingStatus(String behandlingStatus) {
            tmpDto.behandlingStatus = behandlingStatus;
            return this;
        }

        public Builder medBehandlingSteg(String behandlingSteg) {
            tmpDto.behandlingSteg = behandlingSteg;
            return this;
        }

        public Builder medBehandlendeEnhet(String behandlendeEnhet) {
            tmpDto.behandlendeEnhet = behandlendeEnhet;
            return this;
        }

        public Builder medYtelseTypeKode(String ytelseTypeKode) {
            tmpDto.ytelseTypeKode = ytelseTypeKode;
            return this;
        }

        public Builder medBehandlingTypeKode(String behandlingTypeKode) {
            tmpDto.behandlingTypeKode = behandlingTypeKode;
            return this;
        }

        public Builder medOpprettetBehandling(LocalDateTime opprettetBehandling) {
            tmpDto.opprettetBehandling = opprettetBehandling;
            return this;
        }

        public Builder medAksjonspunktKoderMedStatusListe(Map<String, String> aksjonspunktKoderMedStatusListe) {
            tmpDto.aksjonspunktKoderMedStatusListe = aksjonspunktKoderMedStatusListe;
            return this;
        }

        public TilbakebetalingBehandlingProsessEventDto build() {
            return tmpDto;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TilbakebetalingBehandlingProsessEventDto that = (TilbakebetalingBehandlingProsessEventDto) o;
        return Objects.equals(førsteFeilutbetaling, that.førsteFeilutbetaling) &&
                Objects.equals(feilutbetaltBeløp, that.feilutbetaltBeløp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), førsteFeilutbetaling, feilutbetaltBeløp);
    }
}
