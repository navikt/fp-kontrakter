package no.seres.xsd.nav.inntektsmelding_m;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws DateTimeParseException {
        if (Objects.isNull(v)) {
            return null;
        }
        return LocalDate.parse(v, DateTimeFormatter.ISO_DATE);
    }

    @Override
    public String marshal(LocalDate v) throws DateTimeParseException {
        if (Objects.isNull(v)) {
            return null;
        }
        return v.toString();
    }
}
