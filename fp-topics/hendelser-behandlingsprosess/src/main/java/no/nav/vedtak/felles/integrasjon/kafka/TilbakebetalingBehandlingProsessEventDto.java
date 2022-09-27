package no.nav.vedtak.felles.integrasjon.kafka;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;

public class TilbakebetalingBehandlingProsessEventDto extends BehandlingProsessEventDto {

    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate førsteFeilutbetaling;
    private BigDecimal feilutbetaltBeløp;
    private String ansvarligSaksbehandlerIdent;
    private String ansvarligBeslutterIdent;

    public TilbakebetalingBehandlingProsessEventDto() {
    }

    public LocalDate getFørsteFeilutbetaling() {
        return førsteFeilutbetaling;
    }

    public BigDecimal getFeilutbetaltBeløp() {
        return feilutbetaltBeløp;
    }

    public String getAnsvarligSaksbehandlerIdent() {
        return ansvarligSaksbehandlerIdent;
    }

    public String getAnsvarligBeslutterIdent() {
        return ansvarligBeslutterIdent;
    }

    protected TilbakebetalingBehandlingProsessEventDto(Builder<?> builder) {
        super(builder);
        this.førsteFeilutbetaling = builder.førsteFeilutbetaling;
        this.feilutbetaltBeløp = builder.feilutbetaltBeløp;
        this.ansvarligSaksbehandlerIdent = builder.ansvarligSaksbehandlerIdent;
        this.ansvarligBeslutterIdent = builder.ansvarligBeslutterIdent;
    }

    public static abstract class Builder<T extends Builder<T>> extends BehandlingProsessEventDto.Builder<T> {
        private LocalDate førsteFeilutbetaling;
        private BigDecimal feilutbetaltBeløp;
        private String ansvarligSaksbehandlerIdent;
        private URL href;
        public String ansvarligBeslutterIdent;

        public T medFørsteFeilutbetaling(LocalDate førsteFeilutbetaling) {
            this.førsteFeilutbetaling = førsteFeilutbetaling;
            return self();
        }

        public T medFeilutbetaltBeløp(BigDecimal feilutbetaltBeløp) {
            this.feilutbetaltBeløp = feilutbetaltBeløp;
            return self();
        }

        public T medAnsvarligSaksbehandlerIdent(String saksbehandlerIdent) {
            this.ansvarligSaksbehandlerIdent = saksbehandlerIdent;
            return self();
        }

        public T medAnsvarligBeslutterIdent(String ident) {
            this.ansvarligBeslutterIdent = ident;
            return self();
        }

        public TilbakebetalingBehandlingProsessEventDto build() {
            return new TilbakebetalingBehandlingProsessEventDto(this);
        }
    }

    private static class BuilderImpl extends Builder<BuilderImpl> {
        @Override
        protected BuilderImpl self() {
            return this;
        }
    }

    public static Builder<?> builder() {
        return new BuilderImpl();
    }
}
