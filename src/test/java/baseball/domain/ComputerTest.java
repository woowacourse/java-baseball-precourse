package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    public void 쓰리_스트라이크() {
        // given
        Computer computer = new Computer();
        List<Integer> targetDigits = new ArrayList<>(Arrays.asList(7, 1, 3));
        List<Integer> guessDigits = new ArrayList<>(Arrays.asList(7, 1, 3));

        // when
        computer.setTargetDigits(targetDigits);

        // then
        assertEquals("3스트라이크", computer.guessTargetDigits(guessDigits));
    }

    @Test
    public void 원_볼_그리고_원_스트라이크() {
        // given
        Computer computer = new Computer();
        List<Integer> targetDigits = new ArrayList<>(Arrays.asList(7, 1, 3));
        List<Integer> guessDigits = new ArrayList<>(Arrays.asList(7, 3, 2));

        // when
        computer.setTargetDigits(targetDigits);

        // then
        assertEquals("1볼 1스트라이크", computer.guessTargetDigits(guessDigits));
    }

    @Test
    public void 낫싱() {
        // given
        Computer computer = new Computer();
        List<Integer> targetDigits = new ArrayList<>(Arrays.asList(7, 1, 3));
        List<Integer> guessDigits = new ArrayList<>(Arrays.asList(8, 9, 6));

        // when
        computer.setTargetDigits(targetDigits);

        // then
        assertEquals("낫싱", computer.guessTargetDigits(guessDigits));
    }
}