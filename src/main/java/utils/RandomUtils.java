package utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int INPUT_NUM = 3;
    public int[] comNumbers;

    private RandomUtils() {
        comNumbers=new int[INPUT_NUM];
        for(int i=0;i<INPUT_NUM;i++){
            //comNumbers에 들어갈 숫자를 nextInt 함수의 호출로 지정
            comNumbers[i]=nextInt(0,9);
        }
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
