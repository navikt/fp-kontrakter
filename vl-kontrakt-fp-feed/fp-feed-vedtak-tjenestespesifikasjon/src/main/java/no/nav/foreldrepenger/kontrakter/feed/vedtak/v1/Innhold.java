package no.nav.foreldrepenger.kontrakter.feed.vedtak.v1;

import java.time.LocalDate;

public abstract class Innhold {
    public Innhold() {
    	//Michael Jackson
	}

	private String aktoerId;

	private String fnr;

    private LocalDate foersteStoenadsdag;

    private LocalDate sisteStoenadsdag;

    private String gsakId;

	public String getAktoerId() {
		return aktoerId;
	}

	public void setAktoerId(String aktoerId) {
		this.aktoerId = aktoerId;
	}

	public String getFnr() {
		return fnr;
	}

	public void setFnr(String fnr) {
		this.fnr = fnr;
	}

	public LocalDate getFoersteStoenadsdag() {
		return foersteStoenadsdag;
	}

	public void setFoersteStoenadsdag(LocalDate foersteStoenadsdag) {
		this.foersteStoenadsdag = foersteStoenadsdag;
	}

	public LocalDate getSisteStoenadsdag() {
		return sisteStoenadsdag;
	}

	public void setSisteStoenadsdag(LocalDate sisteStoenadsdag) {
		this.sisteStoenadsdag = sisteStoenadsdag;
	}

	public String getGsakId() {
		return gsakId;
	}

	public void setGsakId(String gsakId) {
		this.gsakId = gsakId;
	}
}
