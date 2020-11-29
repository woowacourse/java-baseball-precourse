/*
 * Class:   BaseBallUtils.java
 *
 * Version: 1.0.0
 *
 * Date:    2020-11-28
 *
 * Author:  Dong Gun Lee
 *
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import utils.BaseBallUtils;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseBallUtilsTest {
    private static Scanner restartInput;
    private static Scanner exitInput;
    private static Scanner wrongInput;
    private static Scanner rightInput;
    private static Scanner zeroInput;
    private static Scanner overThreeInput;
    private static Scanner duplicatedInput;

    @BeforeAll
    public static void setUp() {
        restartInput = new Scanner("1");
        exitInput = new Scanner("2");
        wrongInput = new Scanner("worng");
        rightInput = new Scanner("235");
        zeroInput = new Scanner("012");
        overThreeInput = new Scanner("1234");
        duplicatedInput = new Scanner("112");
    }

    @AfterAll
    public static void tearDown() {
        restartInput.close();
        exitInput.close();
        wrongInput.close();
        rightInput.close();
        zeroInput.close();
        overThreeInput.close();
        duplicatedInput.close();
    }

    @Test
    public void restartCode() {
        BaseBallUtils.isCodeRight(restartInput);
        System.out.println("restart 코드");
    }

    @Test
    public void exitCode() {
        BaseBallUtils.isCodeRight(exitInput);
        System.out.println("exit 코드");
    }

    @Test
    public void wrongCode() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {BaseBallUtils.isCodeRight(wrongInput);})
                .withMessage("한 자리의 숫자만 입력해주세요.");
    }

    @Test
    public void zeroInputTest() {
        ArrayList<Integer> inputBalls = new ArrayList<Integer>();
        String input = zeroInput.next();
        int ballLength = input.length();

        for (int i = 0; i < ballLength; i++) {
            inputBalls.add((int) Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {BaseBallUtils.isBallsRight(inputBalls);})
                .withMessage("1에서 9사이의 숫자가 아닙니다.");
    }

    @Test
    public void overThreeInputTest() {
        ArrayList<Integer> inputBalls = new ArrayList<Integer>();
        String input = overThreeInput.next();
        int ballLength = input.length();

        for (int i = 0; i < ballLength; i++) {
            inputBalls.add((int) Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {BaseBallUtils.isBallsRight(inputBalls);})
                .withMessage("3자리의 수가 아닙니다.");
    }

    @Test
    public void duplicatedInputTest() {
        ArrayList<Integer> inputBalls = new ArrayList<Integer>();
        String input = duplicatedInput.next();
        int ballLength = input.length();

        for (int i = 0; i < ballLength; i++) {
            inputBalls.add((int) Character.getNumericValue(input.charAt(i)));
        }

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {BaseBallUtils.isBallsRight(inputBalls);})
                .withMessage("숫자가 중복되었습니다.");
    }
}

