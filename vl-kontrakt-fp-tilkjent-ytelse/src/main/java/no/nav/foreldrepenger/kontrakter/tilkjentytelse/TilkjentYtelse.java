package no.nav.foreldrepenger.kontrakter.tilkjentytelse;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import no.nav.foreldrepenger.kontrakter.tilkjentytelse.v1.TilkjentYtelseV1;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "version")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TilkjentYtelseV1.class, name = "1.0"),
})
public interface TilkjentYtelse {
}
