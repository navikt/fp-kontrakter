package no.nav.vedtak.felles.integrasjon.kafka;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class FpsakBehandlingProsessEventDto extends BehandlingProsessEventDto {

    private Long behandlingId; // fjernes etter overgang til eksternId

    public Long getBehandlingId() {
        return behandlingId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private FpsakBehandlingProsessEventDto tmpDto;

        private Builder() {
            tmpDto = new FpsakBehandlingProsessEventDto();
            tmpDto.fagsystem = Fagsystem.FPSAK;
        }

        public Builder medEksternId(UUID eksternId) {
            tmpDto.eksternId = eksternId;
            return this;
        }

        public Builder medBehandlingId(Long behandlingId) {
            tmpDto.behandlingId = behandlingId;
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

        public FpsakBehandlingProsessEventDto build() {
            return tmpDto;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FpsakBehandlingProsessEventDto that = (FpsakBehandlingProsessEventDto) o;
        return Objects.equals(behandlingId, that.behandlingId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), behandlingId);
    }
}
