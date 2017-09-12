package mx.emite.sdk.cfdi32.anotaciones;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import mx.emite.sdk.cfdi32.validadores.ClabeValidador;


@Documented
@Constraint(validatedBy = {ClabeValidador.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@ReportAsSingleViolation
public @interface Clabe {
	
	String message() default "{0} debe de ser una CLABE válida";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	boolean botones() default true;
}
