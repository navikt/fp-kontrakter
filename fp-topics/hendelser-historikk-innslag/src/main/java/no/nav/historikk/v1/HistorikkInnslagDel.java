package no.nav.historikk.v1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_ABSENT, content = JsonInclude.Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, creatorVisibility = JsonAutoDetect.Visibility.NONE)
public class HistorikkInnslagDel {

    @NotNull
    @Valid
    @JsonProperty(value = "historikkinnslagFelt", required = true)
    private List<HistorikkInnslagFelt> historikkinnslagFelt = new ArrayList<>();

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
