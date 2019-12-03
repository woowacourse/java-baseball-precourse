/*
 * 클래스 이름 : NumberCard
 *
 * 버전 정보 : 1.0
 *
 * 날짜 : 2019.12.3
 *
 * 저작권 주의 : https://github.com/takhyeongmin
 */

package domain;

public class NumberCard {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private Integer number;

    public NumberCard(Integer number) {
        this.number = number;
    }

    public Integer of() {
        checkValid(number);
        return number;
    }

    private static void checkValid(Integer number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("0~9 이외의 값 입력 오류 발생");
        }
    }

}
