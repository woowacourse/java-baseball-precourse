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
    @DisplayName("볼 리스트가 제대로 생성이 되었는지 확인한다.")
    public void testBaseballNumber() throws Exception {
        //given
        List<Integer> ballList = Arrays.asList(1, 3, 5);
        //when
        BaseBall baseBall = new BaseBall(ballList);
        //then
        for (int index = 0; index < ballList.size(); index++) {
            assertEquals(ballList.get(index), baseBall.getNumber(index));
        }
    }

    @Test
    @DisplayName("입력 숫자가 최댓값 초과시 에러 확인")
    public void testBaseballOverNumberException() throws Exception {
        //given
        List<Integer> inputNumber = Arrays.asList(1,2,3,4);
        //when
        IllegalStateException exception
                = assertThrows(IllegalStateException.class, () -> new BaseBall(inputNumber));
        //then
        assertEquals("0을 제외한 3자리 숫자를 입력해주세요.", exception.getMessage());

    }

    @Test
    @DisplayName("입력 숫자가 최소값 초과시 에러 확인")
    public void testBaseballNumberException() throws Exception {
        //given
        List<Integer> inputNumber = Arrays.asList(9,9);
        //when
        IllegalStateException exception
                = assertThrows(IllegalStateException.class, () -> new BaseBall(inputNumber));
        //then
        assertEquals("0을 제외한 3자리 숫자를 입력해주세요.", exception.getMessage());

    }
}