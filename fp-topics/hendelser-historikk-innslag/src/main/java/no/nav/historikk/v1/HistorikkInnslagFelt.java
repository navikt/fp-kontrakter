package no.nav.historikk.v1;


import no.nav.historikk.kodeverk.HistorikkInnslagFeltType;
import no.nav.historikk.kodeverk.Kodeverk;

public class HistorikkInnslagFelt {

    private Long id;

    private HistorikkInnslagFeltType feltType;

    private String navn;

    private String navnVerdi;

    private String fraVerdi;

    private String tilVerdi;

    private String fraVerdiKode;

    private String tilVerdiKode;

    private String klFraVerdi;

    private String klTilVerdi;

    private String klNavn;

    private Integer sekvensNr;

    protected HistorikkInnslagFelt() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public HistorikkInnslagFeltType getFeltType() {
        return feltType;
    }

    public String getNavn() {
        return navn;
    }

    public String getNavnVerdi() {
        return navnVerdi;
    }

    public String getKlNavn() {
        return klNavn;
    }

    public String getFraVerdi() {
        return fraVerdi == null ? fraVerdiKode : fraVerdi;
    }

    public String getTilVerdi() {
        return tilVerdi == null ? tilVerdiKode : tilVerdi;
    }

    public String getKlFraVerdi() {
        return klFraVerdi;
    }

    public String getKlTilVerdi() {
        return klTilVerdi;
    }

    public Integer getSekvensNr() {
        return sekvensNr;
    }

    public static class Builder {
        private HistorikkInnslagFelt kladd;

        private Builder() {
            kladd = new HistorikkInnslagFelt();
        }

        public Builder medId(Long id) {
            kladd.id = id;
            return this;
        }


        public Builder medFeltType(HistorikkInnslagFeltType feltType) {
            kladd.feltType = feltType;
            return this;
        }

        public Builder medNavnVerdi(String navnVerdi) {
            kladd.navnVerdi = navnVerdi;
            return this;
        }

        public Builder medNavn(Kodeverk kodeliste) {
            kladd.navn = kodeliste.getKode();
            kladd.klNavn = kodeliste.getKodeverk();
            return this;
        }

        public Builder medFraVerdi(String fraVerdi) {
            kladd.fraVerdi = fraVerdi;
            return this;
        }

        public Builder medFraVerdi(Kodeverk fraVerdi) {
            if (fraVerdi != null) {
                kladd.fraVerdiKode = fraVerdi.getKode();
                kladd.klFraVerdi = fraVerdi.getKodeverk();
            } else {
                kladd.fraVerdiKode = null;
            }
            return this;
        }

        public Builder medTilVerdi(String tilVerdi) {
            kladd.tilVerdi = tilVerdi;
            return this;
        }

        public <K extends Kodeverk> Builder medTilVerdi(K tilVerdi) {
            if (tilVerdi != null) {
                kladd.tilVerdiKode = tilVerdi.getKode();
                kladd.klTilVerdi = tilVerdi.getKodeverk();
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