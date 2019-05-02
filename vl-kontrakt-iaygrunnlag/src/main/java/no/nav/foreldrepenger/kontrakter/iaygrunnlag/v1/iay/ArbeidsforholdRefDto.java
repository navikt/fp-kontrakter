package no.nav.foreldrepenger.kontrakter.iaygrunnlag.v1.iay;

public class ArbeidsforholdRefDto {

    private String internReferanse;
    private String eksternReferanse;

    public ArbeidsforholdRefDto() {
    }

    public String getInternReferanse() {
        return internReferanse;
    }

    public void setInternReferanse(String internReferanse) {
        this.internReferanse = internReferanse;
    }

    public String getEksternReferanse() {
        return eksternReferanse;
    }

    public void setEksternReferanse(String eksternReferanse) {
        this.eksternReferanse = eksternReferanse;
    }
}
