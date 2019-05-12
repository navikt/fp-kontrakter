package no.nav.foreldrepenger.kontrakter.iaygrunnlag.kodeverk;

/** Plugin interface som kan benyttes sammen en jackson parser for å validere kodeverk lokalt ifht. hva som er støttet. */
public interface KodeValidator {
    
    /** Happy, happy, happy ♬- I'm a happy validator. ♬  🎸 */
    KodeValidator HAPPY_VALIDATOR = new KodeValidator() {

        @Override
        public String valider(String kodeverk, String kode) {
            return null; // ingenting er feil, alt er lov
        }
    };

    /** Return null hvis Ok, ellers feilmelding. */
    String valider(String kodeverk, String kode);
}
