package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArbeidsforholdRefDto {

    @JsonProperty(value = "internReferanse", required = true, index = 0)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String internReferanse;

    @JsonProperty(value = "eksternReferanse", index = 1)
    @Pattern(regexp = "^[\\p{L}\\p{N}_.-]+$")
    private String eksternReferanse;

    public ArbeidsforholdRefDto(String internReferanse, String eksternReferanse) {
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
