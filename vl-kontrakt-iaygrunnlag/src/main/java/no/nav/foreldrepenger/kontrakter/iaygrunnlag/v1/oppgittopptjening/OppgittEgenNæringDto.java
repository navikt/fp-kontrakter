package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.oppgittopptjening;

import java.math.BigDecimal;
import java.time.LocalDate;

import no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk.VirksomhetTypeDto;
import no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay.PeriodeDto;

public class OppgittEgenNæringDto {
    private PeriodeDto periode;
    private String orgnr;
    private VirksomhetTypeDto virksomhetTypeDto;
    private String regnskapsførerNavn;
    private String regnskapsførerTlf;
    private LocalDate endringDato;
    private String begrunnelse;
    private BigDecimal bruttoInntekt;
    private boolean nyoppstartet;
    private boolean varigEndring;
    private boolean nærRelasjon;
    private boolean nyIArbeidslivet;
    private OppgittUtenlandskVirksomhetDto oppgittUtenlandskVirksomhet;

    public OppgittEgenNæringDto() {
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public VirksomhetTypeDto getVirksomhetTypeDto() {
        return virksomhetTypeDto;
    }

    public void setVirksomhetTypeDto(VirksomhetTypeDto virksomhetTypeDto) {
        this.virksomhetTypeDto = virksomhetTypeDto;
    }

    public String getRegnskapsførerNavn() {
        return regnskapsførerNavn;
    }

    public void setRegnskapsførerNavn(String regnskapsførerNavn) {
        this.regnskapsførerNavn = regnskapsførerNavn;
    }

    public String getRegnskapsførerTlf() {
        return regnskapsførerTlf;
    }

    public void setRegnskapsførerTlf(String regnskapsførerTlf) {
        this.regnskapsførerTlf = regnskapsførerTlf;
    }

    public LocalDate getEndringDato() {
        return endringDato;
    }

    public void setEndringDato(LocalDate endringDato) {
        this.endringDato = endringDato;
    }

    public String getBegrunnelse() {
        return begrunnelse;
    }

    public void setBegrunnelse(String begrunnelse) {
        this.begrunnelse = begrunnelse;
    }

    public BigDecimal getBruttoInntekt() {
        return bruttoInntekt;
    }

    public void setBruttoInntekt(BigDecimal bruttoInntekt) {
        this.bruttoInntekt = bruttoInntekt;
    }

    public boolean isNyoppstartet() {
        return nyoppstartet;
    }

    public void setNyoppstartet(boolean nyoppstartet) {
        this.nyoppstartet = nyoppstartet;
    }

    public boolean isVarigEndring() {
        return varigEndring;
    }

    public void setVarigEndring(boolean varigEndring) {
        this.varigEndring = varigEndring;
    }

    public boolean isNærRelasjon() {
        return nærRelasjon;
    }

    public void setNærRelasjon(boolean nærRelasjon) {
        this.nærRelasjon = nærRelasjon;
    }

    public boolean isNyIArbeidslivet() {
        return nyIArbeidslivet;
    }

    public void setNyIArbeidslivet(boolean nyIArbeidslivet) {
        this.nyIArbeidslivet = nyIArbeidslivet;
    }

    public OppgittUtenlandskVirksomhetDto getOppgittUtenlandskVirksomhet() {
        return oppgittUtenlandskVirksomhet;
    }

    public void setOppgittUtenlandskVirksomhet(OppgittUtenlandskVirksomhetDto oppgittUtenlandskVirksomhet) {
        this.oppgittUtenlandskVirksomhet = oppgittUtenlandskVirksomhet;
    }
}
