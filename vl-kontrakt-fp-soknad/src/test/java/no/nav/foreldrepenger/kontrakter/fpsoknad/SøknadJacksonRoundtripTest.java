package no.nav.foreldrepenger.kontrakter.fpsoknad;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neovisionaries.i18n.CountryCode;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.FødselDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.barn.TerminDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.AnnenforelderBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.EndringssøknadBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.EngangsstønadBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.ForeldrepengerBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.OpptjeningMaler;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.SvangerskapspengerBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.builder.UttakplanPeriodeBuilder;
import no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.Dekningsgrad;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.ArbeidsforholdDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.svangerskapspenger.TilretteleggingbehovDto;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.DokumentTypeId;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.Dokumenterer;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.InnsendingType;
import no.nav.foreldrepenger.kontrakter.fpsoknad.vedlegg.VedleggDto;
import no.nav.vedtak.mapper.json.DefaultJsonMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.KontoType.FELLESPERIODE;
import static no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.KontoType.FORELDREPENGER_FØR_FØDSEL;
import static no.nav.foreldrepenger.kontrakter.fpsoknad.foreldrepenger.uttaksplan.KontoType.MØDREKVOTE;
import static org.assertj.core.api.Assertions.assertThat;

public class SøknadJacksonRoundtripTest {

    private static final ObjectMapper MAPPER = DefaultJsonMapper.getObjectMapper();

    @Test
    void engangsstønad_utenlandsopphold_jackson_roundtrip_test() {
        // Arrange
        var fnr = new Fødselsnummer("1234567890");
        var søknad = new EngangsstønadBuilder()
                .medSøkerinfo(new SøkerDto(fnr, new SøkerDto.Navn("Per", null, "Pål"), null))
                .medBarn(new FødselDto(2, LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1).plusWeeks(2)))
                .medUtenlandsopphold(List.of(new UtenlandsoppholdsperiodeDto(LocalDate.now().minusYears(1), LocalDate.now().minusMonths(6), CountryCode.XK)))
                .build();

        // Act
        var deseralizedSøknad = seralizeAndDeseralize(søknad);

