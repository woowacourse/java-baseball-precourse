package util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author delf
 */
public class RandomNumberGenerator {
    private static Random r = new Random();

    /**
     *
     * @param n 생성할 난수의 수
     * @param limit 생성할 난수의 한계
     * @return 0과 limit 사이에서 중복되지 않는 크기가 n인 난수(정수) 배열
     */
    public static int[] getUniqueNumbers(int n, int limit) {
        Set<Integer> set = new HashSet<>(n);
        while (set.size() < n) {
            set.add(r.nextInt(limit));
        }

        int index = 0;
        int[] result = new int[n];
        for (int c : set) {
            result[index++] = c;
        }
        // return set.stream().mapToInt(Number::intValue).toArray(); // 스트림을 사용할 경우
        return result;
    }
}
