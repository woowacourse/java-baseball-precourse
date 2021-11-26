package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("게임진행여부 입력 시 정상 작동 여부 확인")
    @Test
    void inputPlayOrStopTest() {
        int inputData = 1;
        reassignOutputStream(String.valueOf(inputData));

        int number = InputView.inputPlayOrStop();
        assertThat(number).isEqualTo(inputData);
    }

    @DisplayName("범위 밖의 값 입력 시 에러 발생")
    @Test
    void inputPlayOrStopRangeTest() {
        String inputData = "123";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = InputView.inputPlayOrStop();
        });
    }

    @DisplayName("숫자가 아닌 값 입력 시 에러 발생")
    @Test
    void inputNumberErrorTest() {
        String inputData = "123aaa";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = InputView.inputPlayOrStop();
        });
    }

    @DisplayName("숫자 배열 입력 시 정상 작동 여부 확인")
    @Test
    void inputNumbersTest() {
        int[] realNumber = {1,2,3,4};
        String inputData = "1234";
        reassignOutputStream(inputData);

        List<Integer> numberList = InputView.inputNumbers();
        assertThat(numberList.size()).isEqualTo(realNumber.length);

        for (int i = 0; i < realNumber.length; i++) {
            assertThat(numberList.get(i)).isEqualTo(realNumber[i]);
        }
    }

    @DisplayName("숫자 배열 입력 시, 숫자가 아닌 값이 포함되면 에러 발생")
    @Test
    void inputNumbersErrorTest() {
        String inputData = "123as";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = InputView.inputNumbers();
        });
    }

    private void reassignOutputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
