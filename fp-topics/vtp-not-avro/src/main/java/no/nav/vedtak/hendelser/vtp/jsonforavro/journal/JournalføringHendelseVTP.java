package no.nav.vedtak.hendelser.vtp.jsonforavro.journal;

import java.util.UUID;

import javax.validation.constraints.NotNull;

public record JournalføringHendelseVTP(@NotNull String hendelsesId,
                                       Integer versjon,
                                       @NotNull HendelsesType hendelsesType,
                                       @NotNull String journalpostId,
                                       String journalpostStatus,
                                       Tema temaGammelt,
                                       @NotNull Tema temaNytt,
                                       Mottakskanal mottaksKanal,
                                       String kanalReferanseId,
                                       String behandlingstema)  {

    public static JournalføringHendelseVTP standardInngåendeInntektsmelding(String journalpostId, Tema tema, String kanalReferanseId) {
        return standardInngående(journalpostId, tema, kanalReferanseId, Mottakskanal.ALTINN);
    }

    public static JournalføringHendelseVTP standardInngåendeScanning(String journalpostId, Tema tema, String kanalReferanseId) {
        return standardInngående(journalpostId, tema, kanalReferanseId, Mottakskanal.SKAN_IM);
    }

    public static JournalføringHendelseVTP standardInngåendeSelvbetjening(String journalpostId, Tema tema, String kanalReferanseId) {
        return standardInngående(journalpostId, tema, kanalReferanseId, Mottakskanal.NAV_NO);
    }

    private static JournalføringHendelseVTP standardInngående(String journalpostId, Tema tema, String kanalReferanseId, Mottakskanal kanal) {
        return new JournalføringHendelseVTP(UUID.randomUUID().toString(), 1, HendelsesType.JournalpostMottatt,
            journalpostId, "MOTTATT", null, tema, kanal,
            kanalReferanseId, null);
    }

}
