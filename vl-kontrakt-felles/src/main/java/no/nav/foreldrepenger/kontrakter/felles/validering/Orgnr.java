package no.nav.foreldrepenger.kontrakter.felles.validering;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OrgnrValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Orgnr {

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

    String message() default "Orgnummer er ikke ugyldig";
}
