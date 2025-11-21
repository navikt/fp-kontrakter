package no.nav.foreldrepenger.kontrakter.felles.validering;

public class InputValideringRegex {

    public static final String BARE_TALL = "^[\\p{Digit}]*$";
    public static final String BARE_BOKSTAVER = "^[\\p{L}]*$";
    public static final String BOKSTAVER_MED_MELLOMROM = "^[\\p{L}\\p{Space}]*$";
    public static final String NORSK_FØDSELSNUMMER = "^[\\p{Digit}]{11}+$";
    public static final String ORGNUMMER = "^[\\p{Digit}]{9}+$";
    public static final String FRITEKST = "^[\\p{M}\\p{N}\\p{L}\\p{Z}\\p{Cf}\\p{P}\\p{Sc}\\p{Sk}\n\r\t+=]*$";
}
