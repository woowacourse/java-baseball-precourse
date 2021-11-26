package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.*;

public class InputViewTest {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView(outputView);

    @DisplayName("게임진행여부 입력 시 정상 작동 여부 확인")
    @Test
    void inputPlayOrStopTest() {
        int inputData = 1;
        reassignOutputStream(String.valueOf(inputData));

        int number = inputView.inputPlayOrStop();
        assertThat(number).isEqualTo(inputData);
    }

    @DisplayName("범위 밖의 값 입력 시 에러 발생")
    @Test
    void inputPlayOrStopRangeTest() {
        String inputData = "123";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = inputView.inputPlayOrStop();
        });
    }

    @DisplayName("숫자가 아닌 값 입력 시 에러 발생")
    @Test
    void inputNumberErrorTest() {
        String inputData = "123aaa";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = inputView.inputPlayOrStop();
        });
    }

    @DisplayName("숫자 배열 입력 시 정상 작동 여부 확인")
    @Test
    void inputPlayerNumbersTest() {
        int[] realNumber = {1,2,3};
        String inputData = "123";
        reassignOutputStream(inputData);

        List<Integer> numberList = inputView.inputPlayerNumbers();
        assertThat(numberList.size()).isEqualTo(realNumber.length);

        for (int i = 0; i < realNumber.length; i++) {
            assertThat(numberList.get(i)).isEqualTo(realNumber[i]);
        }
    }

    @DisplayName("숫자 배열 입력 시, 자릿수가 불일치하면 에러 발생")
    @Test
    void inputPlayerNumbersDigitTest() {
        int[] realNumber = {1,2,3,4};
        String inputData = "1234";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = inputView.inputPlayerNumbers();
        });
    }

    @DisplayName("숫자 배열 입력 시, 숫자 범위를 벗어나면 에러 발생")
    @Test
    void inputPlayerNumbersOutOfRangeTest() {
        int[] realNumber = {1,2,0};
        String inputData = "120";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = inputView.inputPlayerNumbers();
        });
    }

    @DisplayName("숫자 배열 입력 시, 숫자가 아닌 값이 포함되면 에러 발생")
    @Test
    void inputNumbersErrorTest() {
        String inputData = "123as";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = inputView.inputPlayerNumbers();
        });
    }

    private void reassignOutputStream(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
