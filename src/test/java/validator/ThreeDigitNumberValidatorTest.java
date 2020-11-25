package validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class ThreeDigitNumberValidatorTest {

    @Test
    public void 올바른_입력값_들어올_경우_예외_발생하지_않음() {
        //given
        String threeDigitNumber = "123";

        //when
        boolean isValidNumber = ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber);

        //then
        assertThat(isValidNumber).isTrue();
    }

    @Test
    public void 입력값이_숫자가_아니면_예외_발생() {
        //given
        String threeDigitNumber = "한글입력";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber))
                .withMessage("입력값은 숫자이어야 합니다.");
    }

    @Test
    public void 입력값이_음수이면_예외_발생() {
        //given
        String threeDigitNumber = "-12";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber))
                .withMessage("입력값은 양수이어야 합니다.");
    }

    @Test
    public void 입력값이_세자리_수가_아니면_예외_발생() {
        //given
        String threeDigitNumber = "1234";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber))
                .withMessage("입력값은 세자리이어야 합니다.");
    }

    @Test
    public void 입력값에_0이_포함되어_있으면_예외_발생() {
        //given
        String threeDigitNumber = "103";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber))
                .withMessage("입력값은 0을 포합할 수 없습니다.");
    }

    @Test
    public void 입력값에_중복된_숫자가_있으면_예외_발생() {
        //given
        String threeDigitNumber = "333";

        //when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> ThreeDigitNumberValidator.validateThreeDigitNumber(threeDigitNumber))
                .withMessage("입력값은 중복된 숫자를 포함할 수 없습니다.");
    }
}