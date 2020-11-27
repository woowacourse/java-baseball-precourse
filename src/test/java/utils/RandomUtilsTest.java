package utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {

    private static final int BIG_NUMBER = 300000;

    @Test
    public void getRandomIntegerTest() {
        for (int i = 0; i < BIG_NUMBER; i++) {
            // nextInt의 매개변수로 1, 9를 넣어 주어야 1~9사이의 랜덤한 값이 출력된다.
            assertThat(RandomUtils.nextInt(1, 9)).isBetween(1, 9);
        }
    }

    @Test
    public void isRandomIntegerWithoutDuplicateTest() {
        List<Integer> testIntegerList = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            testIntegerList.add(RandomUtils.nextInt(1, 9));
        }

        Set<Integer> testIntegerSet = new HashSet<Integer>(testIntegerList);
        // RandomUtils.nextInt 메서드가 중복이 제거된 원소를 따로 고려해주지는 않는다.
        assertThat(testIntegerList.size()).isEqualTo(testIntegerSet.size());
    }

    @Test
    public void getRandomIntegerWihoutDuplicateTest() {
        List<Integer> testIntegerList = new ArrayList<Integer>();

        while (testIntegerList.size() < 3) {
            int i = RandomUtils.nextInt(1, 9);
            if (!testIntegerList.contains(i)) {
                testIntegerList.add(i);
            }
        }
        assertThat(testIntegerList.size()).isEqualTo(3);
    }

}