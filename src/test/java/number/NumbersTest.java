package number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import baseball.BaseBallGame;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumbersTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @DisplayName("볼을 체크한다")
    void checkBall() {
        //given
        List<Number> gameNumber = new ArrayList<>();
        List<Number> gameNumber2 = new ArrayList<>();
        List<Integer> randomList = Arrays.asList(new Integer[]{2, 1, 3});
        List<Integer> inputList = Arrays.asList(new Integer[]{4, 2, 3});
        List<Integer> randomList2 = Arrays.asList(new Integer[]{2, 1, 4});
        List<Integer> inputList2 = Arrays.asList(new Integer[]{4, 2, 1});

        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        gameNumber2.add(Number.of(randomList2));
        gameNumber2.add(Number.of(inputList2));

        //when
        Numbers numbers = Numbers.of(gameNumber);
        Numbers numbers2 = Numbers.of(gameNumber2);

        //then
        Assertions.assertThat(numbers.countBall()).isEqualTo(1);
        Assertions.assertThat(numbers2.countBall()).isEqualTo(3);
    }

    @Test
    @DisplayName("스트라이크를 체크한다")
    void checkStrike() {
        //given
        List<Number> gameNumber = new ArrayList<>();
        List<Number> gameNumber2 = new ArrayList<>();
        List<Integer> randomList = Arrays.asList(new Integer[]{2, 1, 3});
        List<Integer> inputList = Arrays.asList(new Integer[]{4, 2, 3});
        List<Integer> randomList2 = Arrays.asList(new Integer[]{4, 2, 1});
        List<Integer> inputList2 = Arrays.asList(new Integer[]{4, 2, 1});

        gameNumber.add(Number.of(randomList));
        gameNumber.add(Number.of(inputList));
        gameNumber2.add(Number.of(randomList2));
        gameNumber2.add(Number.of(inputList2));

        //when
        Numbers numbers = Numbers.of(gameNumber);
        Numbers numbers2 = Numbers.of(gameNumber2);

        //then
        Assertions.assertThat(numbers.countStrike()).isEqualTo(1);
        Assertions.assertThat(numbers2.countStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("볼인 경우 '%볼'를 출력한다 ")
    void ballPrintTest(){
        //given
        int ball = 2;
        int strike = 0;

        //when
        BaseBallGame.printResult(ball, strike);

        //then
        Assertions.assertThat(ball + "볼 " + "\n").isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("스트라이크인 경우 '%스트라이크'를 출력한다 ")
    void strikePrintTest(){
        //given
        int ball = 0;
        int strike = 2;

        //when
        BaseBallGame.printResult(ball, strike);

        //then
        Assertions.assertThat(strike + "스트라이크" + "\n").isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("볼과 스트라이크 인 경우 ' %볼 %스트라이크'를 출력한다 ")
    void ballStrikePrintTest(){
        //given
        int ball = 1;
        int strike = 2;

        //when
        BaseBallGame.printResult(ball, strike);

        //then
        Assertions.assertThat(ball +"볼 " + strike +"스트라이크" + "\n").isEqualTo(outContent.toString());
    }

    @Test
    @DisplayName("입력수에 대해 하나도 맞는게 없는경우 '낫싱'을 출력한다 ")
    void nothingPrintTest(){
        //given
        int ball = 0;
        int strike = 0;

        //when
        BaseBallGame.printResult(ball, strike);

        //then
        Assertions.assertThat("낫싱" + "\n").isEqualTo(outContent.toString());
    }
}
