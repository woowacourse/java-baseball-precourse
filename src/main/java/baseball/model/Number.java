/**
 * Number.java
 * 한자리의 숫자를 담을 Wrapper 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */

package baseball.model;

public class Number {
    public static final int MIN = 1;
    public static final int MAX = 9;
    private static final String INVALID_RANGE = "1~9 사이의 숫자가 아닙니다.";

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    /* int값을 인자로 받아 Number 객체를 생성하는 메소드 */
    public static Number from(int number) {
        if (number < MIN || MAX < number) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
        return new Number(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Number paramObj = (Number) obj;
        return this.number == paramObj.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }

    @Override
    public String toString() {
        return Integer.toString(this.number);
    }
}