        // Assert
        assertThat(søknad).isEqualTo(deseralizedSøknad);
    }

    @Test
    void foreldepengesoknad_med_vedlegg_jackson_roundtrip_test() {
        // Arrange
        var familehendelseDato = LocalDateTime.now().minusWeeks(1).toLocalDate();
        var fnr = new Fødselsnummer("1234567890");
        var søknad = (ForeldrepengesøknadDto) new ForeldrepengerBuilder()
                .medRolle(BrukerRolle.MOR)
                .medSøkerinfo(new SøkerDto(fnr, new SøkerDto.Navn("Per", null, null), null))
                .medBarn(new TerminDto(2, LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1).plusWeeks(2)))
                .medUttaksplan(
                        List.of(
                                UttakplanPeriodeBuilder.uttak(FORELDREPENGER_FØR_FØDSEL, familehendelseDato.minusWeeks(3), familehendelseDato.minusDays(1)).build(),
                                UttakplanPeriodeBuilder.uttak(MØDREKVOTE, familehendelseDato, familehendelseDato.plusWeeks(15).minusDays(1)).build(),
                                UttakplanPeriodeBuilder.uttak(FELLESPERIODE, familehendelseDato.plusWeeks(15), familehendelseDato.plusWeeks(31).minusDays(1)).build()
                        )
                )
                .medDekningsgrad(Dekningsgrad.HUNDRE)
                .medUtenlandsopphold(List.of())
                .medAnnenForelder(AnnenforelderBuilder.norskMedRettighetNorge(new Fødselsnummer("0987654321")).build())
                .medVedlegg(List.of(new VedleggDto(UUID.randomUUID(), DokumentTypeId.I000141, InnsendingType.LASTET_OPP, null, new Dokumenterer(Dokumenterer.DokumentererType.BARN, null, null))))
                .build();

        // Act
        var deseralizedSøknad = seralizeAndDeseralize(søknad);

        // Assert
        assertThat(søknad).isEqualTo(deseralizedSøknad);
    }

    @Test
    void svp_jackson_roundtrip_test() {
        // Arrange
        var fnr = new Fødselsnummer("1234567890");
        var tilrettelegginger = List.of(
                new TilretteleggingbehovDto(new ArbeidsforholdDto.VirksomhetDto(new Orgnummer("987654321")), LocalDate.now().minusMonths(2), null, null,
                                            List.of(
                                                    new TilretteleggingbehovDto.TilretteleggingDto.Hel(LocalDate.now().minusMonths(2)),
                                                    new TilretteleggingbehovDto.TilretteleggingDto.Del(LocalDate.now().minusMonths(1), 44.3),
                                                    new TilretteleggingbehovDto.TilretteleggingDto.Ingen(LocalDate.now().minusWeeks(2))
                                            ))
        );
        var søknad = new SvangerskapspengerBuilder(tilrettelegginger)
                .medSøkerinfo(new SøkerDto(fnr, new SøkerDto.Navn("Per", null, null), null))
                .medBarn(new TerminDto(1, LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1).plusWeeks(2)))
                .medUtenlandsopphold(List.of(new UtenlandsoppholdsperiodeDto(LocalDate.now().minusYears(1), LocalDate.now().minusMonths(6), CountryCode.XK)))
                .medFrilansInformasjon(OpptjeningMaler.frilansOpptjening())
                .medSelvstendigNæringsdrivendeInformasjon(OpptjeningMaler.egenNaeringOpptjening("123456789"))
                .build();

        // Act
        var deseralizedSøknad = seralizeAndDeseralize(søknad);

        // Assert
        assertThat(søknad).isEqualTo(deseralizedSøknad);
    }

    @Test
    void endringssøknad_foreldrepenger_jackson_roundtrip_test() {
        // Arrange
        var familehendelseDato = LocalDateTime.now().minusWeeks(1).toLocalDate();
        var fnr = new Fødselsnummer("1234567890");
        var søknad = new EndringssøknadBuilder(new Saksnummer("9292929"))
                .medRolle(BrukerRolle.MOR)
                .medSøkerinfo(new SøkerDto(fnr, new SøkerDto.Navn("Per", null, null), null))
                .medBarn(new TerminDto(2, LocalDate.now().minusMonths(1), LocalDate.now().minusMonths(1).plusWeeks(2)))
                .medUttaksplan(
                        List.of(
                                UttakplanPeriodeBuilder.uttak(FORELDREPENGER_FØR_FØDSEL, familehendelseDato.minusWeeks(3), familehendelseDato.minusDays(1)).build(),
                                UttakplanPeriodeBuilder.uttak(MØDREKVOTE, familehendelseDato, familehendelseDato.plusWeeks(15).minusDays(1)).build(),
                                UttakplanPeriodeBuilder.uttak(FELLESPERIODE, familehendelseDato.plusWeeks(15), familehendelseDato.plusWeeks(31).minusDays(1)).build()
                        )
                )
                .medAnnenForelder(AnnenforelderBuilder.norskMedRettighetNorge(new Fødselsnummer("0987654321")).build())
                .build();

        // Act
        var deseralizedSøknad = seralizeAndDeseralize(søknad);

        // Assert
        assertThat(søknad).isEqualTo(deseralizedSøknad);
    }



    public static <T> T seralizeAndDeseralize(T søknad) {
        try {
            var seralizedSøknad = MAPPER.writeValueAsBytes(søknad);
            return (T) MAPPER.readValue(seralizedSøknad, søknad.getClass());
        } catch (IOException e) {
            throw new RuntimeException("Feil ved serialisering/deserialisering av ForeldrepengesøknadDto", e);
        }
    }
}
