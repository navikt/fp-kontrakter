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

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.Periode;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.PersonIdent;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.UuidDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.YtelseType;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_ABSENT, content = Include.NON_EMPTY)
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE)
public class InnhentRegisterdataRequest {

    private static final String URL_PATTERN = "/^(?:(?:https?):\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\." +
            "\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})" +
            "(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d" +
            "|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:" +
            "[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$/i\n";

    /**
     * Saksnummer alle grunnlag og koblinger er linket til.
     */
    @JsonProperty(value = "saksnummer", required = true)
    @NotNull
    @Valid
    private String saksnummer;

    @JsonProperty(value = "referanse", required = true)
    @Valid
    @NotNull
    private UuidDto referanse;

    @JsonProperty(value = "ytelseType", required = true)
    @Valid
    @NotNull
    private YtelseType ytelseType;

    @JsonProperty(value = "opplysningsperiode", required = true)
    @NotNull
    @Valid
    private Periode opplysningsperiode;

    @JsonProperty(value = "aktør", required = true)
    @NotNull
    @Valid
    private PersonIdent aktør;

    @JsonProperty(value = "annenPartAktør")
    @Valid
    private PersonIdent annenPartAktør;

    @JsonProperty(value = "opptjeningsperiode")
    @Valid
    private Periode opptjeningsperiode;

    @JsonProperty(value = "callbackUrl")
    @Valid
    @Pattern(regexp = URL_PATTERN, message="callbackUrl '${validatedValue}' matcher ikke tillatt url pattern '{regexp}'")
    private String callbackUrl;

    @JsonCreator
    public InnhentRegisterdataRequest(@JsonProperty(value = "saksnummer", required = true) @Valid @NotNull String saksnummer,
                                      @JsonProperty(value = "referanse", required = true) @Valid @NotNull UuidDto referanse,
                                      @JsonProperty(value = "ytelseType", required = true) @Valid @NotNull YtelseType ytelseType,
                                      @JsonProperty(value = "opplysningsperiode", required = true) @NotNull @Valid Periode opplysningsperiode,
                                      @JsonProperty(value = "aktør", required = true) @NotNull @Valid PersonIdent aktør) {
        this.saksnummer = saksnummer;
        this.referanse = referanse;
        this.ytelseType = ytelseType;
        this.opplysningsperiode = opplysningsperiode;
        this.aktør = aktør;
    }

    public String getReferanse() {
        return referanse.getReferanse();
    }

    public PersonIdent getAktør() {
        return aktør;
    }

    public PersonIdent getAnnenPartAktør() {
        return annenPartAktør;
    }

    public void setAnnenPartAktør(PersonIdent annenPartAktør) {
        this.annenPartAktør = annenPartAktør;
    }

    public Periode getOpplysningsperiode() {
        return opplysningsperiode;
    }

    public Periode getOpptjeningsperiode() {
        return opptjeningsperiode;
    }

    public void setOpptjeningsperiode(Periode opptjeningsperiode) {
        this.opptjeningsperiode = opptjeningsperiode;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public YtelseType getYtelseType() {
        return ytelseType;
    }

    public String getSaksnummer() {
        return saksnummer;
    }
}
