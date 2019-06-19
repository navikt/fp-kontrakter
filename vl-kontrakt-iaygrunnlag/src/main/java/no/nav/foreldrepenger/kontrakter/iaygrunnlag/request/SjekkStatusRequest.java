package no.nav.foreldrepenger.kontrakter.iaygrunnlag.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE)
public class SjekkStatusRequest {

    @JsonProperty(value = "referanse", required = true)
    @Valid
    @NotNull
    private UuidDto referanse;

    @JsonProperty(value = "taskReferanse", required = true)
    @NotNull
    @Pattern(regexp = "\\d+", message="Task referanse '${validatedValue}' matcher ikke tillatt pattern '{value}'")
    private String taskReferanse;

    @JsonCreator
    public SjekkStatusRequest( @JsonProperty(value = "referanse", required = true) @Valid @NotNull UuidDto referanse, 
                           @JsonProperty(value = "taskReferanse", required = true) @NotNull @Pattern(regexp = "\\d+") String taskReferanse) {
        this.referanse = referanse;
        this.taskReferanse = taskReferanse;
    }

    public UuidDto getReferanse() {
        return referanse;
    }

    public void setReferanse(UuidDto referanse) {
        this.referanse = referanse;
    }

    public String getTaskReferanse() {
        return taskReferanse;
    }

    public void setTaskReferanse(String taskReferanse) {
        this.taskReferanse = taskReferanse;
    }

}
