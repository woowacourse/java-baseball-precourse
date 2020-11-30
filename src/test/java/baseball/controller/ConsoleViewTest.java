package baseball.controller;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ConsoleViewTest {

    @Test
    @Description("strike 출력 테스트 3스트라이크")
    public void consoleViewTest() {

        ConsoleView consoleView = new ConsoleView();

        consoleView.setStrikeCount(3);
        consoleView.printResult();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @Description("strike 출력 테스트 1~2스트라이크")
    public void consoleViewTest2(int strikeCount) {

        //given
        ConsoleView consoleView = new ConsoleView();
        //when
        consoleView.setStrikeCount(strikeCount);
        //then
        consoleView.printResult();
    }

    @Test
    @Description("strike가 0 일때")
    public void consoleViewTest3() {

        //given
        ConsoleView consoleView = new ConsoleView();
        //when
        consoleView.setStrikeCount(0);
        //then
        consoleView.printResult();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @Description("볼 테스트")
    public void consoleViewTest4(int ballCount) {

        //given
        ConsoleView consoleView = new ConsoleView();

        //when
        consoleView.setBallCount(ballCount);
        //then
        consoleView.printResult();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @Description("볼이랑 스트라이크 같이 있을 경우")
    public void consoleViewTest5(int ballCount) {

        //given
        ConsoleView consoleView = new ConsoleView();

        //when
        consoleView.setBallCount(ballCount);
        consoleView.setStrikeCount(3 - ballCount);
        //then
        consoleView.printResult();
        System.out.println("========================");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MAX_VALUE, Integer.MIN_VALUE, 4})
    @Description("1~3을 제외한 숫자가 들어오면 IllegalArgumentException 발생")
    public void exceptionTest(int count) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ConsoleView consoleView = new ConsoleView();
            consoleView.setStrikeCount(count);
        });
    }

}