public class BaseNumber {
    public static final int BASE_NUMBER_MIN = 1;
    public static final int BASE_NUMBER_MAX = 9;
    private int number;

    public BaseNumber(int number) {
        assertNumber(number);
        this.number = number;
    }

    private void assertNumber(int number) {
        if((BASE_NUMBER_MIN > number) || (number > BASE_NUMBER_MAX)) {
            throw new IllegalArgumentException("1에서 9까지의 값을 입력해주세요");
        }
    }

    public int getNumber() {
        return number;
    }

    public static BaseNumber valueOf(int number) {
        return new BaseNumber(number);
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }
} 
