package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NewGameCommandTest {
    @ParameterizedTest
    @DisplayName("잘못된 입력 숫자로 게임 재시작 여부를 체크하면 예외를 발생시킨다.")
    @ValueSource(strings = {"0", "3"})
    void evokeExceptionByWrongInput(final String wrongInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> NewGameCommand.willPlayNewGame(wrongInput))
                .withMessage("재시작 / 종료를 위한 숫자 입력이 잘못 되었습니다.");
    }

    @ParameterizedTest
    @DisplayName("매개변수로 1을 받으면 true를 2를 받으면 false를 반환한다.")
    @CsvSource({"1, true", "2, false"})
    void willPlayNewGame(final String inputValue, final boolean expected) {
        boolean actual = NewGameCommand.willPlayNewGame(inputValue);
        assertThat(actual).isEqualTo(expected);
    }
}
