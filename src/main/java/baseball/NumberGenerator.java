package baseball;

import utils.RandomUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 각 자릿수가 서로 다른 랜덤숫자를 만드는 NumberGenerator
 * @author 성시형
 * @version 1.0
 */
public class NumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 9;

    /**
     * 랜덤 숫자를 리턴한다.
     * @param digit 자릿수
     *              해당 자릿수의 숫자를 생성한다.
     * @return 각 자릿수가 서로 다른 랜덤 숫자
     * @throws IllegalArgumentException digit이 0보다 작거나 9보다 크면 throw
     */
    public static String randomNumberGenerate(final int digit) {
        Set<String> duplicateChecker = new HashSet<>();
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("자릿수가 올바르지 않습니다.");
        }
        while (duplicateChecker.size() < digit) {
            duplicateChecker.add(String.valueOf(RandomUtils.nextInt(MIN, MAX)));
        }
        return String.join("", duplicateChecker);
    }
}
