package no.nav.foreldrepenger.kontrakter.feed.vedtak.v1;

import java.time.LocalDate;
import java.util.Objects;

public class SvangerskapspengerEndret extends Innhold {

    public SvangerskapspengerEndret() {
        super();
    }

    private SvangerskapspengerEndret(SvangerskapspengerEndret.Builder builder) {
        this.setAktoerId(builder.aktoerId);
        this.setFnr(builder.fnr);
        this.setFoersteStoenadsdag(builder.foersteStoenadsdag);
        this.setSisteStoenadsdag(builder.sisteStoenadsdag);
        this.setGsakId(builder.gsakId);
    }

    public static class Builder {
        private String aktoerId;
        private String fnr;
        private LocalDate foersteStoenadsdag;
        private LocalDate sisteStoenadsdag;
        private String gsakId;

        public Builder medAktoerId(String val) {
            aktoerId = val;
            return this;
        }

        public Builder medFnr(String val) {
            fnr = val;
            return this;
        }

        public Builder medFoersteStoenadsdag(LocalDate foersteStoenadsdag) {
            this.foersteStoenadsdag = foersteStoenadsdag;
            return this;
        }

        public Builder medSisteStoenadsdag(LocalDate sisteStoenadsdag) {
            this.sisteStoenadsdag = sisteStoenadsdag;
            return this;
        }

        public Builder medGsakId(String gsakId) {
            this.gsakId = gsakId;
            return this;
        }

        public SvangerskapspengerEndret build() {
            Objects.requireNonNull(aktoerId, "aktoerId"); //$NON-NLS-1$
            Objects.requireNonNull(foersteStoenadsdag, "foersteStoenadsdag"); //$NON-NLS-1$
            return new SvangerskapspengerEndret(this);
        }
    }
}
