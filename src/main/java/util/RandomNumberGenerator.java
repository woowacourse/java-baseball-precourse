package util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author delf
 */
public class RandomNumberGenerator {
    private static Random r = new Random();

    /**
     * @param n   생성할 난수의 수
     * @param min 생성 난수의 최솟값
     * @param max 생성 난수의 최댓값
     * @return min과 max 사이에서 중복되지 않는 크기가 n인 난수(정수)가 담겨있는 RandomNumbers 객체
     * @see util.RandomNumberGenerator.RandomNumbers
     */
    public static RandomNumbers getUniqueNumbers(int n, int min, int max) {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < n) {
            set.add(r.nextInt(max - min) + min);
        }

        return new RandomNumbers(set);
    }


    /**
     * 생성된 난수를 저장하고 있는 객체. 임의의 값으로 반환 가능하다.
     */
    public static class RandomNumbers<E> {
        private Collection<E> numbers;

        RandomNumbers(Collection numbers) {
            this.numbers = numbers;
        }

        public String byString() {
            StringBuilder sb = new StringBuilder();
            for (E e : numbers) {
                sb.append(e);
            }
            return sb.toString();
        }
    }
}
