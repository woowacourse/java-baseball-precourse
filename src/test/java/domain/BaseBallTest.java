package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    @Test
    @DisplayName("베이스볼 랜덤 값의 범위를 확인한다.")
    public void testRandomBaseballNumber() throws Exception {
        //given
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 9;
        final int COUNT = 1000; //random 숫자를 몇 회 생성할 지

        for (int i = 0; i < COUNT; i++) {
            //when
            BaseBall randomBaseBall = BaseBall.createRandomBaseBall();

            //then
            for (Integer digit : randomBaseBall.getBaseballNumber()) {
                assertTrue(digit >= MIN_VALUE, "최소값을 초과합니다.");
                assertTrue(digit <= MAX_VALUE, "최대값을 초과합니다.");
            }
        }
    }

    @Test
    @DisplayName("베이스볼 랜덤 값의 중복환인 값을 확인한다.")
    public void testDuplicateRandomBaseballNumber() throws Exception {
        //given
        Set<Integer> ballNumbers = new HashSet<>();
        //when
        BaseBall randomBaseBall = BaseBall.createRandomBaseBall();
        //then
        for (Integer digit : randomBaseBall.getBaseballNumber()) {
            System.out.println(digit);
            assertFalse(ballNumbers.contains(digit), "중복된 값이 존재합니다.");
            ballNumbers.add(digit);
        }
    }

    @Test
    @DisplayName("볼 리스트가 제대로 생성이 되었는지 확인한다.")
    public void testBaseballNumber() throws Exception {
        //given
        List<Integer> ballList = Arrays.asList(1, 3, 5);
        //when
        BaseBall baseBall = BaseBall.createBaseBall(135);
        //then
        assertEquals(ballList, baseBall.getBaseballNumber());
    }

    @Test
    @DisplayName("입력 숫자가 최댓값 초과시 에러 확인")
    public void testBaseballOverNumberException() throws Exception {
        //given
        int inputNumber = 1000;
        //when
        //then
        IllegalStateException exception
                = assertThrows(IllegalStateException.class, () -> BaseBall.createBaseBall(inputNumber));
        assertEquals("세자리 숫자를 입력해주세요.", exception.getMessage());

    }

    @Test
    @DisplayName("입력 숫자가 최소값 초과시 에러 확인")
    public void testBaseballNumberException() throws Exception {
        //given
        int inputNumber = 99;
        //when
        //then
        IllegalStateException exception
                = assertThrows(IllegalStateException.class, () -> BaseBall.createBaseBall(inputNumber));
        assertEquals("세자리 숫자를 입력해주세요.", exception.getMessage());

    }
}