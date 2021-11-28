package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static baseball.util.RandomUtil.createComputerNumbers;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void pickNumberInRange_테스트() throws Exception {
        //given
        int num1 = 1;
        int num2 = 9;

        //when
        int result = pickNumberInRange(1, 9);

        //then
        assertThat(result).isGreaterThanOrEqualTo(num1).isLessThanOrEqualTo(num2);
    }

    @Test
    public void 컴퓨터난수_다른지_테스트() throws Exception {
        //given

        //when
        int[] computerNumbers = createComputerNumbers();

        //then
        assertThat(computerNumbers).doesNotHaveDuplicates();
    }
}
