package baseball.resource.rule;

public enum NumberDigit {

    COUNT(3);

    private final int count;

    NumberDigit(int length) {
        this.count = length;
    }

    public static int getCount() {
        return COUNT.count;
    }

    public static boolean isMatch(int count) {
        return (COUNT.count == count);
    }

    public static boolean isNotMatch(int count) {
        return !(NumberDigit.isMatch(count));
    }

}
