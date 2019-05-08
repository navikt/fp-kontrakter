package no.nav.historikk.v1;

import no.nav.historikk.HistorikkInnslag;
import no.nav.historikk.kodeverk.HistorikkAktør;
import no.nav.historikk.kodeverk.HistorikkInnslagType;
import no.nav.historikk.kodeverk.NavBrukerKjønn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HistorikkInnslagV1 extends HistorikkInnslag {

    private Long id;
    private Long behandlingId;
    private Long fagsakId;
    private HistorikkAktør aktør = HistorikkAktør.UDEFINERT;
    private HistorikkInnslagType type = HistorikkInnslagType.UDEFINIERT;
    private List<HistorikkInnslagDokumentLink> dokumentLinker = new ArrayList<>();
    private List<HistorikkInnslagDel> historikkinnslagDeler = new ArrayList<>();
    private NavBrukerKjønn kjoenn = NavBrukerKjønn.UDEFINERT;

    public Long getId() {
        return id;
    }

    public Long getBehandlingId() {
        return behandlingId;
    }

    public HistorikkAktør getAktør() {
        return Objects.equals(HistorikkAktør.UDEFINERT, aktør) ? null : aktør;
    }

    public HistorikkInnslagType getType() {
        return type;
    }

    public List<HistorikkInnslagDokumentLink> getDokumentLinker() {
        return dokumentLinker;
    }

    public NavBrukerKjønn getKjoenn() {
        return kjoenn;
    }

    public Long getFagsakId() {
        return fagsakId;
    }

    public List<HistorikkInnslagDel> getHistorikkinnslagDeler() {
        return historikkinnslagDeler;
    }

    public static class Builder {
        private HistorikkInnslagV1 historikkinnslag;

        public Builder() {
            historikkinnslag = new HistorikkInnslagV1();
        }

        public Builder medBehandlingId(Long behandlingId) {
            historikkinnslag.behandlingId = behandlingId;
            return this;
        }

        public Builder medFagsakId(Long fagsakId) {
            historikkinnslag.fagsakId = fagsakId;
            return this;
        }

        public Builder medAktør(HistorikkAktør historikkAktør) {
            historikkinnslag.aktør = historikkAktør;
            return this;
        }

        public Builder medType(HistorikkInnslagType type) {
            historikkinnslag.type = type;
            return this;
        }

        public Builder medKjoenn(NavBrukerKjønn kjoenn) {
            historikkinnslag.kjoenn = kjoenn;
            return this;
        }

        public Builder medDokumentLinker(List<HistorikkInnslagDokumentLink> dokumentLinker) {
            if (historikkinnslag.dokumentLinker == null) {
                historikkinnslag.dokumentLinker = dokumentLinker;
            } else if (dokumentLinker != null) {
                historikkinnslag.dokumentLinker.addAll(dokumentLinker);
            }
            return this;
        }

        public Builder medHistorikkInnslagDeler(List<HistorikkInnslagDel> historikkInnslagDeler) {
            if (historikkinnslag.historikkinnslagDeler == null) {
                historikkinnslag.historikkinnslagDeler = historikkInnslagDeler;
            } else if (historikkInnslagDeler != null) {
                historikkinnslag.historikkinnslagDeler.addAll(historikkInnslagDeler);
            }
            return this;
        }

        public HistorikkInnslagV1 build() {
            return historikkinnslag;
        }
    }
}
