package no.seres.xsd.nav.inntektsmelding_m;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

    @Override
    public LocalDateTime unmarshal(String v) throws DateTimeParseException {
        if (Objects.isNull(v)) {
            return null;
        }
        return LocalDateTime.parse(v, DateTimeFormatter.ISO_DATE_TIME);
    }

    @Override
    public String marshal(LocalDateTime v) throws DateTimeParseException {
        if (Objects.isNull(v)) {
            return null;
        }
        return v.toString();
    }
}
