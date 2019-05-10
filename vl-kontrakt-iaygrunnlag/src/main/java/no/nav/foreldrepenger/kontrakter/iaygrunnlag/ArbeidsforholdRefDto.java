package no.nav.foreldrepenger.kontrakter.iaygrunnlag;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArbeidsforholdRefDto {

    @JsonProperty(value = "internReferanse", required = true, index = 0)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    private String internReferanse;

    @JsonProperty(value = "eksternReferanse", index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_\\.\\-]+$")
    private String eksternReferanse;

    @JsonCreator
    public ArbeidsforholdRefDto(@JsonProperty(value = "internReferanse", required = true, index = 0) String internReferanse,
                                @JsonProperty(value = "eksternReferanse", index = 1) String eksternReferanse) {
        this.internReferanse = internReferanse;
        this.eksternReferanse = eksternReferanse;
    }

    public String getInternReferanse() {
        return internReferanse;
    }

    public String getEksternReferanse() {
        return eksternReferanse;
    }

}
