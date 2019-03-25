/*
 * BaseballDriverTest class
 *
 * v0.1
 *
 * 2019.03.25
 *
 * Copyrights
 */

import static org.junit.Assert.*;
import org.junit.Test;

import woowatechcourse.woung717.baseball.BaseballDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseballDriverTest {
    @Test
    public void testisValid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BaseballDriver baseballDriver = new BaseballDriver();
        Method method = BaseballDriver.class.getDeclaredMethod("isValid", String.class);
        method.setAccessible(true);

        assertTrue((boolean)method.invoke(baseballDriver, "123"));
        assertFalse((boolean)method.invoke(baseballDriver, "023"));
        assertFalse((boolean)method.invoke(baseballDriver, "111"));
        assertFalse((boolean)method.invoke(baseballDriver, "1234"));
        assertFalse((boolean)method.invoke(baseballDriver, "a123"));
    }
}
