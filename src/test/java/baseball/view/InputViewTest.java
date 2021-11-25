package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}