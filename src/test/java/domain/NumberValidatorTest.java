package domain;

import annotation.TestDescription;
import org.junit.Test;
import view.User;

import static org.junit.Assert.assertEquals;

public class NumberValidatorTest {

    @Test
    @TestDescription("사용자입력과 난수를 비교하여 적절한 Strike value, Ball value 를 반환하는 지 테스트합니다.")
    public void compareTest(){
        NumberValidator validator = new NumberValidator();

        validator.compareRandomNumberWithUserNumber(321, 456);
        assertEquals(validator.getStrike(),0);
        assertEquals(validator.getBall(),0);

        validator.compareRandomNumberWithUserNumber(123, 123);
        assertEquals(validator.getStrike(),3);
        assertEquals(validator.getBall(),0);

        validator.compareRandomNumberWithUserNumber(124, 456);
        assertEquals(validator.getStrike(),0);
        assertEquals(validator.getBall(),1);

        validator.compareRandomNumberWithUserNumber(568, 658);
        assertEquals(validator.getStrike(),1);
        assertEquals(validator.getBall(),2);

        validator.compareRandomNumberWithUserNumber(578, 563);
        assertEquals(validator.getStrike(),1);
        assertEquals(validator.getBall(),0);
    }
}
