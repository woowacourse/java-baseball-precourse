public class BaseNumber {
    public static final int BASE_NUMBER_MIN = 1;
    public static final int BASE_NUMBER_MAX = 9;
    private int number;

    public BaseNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
} 
