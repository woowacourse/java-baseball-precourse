package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import java.util.List;

import org.junit.jupiter.api.*;

public class InputViewTest {

    private static OutputView outputView = new OutputView();
    private static InputView inputView = new InputView(outputView);

    @Test
    void 게임진행여부입력시_정상작동확인() {
        int inputData = 1;
        reassignOutputStream(String.valueOf(inputData));

        int number = inputView.inputPlayOrStop();
        assertThat(number).isEqualTo(inputData);
    }

    @Test
    void 게임진행여부입력시_숫자가아닌값_에러발생확인() {
        String inputData = "123aaa";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = inputView.inputPlayOrStop();
        });
    }

    @Test
    void 게임진행여부입력시_범위밖의값_에러발생확인() {
        String inputData = "123";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            int number = inputView.inputPlayOrStop();
        });
    }

    @Test
    void 숫자배열입력시_정상작동확인() {
        int[] realNumber = {1,2,3};
        String inputData = "123";
        reassignOutputStream(inputData);

        List<Integer> numberList = inputView.inputPlayerNumbers();
        assertThat(numberList.size()).isEqualTo(realNumber.length);

        for (int i = 0; i < realNumber.length; i++) {
            assertThat(numberList.get(i)).isEqualTo(realNumber[i]);
        }
    }

    @Test
    void 숫자배열입력시_자릿수불일치_에러발생확인() {
        int[] realNumber = {1,2,3,4};
        String inputData = "1234";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = inputView.inputPlayerNumbers();
        });
    }

    @Test
    void 숫자배열입력시_숫자가아닌값_에러발생확인() {
        String inputData = "123as";
        reassignOutputStream(inputData);

        assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> numberList = inputView.inputPlayerNumbers();
        });
    }

    @Test
    void 숫자배열입력시_범위밖의값_에러발생확인() {
        int[] realNumber = {1,2,0};
        String inputData = "120";
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
