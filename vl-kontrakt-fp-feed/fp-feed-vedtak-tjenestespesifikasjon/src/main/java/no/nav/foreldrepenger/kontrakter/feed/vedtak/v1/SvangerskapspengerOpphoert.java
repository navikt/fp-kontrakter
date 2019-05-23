package no.nav.foreldrepenger.kontrakter.feed.vedtak.v1;

import java.time.LocalDate;
import java.util.Objects;

public class SvangerskapspengerOpphoert extends Innhold {

    public SvangerskapspengerOpphoert() {
        super();
    }

    private SvangerskapspengerOpphoert(SvangerskapspengerOpphoert.Builder builder) {
        this.setAktoerId(builder.aktoerId);
        this.setFoersteStoenadsdag(builder.foersteStoenadsdag);
        this.setSisteStoenadsdag(builder.sisteStoenadsdag);
        this.setGsakId(builder.gsakId);
    }

    public static class Builder {
        private String aktoerId;

        private LocalDate foersteStoenadsdag;

        private LocalDate sisteStoenadsdag;

        private String gsakId;

        public SvangerskapspengerOpphoert.Builder medAktoerId(String val) {
            aktoerId = val;
            return this;
        }

        public SvangerskapspengerOpphoert.Builder medFoersteStoenadsdag(LocalDate foersteStoenadsdag) {
            this.foersteStoenadsdag = foersteStoenadsdag;
            return this;
        }

        public SvangerskapspengerOpphoert.Builder medSisteStoenadsdag(LocalDate sisteStoenadsdag) {
            this.sisteStoenadsdag = sisteStoenadsdag;
            return this;
        }

        public SvangerskapspengerOpphoert.Builder medGsakId(String gsakId) {
            this.gsakId = gsakId;
            return this;
        }

        public SvangerskapspengerOpphoert build() {
            Objects.requireNonNull(aktoerId, "aktoerId"); //$NON-NLS-1$
            Objects.requireNonNull(foersteStoenadsdag, "foersteStoenadsdag"); //$NON-NLS-1$
            return new SvangerskapspengerOpphoert(this);
        }
    }
}
