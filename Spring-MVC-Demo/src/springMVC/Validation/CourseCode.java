package springMVC.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/********************************************************
*
*
*WILL DO IN FREE TIME.
*
**/
import javax.validation.Constraint;/*
@Constraint(validatedBy=CourseCodeConstrainValidator.Class)
/*@Target({ElementType.METHOD,ElementType.FIELD})*/
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

}
