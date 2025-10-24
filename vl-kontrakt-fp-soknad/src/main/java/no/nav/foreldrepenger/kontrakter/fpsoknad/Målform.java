package no.nav.foreldrepenger.kontrakter.fpsoknad;

public enum Målform {
    NB,
    NN,
    EN,
    E;

    public static Målform standard() {
        return NB;
    }
}
