package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static InputStream generateStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("숫자를 입력하면 List를 반환한다.")
    @Test
    void inputNumbersThenToList() {
        // given
        System.setIn(generateStream("123"));
        InputView inputView = new InputView();

        // when
        List<Integer> numbers = inputView.getInputNumbers();

        // then
        assertThat(numbers).isInstanceOf(List.class);
    }

    @DisplayName("입력한 숫자의 길이가 4이상이면 IllegalArgumentException을 던진다.")
    @Test
    void sizeOverThrowIllegalArgumentException() {
        // given
        System.setIn(generateStream("1234"));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 값이 숫자가 아니면 IllegalArgumentException을 던진다.")
    @Test
    void noneIntegerThenThrowIllegalArgumentException() {
        // given
        System.setIn(generateStream("12a"));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 숫자 중 중복된 값을 포함하면 IllegalArgumentException을 던진다.")
    @Test
    void duplicateNumberThenThrowIllegalArgumentException() {
        // given
        System.setIn(generateStream("111"));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 숫자가 0인 경우 IllegalArgumentException을 던진다.")
    @Test
    void overRangeThenThrowIllegalArgumentException() {
        // given
        System.setIn(generateStream("012"));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.getInputNumbers();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("command 1은 게임 재시작을 의미하며 true를 반환한다.")
    @Test
    void isStartThenTrue() {
        // given
        System.setIn(generateStream("1"));
        InputView inputView = new InputView();

        // when
        boolean restart = inputView.isRestart();

        // then
        assertThat(restart).isTrue();
    }

    @DisplayName("command 2는 게임 종료를 의미하며 false를 반환한다.")
    @Test
    void isStartThenFalse() {
        // given
        System.setIn(generateStream("2"));
        InputView inputView = new InputView();

        // when
        boolean restart = inputView.isRestart();

        // then
        assertThat(restart).isFalse();
    }

    @DisplayName("command로 1과 2 이외의 값을 입력 받으면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"11", "22", "abc"})
    void getInputCommandNotOneTwoThrowIllegalArgumentException(String inputCommand) {
        // given
        System.setIn(generateStream(inputCommand));
        InputView inputView = new InputView();

        // when & then
        assertThatThrownBy(() -> {
            inputView.isRestart();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}