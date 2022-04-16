package baseball;

import static org.junit.jupiter.api.RepeatedTest.DISPLAY_NAME_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.params.ParameterizedTest;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@ParameterizedTest(name = DISPLAY_NAME_PLACEHOLDER + "::" + DEFAULT_DISPLAY_NAME)
public @interface DisplayedParameterizedTest {
}
