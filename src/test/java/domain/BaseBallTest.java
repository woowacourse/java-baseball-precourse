package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {
    @Test
    @DisplayName("베이스볼 랜덤 값의 범위를 확인한다.")
    public void testRandomBaseballNumber() throws Exception{
        //given
        int min_value = 1;
        int max_value = 9;
        //when
        BaseBall randomBaseBall = BaseBall.createRandomBaseBall();
        //then
        for (Integer digit : randomBaseBall.getBaseballNumber()) {
            System.out.println(digit);
            Assertions.assertTrue(digit>=min_value,"최소값을 초과합니다.");
            Assertions.assertTrue(digit<=max_value,"최대값을 초과합니다.");
        }
    }

    @Test
    @DisplayName("베이스볼 랜덤 값의 중복환인 값을 확인한다.")
    public void testDuplicateRandomBaseballNumber() throws Exception{
        //given
        Set<Integer> ballNumbers = new HashSet<>();
        //when
        BaseBall randomBaseBall = BaseBall.createRandomBaseBall();
        //then
        for (Integer digit : randomBaseBall.getBaseballNumber()) {
            System.out.println(digit);
            Assertions.assertFalse(ballNumbers.contains(digit),"중복된 값이 존재합니다.");
            ballNumbers.add(digit);
        }
    }
}