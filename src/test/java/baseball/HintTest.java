package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static constant.Constant.BALL;
import static constant.Constant.STRIKE;
import static org.junit.jupiter.api.Assertions.*;

class HintTest {

    @DisplayName("Strike와 Ball 개수 카운트 테스트")
    @Test
    void countStrikeAndBall() {
        Integer[] randomArr = {1, 2, 3};
        Integer[] inputArr = {7, 2, 1};
        List<Integer> randomNum = Arrays.asList(randomArr);
        List<Integer> inputNum = Arrays.asList(inputArr);

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Hint hint = new Hint();
        hint.countStrikeAndBall(randomNum, inputNum);

        String resultMsg = "1볼 1스트라이크\n";
        assertEquals(resultMsg, out.toString().replace("\r", ""));

    }
}