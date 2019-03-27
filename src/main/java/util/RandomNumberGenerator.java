package util;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * 난수를 생성한다. 생성되는 난수는 정수이며, 생성되는 난수의 범위와 개수를 지정할 수 있다. 생성된 난수는
 * {@link RandomNumbers} 객체에 담아 반환한다.
 *
 * @see RandomNumbers
 * @author delf
 */
public class RandomNumberGenerator {
    private static Random r = new Random();

    /**
     * @param n   생성할 난수의 수
     * @param min 생성 난수의 최솟값
     * @param max 생성 난수의 최댓값
     * @return min과 max 사이에서 중복되지 않는 크기가 n인 난수(정수)가 담겨있는
     * {@link RandomNumbers} 객체
     *
     * @see RandomNumbers
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

        /**
         * 생성된 난수로 이루어진 문자열을 반환한다. 각 숫자 사이에는 공백을 포함하여 다른 문자이 없다.
         * 생성되는 랜덤 숫자가 두 자리 이상이라면 사용하지 않는 것이 좋다.
         *
         * @return 생성된 난수로 이루어진 문자열
         */
        public String byString() {
            StringBuilder sb = new StringBuilder();
            for (E e : numbers) {
                sb.append(e);
            }
            return sb.toString();
        }

        /**
         * @return 생성된 난수로 이루어진 정수 배열
         */
        public int[] byIntegerArray() {
            int[] result = new int[numbers.size()];
            int index = 0;
            for (E n : numbers) {
                result[index++] = (int) n;
            }
            return result;
        }
    }
}
