package utils;

import java.util.Random;

/*
 *              startInclusive+1~endInclusive 사이의 난수를 랜덤하게 생성해서 반환하는 클래스
 * @author      483759/윤이진
 * */
public class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    /* Random 생성한 배열에 들어갈 특정 범위의 숫자를 정하는 함수 */
    public static int nextInt(final int startInclusive, final int endInclusive) {
        try {
            if (startInclusive > endInclusive) {
                throw new IllegalArgumentException();
            }

            if (startInclusive < 0) {
                throw new IllegalArgumentException();
            }

            if (startInclusive == endInclusive) {
                return startInclusive;
            }
        }catch(IllegalArgumentException e){
            System.err.println("입력 값 오류");
            return -1;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive) + 1;
    }
}
