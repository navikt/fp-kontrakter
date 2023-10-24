package no.nav.foreldrepenger.kontrakter.fpwsproxy.simulering.request;

import com.fasterxml.jackson.annotation.JsonValue;

public enum KodeKlassifik {

    //Engangsstønad fødsel
    ES_FØDSEL("FPENFOD-OP"),
    //Engangsstønad adopsjon
    ES_ADOPSJON("FPENAD-OP"),

    //Feriepenger både FP adopsjon, fødsel og SVP
    FERIEPENGER_BRUKER("FPATFER"), // Bruker - Feriepenger - fp/svp.
    //Feriepenger til bruker for PSB, PPN, OMP, OLP
    FERIEPENGER_BRUKER_SP("SPATFER"), // Bruker - Feriepenger - k9.
    // Feriepenger til arbeidsgiver for PSB, PPN, OMP, OLP
    FERIEPENGER_REFUSJON_SP("SPREFAGFERPP-IOP"), // Arbeidsgiver - Feriepenger - k9.

    //Fødsel
    FPF_ARBEIDSTAKER("FPATORD"), // FP (foreldrepenger), AT - arbeidstaker, ORD - ordinær
    FPF_FRILANSER("FPATFRI"),
    FPF_SELVSTENDIG("FPSND-OP"),
    FPF_DAGPENGER("FPATAL"),
    FPF_SJØMANN("FPATSJO"),
    FPF_DAGMAMMA("FPSNDDM-OP"),
    FPF_JORDBRUKER("FPSNDJB-OP"),
    FPF_FISKER("FPSNDFI"),
    FPF_REFUSJON_AG("FPREFAG-IOP"), //FP (foreldrepenger), REFAG - arbeidsgiver
    FPF_FERIEPENGER_AG("FPREFAGFER-IOP"), // Arbeidsgiver - Feriepenger

    //Adopsjon
    FPA_ARBEIDSTAKER("FPADATORD"), // FP (foreldrepenger), AD - adopsjon, AT - arbeidstaker, ORD - ordinær
    FPA_FRILANSER("FPADATFRI"),
    FPA_SELVSTENDIG("FPADSND-OP"),
    FPA_DAGPENGER("FPADATAL"),
    FPA_SJØMANN("FPADATSJO"),
    FPA_DAGMAMMA("FPADSNDDM-OP"),
    FPA_JORDBRUKER("FPADSNDJB-OP"),
    FPA_FISKER("FPADSNDFI"),
    FPA_REFUSJON_AG("FPADREFAG-IOP"), //FP (foreldrepenger), AD - adopsjon, REFAG - arbeidsgiver
    FPA_FERIEPENGER_AG("FPADREFAGFER-IOP"), // Arbeidsgiver - Feriepenger

    //Svangerskapsenger
    SVP_ARBEDISTAKER("FPSVATORD"), // FPSV (svangerskapsenger), AT - arbeidstaker, ORD - ordinær
    SVP_FRILANSER("FPSVATFRI"),
    SVP_SELVSTENDIG("FPSVSND-OP"),
    SVP_DAGPENGER("FPSVATAL"),
    SVP_SJØMANN("FPSVATSJO"),
    SVP_DAGMAMMA("FPSVSNDDM-OP"),
    SVP_JORDBRUKER("FPSVSNDJB-OP"),
    SVP_FISKER("FPSVSNDFI"),
    SVP_REFUSJON_AG("FPSVREFAG-IOP"), //FPSV (svangerskapsenger), REFAG - arbeidsgiver
    SVP_FERIEPENGER_AG("FPSVREFAGFER-IOP"), // Arbeidsgiver - Feriepenger

    //Pleiepenger sykt barn
    PSB_ARBEDISTAKER("PNBSATORD"), // PNBS (pleiepenger sykt barn), AT - arbeidstaker, ORD - ordinær
    PSB_FRILANSER("PNBSATFRI"),
    PSB_SELVSTENDIG("PNBSSND-OP"),
    PSB_DAGPENGER("PNBSATAL"),
    PSB_SJØMANN("PNBSATSJO"),
    PSB_DAGMAMMA("PNBSSNDDM-OP"),
    PSB_JORDBRUKER("PNBSSNDJB-OP"),
    PSB_FISKER("PNBSSNDFI"),
    PSB_REFUSJON_AG("PNBSREFAG-IOP"), //PNBS (pleiepenger sykt barn), REFAG - arbeidsgiver

    //Pleiepenger i livets sluttfase (tidligere Pleiepenger nærstående)
    PPN_ARBEDISTAKER("PPNPATORD"), // PPNP (pleiepenger i livets sluttfase), AT - arbeidstaker, ORD - ordinær
    PPN_FRILANSER("PPNPATFRI"),
    PPN_SELVSTENDIG("PPNPSND-OP"),
    PPN_DAGPENGER("PPNPATAL"),
    PPN_SJØMANN("PPNPATSJO"),
    PPN_DAGMAMMA("PPNPSNDDM-OP"),
    PPN_JORDBRUKER("PPNPSNDJB-OP"),
    PPN_FISKER("PPNPSNDFI"),
    PPN_REFUSJON_AG("PPNPREFAG-IOP"), //PPNP (pleiepenger i livets sluttfase), REFAG - arbeidsgiver

    //Omsorgspenger
    OMP_ARBEDISTAKER("OMATORD"), // OM (omsorgspenger), AT - arbeidstaker, ORD - ordinær
    OMP_FRILANSER("OMATFRI"),
    OMP_SELVSTENDIG("OMSND-OP"),
    OMP_DAGPENGER("OMATAL"),
    OMP_SJØMANN("OMATSJO"),
    OMP_DAGMAMMA("OMSNDDM-OP"),
    OMP_JORDBRUKER("OMSNDJB-OP"),
    OMP_FISKER("OMSNDFI"),
    OMP_REFUSJON_AG("OMREFAG-IOP"), //OM (omsorgspenger), REFAG - arbeidsgiver

    //Opplæringspenger
    OLP_ARBEDISTAKER("OPPATORD"), // OPP (opplæringspenger), AT - arbeidstaker, ORD - ordinær
    OLP_FRILANSER("OPPATFRI"),
    OLP_SELVSTENDIG("OPPSND-OP"),
    OLP_DAGPENGER("OPPATAL"),
    OLP_SJØMANN("OPPATSJO"),
    OLP_DAGMAMMA("OPPSNDDM-OP"),
    OLP_JORDBRUKER("OPPSNDJB-OP"),
    OLP_FISKER("OPPSNDFI"),
    OLP_REFUSJON_AG("OPPREFAG-IOP"), //OPP (opplæringspenger), REFAG - arbeidsgiver

    //kompenasasjon for koronatiltak for Selvstendig næringsdrivende og Frilansere (Anmodning 10)
    FRISINN_FRILANS("FRISINN-FRILANS"),
    FRISINN_SN("FRISINN-SELVST-OP"),
    ;

    @JsonValue
    private final String kode;

    KodeKlassifik(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }
}
