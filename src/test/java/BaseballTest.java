/*
 * BaseballTest class
 *
 * v0.1
 *
 * 2019.03.25
 *
 * Copyrights
 */

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

import com.woowatechcourse.woung717.baseball.Baseball;
import com.woowatechcourse.woung717.baseball.BaseballAnswer;

import java.lang.reflect.Field;

public class BaseballTest {
    public static Baseball baseball;

    @BeforeClass
    public static void beforeClass() {
        baseball = new Baseball(new BaseballAnswer());
    }

    @Test
    public void testgetResponse() throws NoSuchFieldException, IllegalAccessException {
        Field field = Baseball.class.getDeclaredField("answer");
        field.setAccessible(true);
        field.set(baseball, "123");

        assertEquals(baseball.getResponse("456"), new Baseball.Result("포볼", 0, 0));

        assertEquals(baseball.getResponse("145"), new Baseball.Result("1 스트라이크 ", 1, 0));
        assertEquals(baseball.getResponse("125"), new Baseball.Result("2 스트라이크 ", 2, 0));
        assertEquals(baseball.getResponse("123"), new Baseball.Result("3 스트라이크 ", 3, 0));

        assertEquals(baseball.getResponse("451"), new Baseball.Result("1 볼", 0, 1));
        assertEquals(baseball.getResponse("431"), new Baseball.Result("2 볼", 0, 2));
        assertEquals(baseball.getResponse("231"), new Baseball.Result("3 볼", 0, 3));

        assertEquals(baseball.getResponse("135"), new Baseball.Result("1 스트라이크 1 볼", 1, 1));
        assertEquals(baseball.getResponse("132"), new Baseball.Result("1 스트라이크 2 볼", 1, 2));
    }
}
