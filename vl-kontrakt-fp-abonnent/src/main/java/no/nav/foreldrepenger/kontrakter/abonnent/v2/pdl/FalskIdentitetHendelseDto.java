package no.nav.foreldrepenger.kontrakter.abonnent.v2.pdl;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.AktørIdDto;
import no.nav.foreldrepenger.kontrakter.abonnent.v2.HendelseDto;

import java.util.List;
import java.util.stream.Collectors;

public class FalskIdentitetHendelseDto extends HendelseDto {

    public static final String HENDELSE_TYPE = "FALSKID";

    @NotNull
    @Size(min = 1)
    private List<AktørIdDto> aktørId;

    private boolean erFalsk;

    public void setAktørId(List<AktørIdDto> aktørId) {
        this.aktørId = aktørId;
    }

    public List<AktørIdDto> getAktørId() {
        return this.aktørId;
    }

    public boolean isErFalsk() {
        return erFalsk;
    }

    public void setErFalsk(boolean erFalsk) {
        this.erFalsk = erFalsk;
    }

    @Override
    public String getHendelsetype() {
        return HENDELSE_TYPE;
    }

    @Override
    public List<String> getAlleAktørId() {
        return aktørId.stream().map(AktørIdDto::getAktørId).collect(Collectors.toList());
    }
}
