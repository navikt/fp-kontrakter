package no.nav.vedtak.hendelser.inntektsmelding;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import no.nav.vedtak.hendelser.inntektsmelding.v1.InntektsmeldingV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = InntektsmeldingV1.class, name = "1.0"),
})
public abstract class DokumentHendelse {

    public abstract Aktør getAktørId();

    public abstract String getHendelse();

    public abstract String getJournalpostId();

    public abstract String getSaksnummer();

    public abstract LocalDateTime getInnsendingsTidspunkt();
}
