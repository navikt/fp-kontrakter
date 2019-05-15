package no.nav.historikk.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import no.nav.historikk.kodeverk.HistorikkInnslagFeltTypeEnum;
import no.nav.historikk.kodeverk.Kodeverk;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HistorikkInnslagFelt {

    @NotNull
    @Valid
    @JsonProperty
    private HistorikkInnslagFeltTypeEnum feltType;

    @JsonProperty
    private String navnVerdi;
    @JsonProperty
    private String navnFeltKode;
    @JsonProperty
    private String navnFeltKodeverk;

    @JsonProperty
    private String fraVerdi;
    @JsonProperty
    private String fraVerdiKode;
    @JsonProperty
    private String fraVerdiFeltKodeverk;

    @JsonProperty
    private String tilVerdi;
    @JsonProperty
    private String tilVerdiKode;
    @JsonProperty
    private String tilVerdiFeltKodeverk;

    @JsonProperty
    private Integer sekvensNr;

    protected HistorikkInnslagFelt() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public HistorikkInnslagFeltTypeEnum getFeltType() {
        return feltType;
    }

    public String getNavnFeltKode() {
        return navnFeltKode;
    }

    public String getNavnVerdi() {
        return navnVerdi;
    }

    public String getNavnFeltKodeverk() {
        return navnFeltKodeverk;
    }

    public String getFraVerdi() {
        return fraVerdi == null ? fraVerdiKode : fraVerdi;
    }

    public String getTilVerdi() {
        return tilVerdi == null ? tilVerdiKode : tilVerdi;
    }

    public String getFraVerdiFeltKodeverk() {
        return fraVerdiFeltKodeverk;
    }

    public String getTilVerdiFeltKodeverk() {
        return tilVerdiFeltKodeverk;
    }

    public Integer getSekvensNr() {
        return sekvensNr;
    }

    public static class Builder {
        private HistorikkInnslagFelt kladd;

        private Builder() {
            kladd = new HistorikkInnslagFelt();
        }

        public Builder medFeltType(HistorikkInnslagFeltTypeEnum feltType) {
            kladd.feltType = feltType;
            return this;
        }

        public Builder medNavnVerdi(String navnVerdi) {
            kladd.navnVerdi = navnVerdi;
            return this;
        }

        public <K extends Kodeverk> Builder medNavnKode(K kodeliste) {
            if (kodeliste != null) {
                kladd.navnFeltKode = kodeliste.getKode();
                kladd.navnFeltKodeverk = kodeliste.getKodeverk();
            } else {
                kladd.navnFeltKode = null;
            }
            return this;
        }

        public Builder medFraVerdi(String fraVerdi) {
            kladd.fraVerdi = fraVerdi;
            return this;
        }

        public <K extends Kodeverk> Builder medFraVerdiKode(K fraVerdi) {
            if (fraVerdi != null) {
                kladd.fraVerdiKode = fraVerdi.getKode();
                kladd.fraVerdiFeltKodeverk = fraVerdi.getKodeverk();
            } else {
                kladd.fraVerdiKode = null;
            }
            return this;
        }

        public Builder medTilVerdi(String tilVerdi) {
            kladd.tilVerdi = tilVerdi;
            return this;
        }

        public <K extends Kodeverk> Builder medTilVerdiKode(K tilVerdi) {
            if (tilVerdi != null) {
                kladd.tilVerdiKode = tilVerdi.getKode();
                kladd.tilVerdiFeltKodeverk = tilVerdi.getKodeverk();
            } else {
                kladd.tilVerdiKode = null;
            }
            return this;
        }

        public Builder medSekvensNr(Integer sekvensNr) {
            kladd.sekvensNr = sekvensNr;
            return this;
        }

        public HistorikkInnslagFelt build(HistorikkInnslagDel.Builder historikkinnslagDelBuilder) {
            historikkinnslagDelBuilder.leggTilFelt(kladd);
            return kladd;
        }
    }
}