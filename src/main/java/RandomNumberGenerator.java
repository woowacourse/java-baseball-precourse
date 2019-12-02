import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * RandomNumberGenerator 클래스는 자릿수에 걸맞는 임의의 난수 조합을 생성합니다.
 */
public class RandomNumberGenerator {
    private static int digit;

    public RandomNumberGenerator(int digit) {
        RandomNumberGenerator.digit = digit;
    }

    public List generate() {
        boolean[] usedNumber = new boolean[10];         //생성한 랜덤 넘버가 이미 사용됐는지 확인
        Arrays.fill(usedNumber, true);
        List<Integer> randomAry = new ArrayList<>();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < digit; i++) {
            int current = random.nextInt(10);
            if (usedNumber[current]) {
                usedNumber[current] = false;
                randomAry.add(current);
            } else {
                i -= 1;
            }
        }
        return randomAry;
    }

}
