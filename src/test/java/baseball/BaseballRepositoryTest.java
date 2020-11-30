package baseball;

import domain.BaseBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballRepositoryTest {
    private BaseballRepository baseballRepository;

    public BaseballRepositoryTest() {
        baseballRepository = new BaseballRepository();
    }

    @Test
    @DisplayName("랜덤 베이스 볼 생성 시 1~9사이를 벗어나지 않는 지 확인")
    public void testRandomBaseball() throws Exception {
        //given
        final int MIN_VALUE = 1;
        final int MAX_VALUE = 9;
        final int COUNT = 1000; //random 숫자를 몇 회 생성할 지
        for (int i = 0; i < COUNT; i++) {
            //when
            BaseBall randomBaseBall = baseballRepository.createRandomBaseBall();

            //then
            for (int index = 0; index < randomBaseBall.size(); index++) {
                int digit = randomBaseBall.getNumber(index);
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
        BaseBall randomBaseBall = baseballRepository.createRandomBaseBall();
        //then
        for (int index = 0; index < randomBaseBall.size(); index++) {
            int digit = randomBaseBall.getNumber(index);
            assertFalse(ballNumbers.contains(digit), "중복된 값이 존재합니다.");
            ballNumbers.add(digit);
        }
    }

}