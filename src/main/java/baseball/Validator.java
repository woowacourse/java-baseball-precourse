package baseball;

public class Validator {
    public boolean[] numberChecked = new boolean[10];

    public void validateNumberInput(String numberInputStr) {
        this.initNumberChecked();

        int length = numberInputStr.length();
        if (length != 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < length; i++) {
            char ch = numberInputStr.charAt(i);
            int digit = ch - '0';

            // 1부터 9까지의 숫자가 아닌 digit => 유효하지 않음
            if (!(1 <= digit && digit <= 9)) {
                throw new IllegalArgumentException();
            }

            // 중복된 digit의 등장 => 유효하지 않음
            if (numberChecked[digit]) {
                throw new IllegalArgumentException();
            } else {
                numberChecked[digit] = true;
            }
        }
    }

    public void validateDecisionInput(String decisionInputStr) {
        int length = decisionInputStr.length();
        if (length != 1) {
            throw new IllegalArgumentException();
        }

        char ch = decisionInputStr.charAt(0);
        if (!(ch == '1' || ch == '2')) {
            throw new IllegalArgumentException();
        }
    }

    public void initNumberChecked() {
        for (int i = 1; i <= 9; i++) {
            numberChecked[i] = false;
        }
    }
}
