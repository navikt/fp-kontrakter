package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

public class ArbeidsgiverDto {
    private String identifikator;
    private ArbeidsgiverType type;

    public ArbeidsgiverDto(String identifikator, ArbeidsgiverType type) {
        this.identifikator = identifikator;
        this.type = type;
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public void setIdentifikator(String identifikator) {
        this.identifikator = identifikator;
    }

    public ArbeidsgiverType getType() {
        return type;
    }

    public void setType(ArbeidsgiverType type) {
        this.type = type;
    }
}
