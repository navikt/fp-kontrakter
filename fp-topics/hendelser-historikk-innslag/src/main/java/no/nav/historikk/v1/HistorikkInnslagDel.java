package no.nav.historikk.v1;

import java.util.ArrayList;
import java.util.List;

public class HistorikkInnslagDel {

    private Long id;
    private List<HistorikkInnslagFelt> historikkinnslagFelt = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<HistorikkInnslagFelt> getHistorikkinnslagFelt() {
        return historikkinnslagFelt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static HistorikkInnslagDel.Builder builder(HistorikkInnslagDel del) {
        return new Builder(del);
    }

    public static class Builder {
        private HistorikkInnslagDel kladd;


        private Builder() {
            this(new HistorikkInnslagDel());
        }


        public Builder(HistorikkInnslagDel del) {
            kladd = del;
        }

        public Builder medId(Long id) {
            kladd.id = id;
            return this;
        }

        public Builder medHistorikkInnslagFelter(List<HistorikkInnslagFelt> historikkInnslagFelter) {
            if (kladd.historikkinnslagFelt == null) {
                kladd.historikkinnslagFelt = historikkInnslagFelter;
            } else if (historikkInnslagFelter != null) {
                kladd.historikkinnslagFelt.addAll(historikkInnslagFelter);
            }
            return this;
        }

        public Builder leggTilFelt(HistorikkInnslagFelt felt) {
            kladd.historikkinnslagFelt.add(felt);
            return this;
        }

        public HistorikkInnslagDel build() {
            return kladd;
        }
    }

}
