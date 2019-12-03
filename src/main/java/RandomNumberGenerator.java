/**
 * RandomNumberGenerator 클래스는 자릿수에 걸맞는 임의의 난수 조합을 생성합니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public List generate(int digit) {
        boolean[] usedNumber = new boolean[10];         //생성한 랜덤 넘버가 이미 사용됐는지 확인
        Arrays.fill(usedNumber, false);
        List<Integer> target = new ArrayList<>();

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < digit; i++) {
            int current = random.nextInt(10);
            if (!usedNumber[current]) {
                usedNumber[current] = true;
                target.add(current);
                continue;
            }
            i -= 1; //만약 중복되는 값이 나왔다면 다시 한번 진행
        }
        return target;
    }

}