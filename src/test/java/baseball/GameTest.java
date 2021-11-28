package baseball;

// - [ ] 게임이 생성되면 임의의 수를 가진 Balls 생성
//     - [ ] Hint 객체를 받아 사용자가 정답을 맞췄는지 확인
//     - [ ] 사용자가 정답을 맞췄을 때 게임 실행 여부를 입력받는다.
//     - [ ] 임의의 수 3개인 숫자 리스트 생성
//     - [ ] [예외] 입력한 값이 1, 2인지 검사

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @DisplayName("입력한 값이 1, 2인지 검사")
    @Test
    void validateInput() {
        Game game = new Game();
        assertThatThrownBy(() -> game.validateInput("3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
