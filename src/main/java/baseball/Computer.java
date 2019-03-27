package baseball;

public class Computer {
    private String digits;
    private int length;

    public Computer(int length) {
        this.length = length;
    }

    public void generateDigits() {
        StringBuilder sbDigit = new StringBuilder();

        int index = 0;
        while (index < length) {
            int digit = (int) (Math.random() * 9) + 1;

            if (isDigitDifferent(sbDigit.toString(), digit)) {
                sbDigit.append(digit);
                index++;
            }
        }

        digits = sbDigit.toString();
    }

    private boolean isDigitDifferent(String sbDigit, int digit) {
        for (char c : sbDigit.toCharArray()) {
            if (c-48 == digit) // 1의 ASCII = 49
                return false;
        }
        return true;
    }

    public String getDigits() {
        return digits;
    }
}
