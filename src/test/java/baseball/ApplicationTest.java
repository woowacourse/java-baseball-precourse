package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

    @Test
    @DisplayName("유저가 숫자가 아닌 값을 입력했을 경우")
    void 유저_숫자이외의입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Game().isRange("a23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("유저가 3글자가 아닌 값을 입력했을 경우")
    void 유저_숫자길이입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Game().isLength("1243"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("유저가 중복된 숫자를 입력했을 경우")
    void 유저_숫자중복입력_예외_테스트(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Game().isDuplicate("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("컴퓨터가 중복된 숫자를 생성했을 경우")
    void 컴퓨터_숫자생성_테스트(){
        List<Integer> computerNum = new Game().getComputerNum();

        assertThat(computerNum.size()).isEqualTo(3);
        assertThat(new HashSet<>(computerNum).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("게임의 볼 개수 테스트")
    void 게임_볼_검증테스트(){
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNum = new ArrayList<>(Arrays.asList(2, 1, 9));

        assertThat(new Game().checkBall(computerNum, userNum)).isEqualTo(2);
    }

    @Test
    @DisplayName("게임의 스트라이크 개수 테스트")
    void 게임_스트라이크_검증테스트(){
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNum = new ArrayList<>(Arrays.asList(1, 2, 9));

        assertThat(new Game().checkStrike(computerNum, userNum)).isEqualTo(2);
    }

    @Test
    @DisplayName("게임의 볼과 스트라이크 개수 테스트")
    void 게임_볼_스트라이크_검증테스트(){
        List<Integer> computerNum = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNum = new ArrayList<>(Arrays.asList(1, 3, 9));

        assertThat(new Game().checkStrike(computerNum, userNum)).isEqualTo(1);
        assertThat(new Game().checkBall(computerNum, userNum)).isEqualTo(2);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
