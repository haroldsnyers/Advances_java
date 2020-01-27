package annotations.definition;

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
public @interface TestSpecs {
    TestSpec[] value();
}
