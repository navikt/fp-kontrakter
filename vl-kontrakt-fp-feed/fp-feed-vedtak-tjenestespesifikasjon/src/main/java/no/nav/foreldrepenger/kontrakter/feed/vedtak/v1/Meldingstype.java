package no.nav.foreldrepenger.kontrakter.feed.vedtak.v1;


import java.util.Arrays;

@SuppressWarnings("rawtypes")
public enum Meldingstype {
    FORELDREPENGER_INNVILGET("ForeldrepengerInnvilget_v1", ForeldrepengerInnvilget.class),
    FORELDREPENGER_ENDRET("ForeldrepengerEndret_v1", ForeldrepengerEndret.class),
    FORELDREPENGER_OPPHOERT("ForeldrepengerOpphoert_v1", ForeldrepengerOpphoert.class),
    SVANGERSKAPSPENGER_INNVILGET("SVPInnvilget_v1", SvangerskapspengerInnvilget.class),
    SVANGERSKAPSPENGER_ENDRET("SVPEndret_v1", SvangerskapspengerEndret.class),
    SVANGERSKAPSPENGER_OPPHOERT("SVPOpphoert_v1", SvangerskapspengerOpphoert.class);

    private Class meldingsDto;
    private String type;

    Meldingstype(String type, Class meldingsDto) {
        this.meldingsDto = meldingsDto;
        this.type = type;
    }
    
    @SuppressWarnings("unchecked")
    public <V extends Innhold> Class<V> getMeldingsDto() {
        return meldingsDto;
    }
    
    public String getType() {
        return type;
    }

    public static Meldingstype valueOf(Class aClass) {
        return Arrays.stream(values())
                .filter(e-> e.getMeldingsDto().equals(aClass))
                .findFirst().orElse(null);
    }
    
    public static Meldingstype fromType(String type) {
        return Arrays.stream(values())
                .filter(e-> e.getType().equals(type))
                .findFirst().orElse(null);
    }
}