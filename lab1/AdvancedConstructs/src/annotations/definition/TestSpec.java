package annotations.definition;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @professor Jean-Michel Busca
 * @author Harold
 */
@Target(METHOD)
@Retention(RUNTIME)
@Repeatable(TestSpecs.class)
public @interface TestSpec {
    String test() default "";

    int order();
}
