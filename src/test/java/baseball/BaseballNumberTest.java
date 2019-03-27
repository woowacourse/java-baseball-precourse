package baseball;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseballNumberTest {

    @Test
    public void 빈문자열검사() {

        //given
        String emptyString = "";

        //when
        boolean isNotEmpty = BaseballNumber.checkValidNumber(emptyString);

        //then
        assertThat(isNotEmpty).isFalse();
    }

    @Test
    public void 중복숫자검사() {

        //given
        String duplicatedNumber = "122";

        //when
        boolean isNotDuplicatedNumber = BaseballNumber.checkValidNumber(duplicatedNumber);

        //then
        assertThat(isNotDuplicatedNumber).isFalse();
    }

    @Test
    public void 숫자범위검사() {

        //given
        String outOfRangeNumber = "1000";

        //when
        boolean isInRange = BaseballNumber.checkValidNumber(outOfRangeNumber);

        //then
        assertThat(isInRange).isFalse();
    }

    @Test
    public void 특수문자검사() {

        //given
        String specialCharacter = "*&^";

        //when
        boolean isInRange = BaseballNumber.checkValidNumber(specialCharacter);

        //then
        assertThat(isInRange).isFalse();
    }


}