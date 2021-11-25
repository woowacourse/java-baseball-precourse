package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    @DisplayName("숫자 입력 시 정상 작동 여부 확인")
    @Test
    void inputNumberTest() {
        int inputData = 123;
        reassignOutputStream(String.valueOf(inputData));

        int number = InputView.inputNumber();
        Assertions.assertThat(number).isEqualTo(inputData);
    }

    @DisplayName("숫자가 아닌 값 입력 시 에러 발생")
    @Test
    void inputNumberErrorTest() {
        String inputData = "123aaa";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = InputView.inputNumber();
        });
    }

    private void reassignOutputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
