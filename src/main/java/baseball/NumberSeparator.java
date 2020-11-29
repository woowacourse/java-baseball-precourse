package baseball;

public class NumberSeparator {
    /**
     * 메서드 makeArray()는 3자리수 숫자를 첫째자리, 둘째자리, 셋째자리 순서로 integer 배열에 저장해 이를 리턴
     * @param number 3자리수 (타깃넘버나 유저인풋넘버)
     * @return digits number를 첫째자리, 둘째자리, 셋째짜리로 나누어 integer 배열로 저장해 리턴
     */
    public static int[] makeArray(int number) {
        int [] digits = new int[3];
        digits[0] = number/100;               /* 첫째자리 */
        digits[1] = (number/10)%10;           /* 둘째자리 */
        digits[2] = number%10;                /* 셋째자리 */
        return digits;
    }
}
